package com.juniverse.speak;

import com.juniverse.speak.client.Speak;
import com.juniverse.speak.client.SpeakImpl;
import com.juniverse.speak.dto.ResponseSpeakDTO;
import com.juniverse.speak.dto.VoicesDTO;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.util.logging.Logger;
import java.util.logging.Level;
/**
 * Ejemplo: toma la primera voz disponible de ElevenLabs, convierte un texto en voz, lo guarda como MP3 y lo reproduce.
 *
 * @author linux
 */
public class Main {
    private static final Logger LOGGER = AppLogger.get(Main.class);


    /** La clave se lee de la variable de entorno ELEVENLABS_API_KEY para no escribirla en el código. */
    private static final String API_KEY = System.getenv("ELEVENLABS_API_KEY");

    /**
     * Convierte "Hello" en voz con la primera voz de la cuenta, lo guarda en {@code output.mp3} y lo reproduce.
     * @param args no se usan
     */
    public static void main(String[] args) {
        try {
            if (API_KEY == null || API_KEY.isBlank()) {
                LOGGER.severe("Defina la variable de entorno ELEVENLABS_API_KEY con su clave de ElevenLabs.");
                return;
            }
            Speak speak = new SpeakImpl();
            ResponseSpeakDTO voices = speak.getVoices(API_KEY);
            Optional<VoicesDTO> voice = voices.getVoices() == null
                    ? Optional.empty() : voices.getVoices().stream().findFirst();
            if (voice.isEmpty()) {
                LOGGER.severe("La cuenta no tiene voces disponibles.");
                return;
            }
            InputStream input = speak.textToSpeech(API_KEY, voice.get().getVoiceId(), "Hello");
            InputStream[] audio = copyInput(input);
            saveToFile(audio[0], "output.mp3");
            playAudio(audio[1]);
        } catch (IOException | InterruptedException | JavaLayerException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    /**
     * Copia un flujo en memoria para poder leerlo dos veces (guardarlo y reproducirlo).
     * @param input flujo original
     * @return dos flujos independientes con el mismo contenido
     * @throws IOException si falla la lectura
     */
    public static InputStream[] copyInput(InputStream input) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        byte[] bytes = baos.toByteArray();
        InputStream is1 = new ByteArrayInputStream(bytes);
        InputStream is2 = new ByteArrayInputStream(bytes);
        return new InputStream[]{is1, is2};
    }

    /**
     * Reproduce un MP3 y espera a que termine.
     * @param input audio MP3
     * @throws JavaLayerException si no se puede reproducir
     */
    public static void playAudio(final InputStream input) throws JavaLayerException {
        AdvancedPlayer player = new AdvancedPlayer(input,
                javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());

        player.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackStarted(PlaybackEvent evt) {
                LOGGER.info("Playback started");
            }

            @Override
            public void playbackFinished(PlaybackEvent evt) {
                LOGGER.info("Playback finished");
            }
        });

        player.play();
    }

    /**
     * Guarda un flujo en un archivo.
     * @param input datos a guardar (si es null no hace nada)
     * @param filePath ruta del archivo
     */
    public static void saveToFile(final InputStream input, String filePath) {
        try {
            if (input != null) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(filePath); 
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
                    byte[] bytes = input.readAllBytes();
                    bufferedOutputStream.write(bytes, 0, bytes.length);
                    bufferedOutputStream.flush();
                }
            }
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

}
