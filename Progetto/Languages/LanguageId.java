package main.postgresserver.springboot.Languages;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Rappresenta la chiave primaria composta per l'entità `Language`.
 * Utilizzata per identificare in modo univoco un linguaggio in combinazione con
 * l'id e il tipo del linguaggio.
 */
@Embeddable
public class LanguageId implements Serializable {

    /**
     * L'ID associato al linguaggio.
     * Rappresenta un identificatore univoco per il linguaggio in combinazione con il tipo e il nome.
     */
    private Long id;

    /**
     * Il tipo di linguaggio.
     * Indica una categorizzazione del linguaggio, come "primary" o "secondary".
     */
    private String type;

    /**
     * Il nome del linguaggio.
     * Rappresenta il nome del linguaggio, come "English", "Italian", ecc.
     */
    private String language;

    /**
     * Costruttore di default per la creazione di un oggetto `LanguageId`.
     */
    public LanguageId() {}

    /**
     * Costruttore per inizializzare un oggetto `LanguageId` con valori specifici.
     *
     * @param id L'ID associato al linguaggio.
     * @param type Il tipo di linguaggio (es. "primary", "secondary").
     * @param language Il nome del linguaggio (es. "English", "Italian").
     */
    public LanguageId(Long id, String type, String language) {
        this.id = id;
        this.type = type;
        this.language = language;
    }

    /**
     * Restituisce l'ID del linguaggio.
     *
     * @return L'ID del linguaggio.
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID del linguaggio.
     *
     * @param id L'ID del linguaggio da impostare.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il tipo di linguaggio.
     *
     * @return Il tipo di linguaggio.
     */
    public String getType() {
        return type;
    }

    /**
     * Imposta il tipo di linguaggio.
     *
     * @param type Il tipo di linguaggio da impostare.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Restituisce il nome del linguaggio.
     *
     * @return Il nome del linguaggio.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Imposta il nome del linguaggio.
     *
     * @param language Il nome del linguaggio da impostare.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Confronta questo oggetto `LanguageId` con un altro per determinare se sono uguali.
     *
     * @param o L'oggetto da confrontare con questo.
     * @return `true` se gli oggetti sono uguali, `false` altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LanguageId languageId = (LanguageId) o;
        return Objects.equals(id, languageId.id) &&
                Objects.equals(type, languageId.type) &&
                Objects.equals(language, languageId.language);
    }

    /**
     * Calcola l'hashcode di questo oggetto `LanguageId`.
     *
     * @return L'hashcode dell'oggetto `LanguageId`.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, type, language);
    }
}
