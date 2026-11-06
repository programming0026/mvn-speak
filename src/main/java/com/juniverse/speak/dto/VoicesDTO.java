package com.juniverse.speak.dto;

import java.util.List;

/**
 * Una voz disponible en ElevenLabs.
 *
 * @author Java Universe
 */
public class VoicesDTO {

    private String voice_id;

    private String name;

    private String preview_url;

    private LabelDTO labels;
    
    private String category;

    private List<String> high_quality_base_model_ids;

    /** Categoría de la voz. */
    public String getCategory() {
        return category;
    }

    /** Asigna: categoría de la voz. */
    public void setCategory(String category) {
        this.category = category;
    }
    
    /** Modelos base de alta calidad. */
    public List<String> getHighQualityBaseModelIds() {
        return high_quality_base_model_ids;
    }

    /** Asigna: modelos base de alta calidad. */
    public void setHighQualityBaseModelIds(List<String> high_quality_base_model_ids) {
        this.high_quality_base_model_ids = high_quality_base_model_ids;
    }

    /** Etiquetas de la voz. */
    public LabelDTO getLabels() {
        return labels;
    }

    /** Asigna: etiquetas de la voz. */
    public void setLabels(LabelDTO labels) {
        this.labels = labels;
    }

    /** Identificador de la voz. */
    public String getVoiceId() {
        return voice_id;
    }

    /** Asigna: identificador de la voz. */
    public void setVoiceId(String voice_id) {
        this.voice_id = voice_id;
    }

    /** Nombre de la voz. */
    public String getName() {
        return name;
    }

    /** Asigna: nombre de la voz. */
    public void setName(String name) {
        this.name = name;
    }

    /** URL de una muestra de audio. */
    public String getPreviewUrl() {
        return preview_url;
    }

    /** Asigna: URL de una muestra de audio. */
    public void setPreviewUrl(String preview_url) {
        this.preview_url = preview_url;
    }

    /** Representación en texto de la voz. */
    @Override
    public String toString() {
        return "Voices{" + "voice_id=" + voice_id + ", name=" + name + ", preview_url=" + preview_url + ", labels=" + labels + ", high_quality_base_model_ids=" + high_quality_base_model_ids + '}';
    }

   
}
