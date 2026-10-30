package main.postgresserver.springboot.Releases;

import jakarta.persistence.*;

/**
 * Entità che rappresenta una release di un film.
 * <p>
 * La classe {@link Release} è mappata alla tabella "releases" nel database e contiene informazioni relative
 * alla release di un film, come il paese, la data, il tipo di release e il rating.
 * </p>
 */
@Entity
@Table(name="releases")
public class Release {

    /**
     * ID univoco per identificare l'entità.
     */
    @Id
    @Column(name="id")
    private Long id;

    /**
     * Paese associato all'entità, rappresentato come una stringa.
     */
    @Column(name="country")
    private String country;

    /**
     * Data associata all'entità, rappresentata come una stringa.
     */
    @Column(name="date")
    private String date;

    /**
     * Tipo dell'entità, rappresentato come una stringa.
     */
    @Column(name="type")
    private String type;

    /**
     * Valutazione associata all'entità, rappresentata come una stringa.
     */
    @Column(name="rating")
    private String rating;


    /**
     * Costruttore di default per la classe {@link Release}.
     * Questo costruttore è necessario per la corretta creazione di un'istanza di {@link Release}
     * tramite JPA (Java Persistence API).
     */
    public Release() {}

    /**
     * Costruttore che inizializza tutti i campi della classe {@link Release}.
     * @param id l'ID della release
     * @param country il paese della release
     * @param date la data della release
     * @param type il tipo di release
     * @param rating il rating associato alla release
     */
    public Release(Long id, String country, String date, String type, String rating) {
        this.id = id;
        this.country = country;
        this.date = date;
        this.type = type;
        this.rating = rating;
    }

    /**
     * Restituisce l'ID della release.
     * @return l'ID della release
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID della release.
     * @param id l'ID della release
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il paese della release.
     * @return il paese della release
     */
    public String getCountry() {
        return country;
    }

    /**
     * Imposta il paese della release.
     * @param country il paese della release
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Restituisce la data della release.
     * @return la data della release
     */
    public String getDate() {
        return date;
    }

    /**
     * Imposta la data della release.
     * @param date la data della release
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Restituisce il tipo della release.
     * @return il tipo della release
     */
    public String getType() {
        return type;
    }

    /**
     * Imposta il tipo della release.
     * @param type il tipo della release
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Restituisce il rating della release.
     * @return il rating della release
     */
    public String getRating() {
        return rating;
    }

    /**
     * Imposta il rating della release.
     * @param rating il rating della release
     */
    public void setRating(String rating) {
        this.rating = rating;
    }
}
