package org.linden;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public class  Flashcard {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Size(min = 1, max = 100)
    @Column(length = 100)
    private String word;

    @NotEmpty
    @Size(min = 1, max = 100)
    @Column(length = 100)
    private String translation;

    @NotNull
    @Column(name = "target_language")
    private Language targetLanguage;

    @Column(name = "date_added")
    private LocalDate addedDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
    public Language getTargetLanguage() {
        return targetLanguage;
    }
    public void setTargetLanguage(Language targetLanguage) {
        this.targetLanguage = targetLanguage;
    }
    public LocalDate getAddedDate() {
        return addedDate;
    }
    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }
}
