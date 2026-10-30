package com.juniverse.speak.dto;

import java.util.List;

/**
 * Respuesta con la lista de voces disponibles.
 *
 * @author linux
 */
public class ResponseSpeakDTO {

    private List<VoicesDTO> voices;

    /** Lista de voces. */
    public List<VoicesDTO> getVoices() {
        return voices;
    }

    /** Asigna: lista de voces. */
    public void setVoices(List<VoicesDTO> voices) {
        this.voices = voices;
    }

}
