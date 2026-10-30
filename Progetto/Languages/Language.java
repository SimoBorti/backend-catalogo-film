package main.postgresserver.springboot.Languages;

import jakarta.persistence.*;

/**
 * Classe che rappresenta un'entità Language nel database.
 * Questa classe mappa la tabella 'languages' e utilizza una chiave primaria composta.
 */
@Entity
@Table(name = "languages", indexes = {
        @Index(name = "idx_languages_id_language", columnList = "id,language"),
        @Index(name = "idx_languages_language", columnList = "language")
})
@IdClass(LanguageId.class)
public class Language {

    /**
     * L'id dell'entità Language.
     * Rappresenta l'identificatore univoco di ogni linguaggio nel database.
     */
    @Id
    @Column(name = "id")
    private long id;

    /**
     * Il tipo associato al linguaggio.
     * Indica una categorizzazione o un tipo specifico del linguaggio, ad esempio, "programming" o "spoken".
     */
    @Id
    @Column(name = "type")
    private String type;

    /**
     * Il nome del linguaggio.
     * Rappresenta il nome del linguaggio (ad esempio, "Java", "English", ecc.).
     */
    @Id
    @Column(name = "language")
    private String language;

    /**
     * Costruttore vuoto per JPA.
     */
    public Language() {
    }

    /**
     * Costruttore per creare un oggetto Language con parametri.
     *
     * @param id L'id dell'entità Language.
     * @param type Il tipo associato al linguaggio.
     * @param language Il nome del linguaggio.
     */
    public Language(long id, String type, String language) {
        this.id = id;
        this.type = type;
        this.language = language;
    }

    /**
     * Ottiene l'id del linguaggio.
     *
     * @return L'id del linguaggio.
     */
    public long getId() {
        return id;
    }

    /**
     * Imposta l'id del linguaggio.
     *
     * @param id L'id del linguaggio.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Ottiene il tipo del linguaggio.
     *
     * @return Il tipo del linguaggio.
     */
    public String getType() {
        return type;
    }

    /**
     * Imposta il tipo del linguaggio.
     *
     * @param type Il tipo del linguaggio.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Ottiene il nome del linguaggio.
     *
     * @return Il nome del linguaggio.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Imposta il nome del linguaggio.
     *
     * @param language Il nome del linguaggio.
     */
    public void setLanguage(String language) {
        this.language = language;
    }
}
