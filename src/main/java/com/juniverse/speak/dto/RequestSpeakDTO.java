package com.juniverse.speak.dto;

/**
 * Petición de texto a voz. La clave y el identificador de voz no se envían en el cuerpo JSON ({@code transient}).
 *
 * @author Java Universe
 */
public class RequestSpeakDTO {

    private String text;

    private String model_id;

    private transient String apiKey;

    private transient String voiceId;

    private VoiceSettingsDTO voice_settings;

    /** Clave de la API (no se envía en el cuerpo). */
    public String getApiKey() {
        return apiKey;
    }

    /** Asigna: clave de la API (no se envía en el cuerpo). */
    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    /** Identificador de la voz (va en la URL). */
    public String getVoiceId() {
        return voiceId;
    }

    /** Asigna: identificador de la voz (va en la URL). */
    public void setVoiceId(String voiceId) {
        this.voiceId = voiceId;
    }

    /** Texto a locutar. */
    public String getText() {
        return text;
    }

    /** Asigna: texto a locutar. */
    public void setText(String text) {
        this.text = text;
    }

    /** Modelo de ElevenLabs. */
    public String getModelId() {
        return model_id;
    }

    /** Asigna: modelo de ElevenLabs. */
    public void setModelId(String model_id) {
        this.model_id = model_id;
    }

    /** Ajustes de la voz. */
    public VoiceSettingsDTO getVoiceSettings() {
        return voice_settings;
    }

    /** Asigna: ajustes de la voz. */
    public void setVoiceSettings(VoiceSettingsDTO voice_settings) {
        this.voice_settings = voice_settings;
    }

}
