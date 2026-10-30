package com.juniverse.speak.client;

import com.juniverse.speak.dto.RequestSpeakDTO;
import com.juniverse.speak.dto.ResponseSpeakDTO;
import java.io.IOException;
import java.io.InputStream;

/**
 * Cliente de la API de síntesis de voz de ElevenLabs.
 *
 * @author linux
 */
public interface Speak {

    /**
     * Lista las voces de la cuenta.
     * @param apiKey clave de la API
     * @return las voces
     * @throws IOException si falla la red o la API responde con error
     * @throws InterruptedException si se interrumpe la espera
     */
    ResponseSpeakDTO getVoices(String apiKey) throws IOException, InterruptedException;

    /**
     * Convierte texto en voz.
     * @param request texto, voz, modelo y ajustes
     * @return flujo de audio MP3
     * @throws IOException si falla la red o la API responde con error
     * @throws InterruptedException si se interrumpe la espera
     */
    InputStream textToSpeech(RequestSpeakDTO request) throws IOException, InterruptedException;

    /**
     * Convierte texto en voz con el modelo por defecto.
     * @param apiKey clave de la API
     * @param voiceId identificador de la voz
     * @param text texto a locutar
     * @return flujo de audio MP3
     * @throws IOException si falla la red o la API responde con error
     * @throws InterruptedException si se interrumpe la espera
     */
    InputStream textToSpeech(String apiKey, String voiceId, String text) throws IOException, InterruptedException;

    /**
     * Convierte texto en voz con el modelo indicado.
     * @param apiKey clave de la API
     * @param voiceId identificador de la voz
     * @param modelId modelo de ElevenLabs
     * @param text texto a locutar
     * @return flujo de audio MP3
     * @throws IOException si falla la red o la API responde con error
     * @throws InterruptedException si se interrumpe la espera
     */
    InputStream textToSpeech(String apiKey, String voiceId, String modelId, String text) throws IOException, InterruptedException;
}
