package main.postgresserver.springboot.Theme;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe che rappresenta una chiave primaria composta per l'entità {@link Theme}.
 * <p>
 * Questa classe implementa {@link Serializable} e viene utilizzata come chiave primaria composta
 * per la tabella {@link Theme} nel database. La chiave primaria è composta dal campo {@code id}
 * e dal campo {@code theme}.
 * </p>
 */
@Embeddable
public class ThemeId implements Serializable {

    /**
     * Identificatore univoco per il tema cinematografico.
     * <p>
     * Il campo {@code id} rappresenta l'identificativo del tema, utilizzato per distinguere tra diversi temi all'interno
     * del sistema.
     * </p>
     */
    private Long id;

    /**
     * Nome del tema cinematografico.
     * <p>
     * Il campo {@code theme} rappresenta il nome o la descrizione del tema cinematografico associato al film o
     * all'analisi tematica. Può essere utilizzato per categorizzare i film in base ai loro contenuti tematici.
     * </p>
     */
    private String theme;


    /**
     * Costruttore di default per {@link ThemeId}.
     * Inizializza una nuova istanza senza valori iniziali.
     */
    public ThemeId() {
    }

    /**
     * Costruttore per inizializzare una nuova chiave primaria composta.
     *
     * @param id     l'ID del tema
     * @param theme  il nome del tema
     */
    public ThemeId(Long id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    /**
     * Restituisce l'ID del tema.
     *
     * @return l'ID del tema
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID del tema.
     *
     * @param id l'ID del tema
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del tema.
     *
     * @return il nome del tema
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Imposta il nome del tema.
     *
     * @param theme il nome del tema
     */
    public void setTheme(String theme) {
        this.theme = theme;
    }

    /**
     * Confronta questa istanza con un altro oggetto per verificarne l'uguaglianza.
     * Due oggetti {@link ThemeId} sono considerati uguali se l'ID e il tema sono uguali.
     *
     * @param o l'oggetto da confrontare
     * @return {@code true} se gli oggetti sono uguali, altrimenti {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ThemeId)) return false;
        ThemeId that = (ThemeId) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getTheme(), that.getTheme());
    }

    /**
     * Restituisce il codice hash dell'oggetto.
     * Il codice hash è calcolato utilizzando l'ID e il tema.
     *
     * @return il codice hash dell'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTheme());
    }
}
