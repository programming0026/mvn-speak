package com.juniverse.speak.dto;

/**
 * Ajustes de la voz: estabilidad, similitud, estilo y refuerzo de locutor.
 *
 * @author Java Universe
 */
public class VoiceSettingsDTO {

    private float stability;
    private float similarity_boost;
    private float style;
    private Boolean use_speaker_boost;

    /** Estabilidad de la voz (0-1). */
    public float getStability() {
        return stability;
    }

    /** Asigna: estabilidad de la voz (0-1). */
    public void setStability(float stability) {
        this.stability = stability;
    }

    /** Refuerzo de similitud (0-1). */
    public float getSimilarityBoost() {
        return similarity_boost;
    }

    /** Asigna: refuerzo de similitud (0-1). */
    public void setSimilarityBoost(float similarity_boost) {
        this.similarity_boost = similarity_boost;
    }

    /** Exageración de estilo (0-1). */
    public float getStyle() {
        return style;
    }

    /** Asigna: exageración de estilo (0-1). */
    public void setStyle(float style) {
        this.style = style;
    }

    /** Refuerzo de locutor. */
    public Boolean getUseSpeakerBoost() {
        return use_speaker_boost;
    }

    /** Asigna: refuerzo de locutor. */
    public void setUseSpeakerBoost(Boolean use_speaker_boost) {
        this.use_speaker_boost = use_speaker_boost;
    }

}
