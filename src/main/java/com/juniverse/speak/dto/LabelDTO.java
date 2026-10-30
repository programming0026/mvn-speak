package com.juniverse.speak.dto;

/**
 * Etiquetas descriptivas de una voz (edad, acento, género, uso).
 *
 * @author linux
 */
public class LabelDTO {
    private String age;
    private String use_case;
    private String description;
    private String accent;
    private String gender;

    /** Edad de la voz. */
    public String getAge() {
        return age;
    }

    /** Asigna: edad de la voz. */
    public void setAge(String age) {
        this.age = age;
    }

    /** Caso de uso recomendado. */
    public String getUseCase() {
        return use_case;
    }

    /** Asigna: caso de uso recomendado. */
    public void setUseCase(String use_case) {
        this.use_case = use_case;
    }

    /** Descripción. */
    public String getDescription() {
        return description;
    }

    /** Asigna: descripción. */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Acento. */
    public String getAccent() {
        return accent;
    }

    /** Asigna: acento. */
    public void setAccent(String accent) {
        this.accent = accent;
    }

    /** Género. */
    public String getGender() {
        return gender;
    }

    /** Asigna: género. */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** Representación en texto de las etiquetas. */
    @Override
    public String toString() {
        return "Label{" + "age=" + age + ", use_case=" + use_case + ", description=" + description + ", accent=" + accent + ", gender=" + gender + '}';
    }
    
    
    
}
