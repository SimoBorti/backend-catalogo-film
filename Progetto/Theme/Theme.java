package main.postgresserver.springboot.Theme;

import jakarta.persistence.*;

/**
 * Classe che rappresenta il tema di un film, con una chiave primaria composta.
 * <p>
 * La classe è mappata sulla tabella {@code themes} nel database, dove ogni riga rappresenta un tema
 * associato a un {@code id}. La chiave primaria è composta dall'{@code id} e dal {@code theme}.
 * </p>
 */
@Entity
@Table(name = "themes",
        indexes = {
                @Index(name = "idx_theme_id_theme", columnList = "id, theme"),
                @Index(name = "idx_themes_theme", columnList = "theme")
        }
        )
@IdClass(ThemeId.class)
public class Theme {

    /**
     * Rappresenta l'identificatore univoco per l'entità.
     * <p>
     * Il campo {@code id} è annotato con {@link Id}, indicando che è la chiave primaria dell'entità.
     * Il suo valore è un identificatore numerico univoco assegnato a ciascun record nella tabella corrispondente.
     * </p>
     */
    @Id
    private Long id;

    @Id
    @Column(name = "theme",columnDefinition = "text")
    private String theme;

    /**
     * Costruttore per creare un oggetto {@link Theme} con i parametri specificati.
     *
     * @param id l'id del tema
     * @param theme il nome del tema
     */
    public Theme(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    /**
     * Costruttore di default per {@link Theme}.
     * Crea un'istanza senza inizializzare i valori dei campi.
     */
    public Theme() {}

    /**
     * Ottiene l'id del tema.
     *
     * @return l'id del tema
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'id del tema.
     *
     * @param id l'id da impostare
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Ottiene il nome del tema.
     *
     * @return il nome del tema
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Imposta il nome del tema.
     *
     * @param theme il nome del tema da impostare
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }
}
