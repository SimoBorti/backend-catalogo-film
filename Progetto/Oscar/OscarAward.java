package main.postgresserver.springboot.Oscar;

import jakarta.persistence.*;

/**
 * Rappresenta l'entità "OscarAward", che mappa la tabella "the_oscar_awards" nel database.
 * Ogni istanza di questa classe rappresenta un premio Oscar assegnato a un film in una determinata cerimonia.
 * La classe utilizza una chiave primaria composta da "yearFilm", "category", "name" e "film".
 */
@Entity
@Table(name = "the_oscar_awards", indexes = {
        @Index(name = "idx_oscars_film", columnList = "film"),
        @Index(name = "idx_oscars_year_film", columnList = "year_film"),
        @Index(name = "idx_oscars_winner", columnList = "winner"),
        @Index(name = "idx_oscars_category", columnList = "category")
})
@IdClass(OscarAwardId.class)
public class OscarAward {

    /**
     * Anno di uscita del film.
     */
    @Id
    @Column(name = "year_film")
    private int yearFilm;

    /**
     * Anno della cerimonia degli Oscar in cui è stato assegnato il premio.
     */
    @Column(name = "year_ceremony")
    private int yearCeremony;

    /**
     * Categoria del premio Oscar.
     */
    @Id
    private String category;

    /**
     * Nome della cerimonia in cui è stato assegnato il premio.
     */
    private String ceremony;

    /**
     * Nome del destinatario del premio (es. attore, regista, ecc.).
     */
    @Id
    @Column(length = 350)
    private String name;

    /**
     * Titolo del film vincitore del premio.
     */
    @Id
    private String film;

    /**
     * Indica se il premio è stato vinto (vero) o meno (falso).
     * Il valore predefinito è "false".
     */
    @Column(columnDefinition = "boolean default false")
    private boolean winner;

    /**
     * Costruttore che inizializza un oggetto OscarAward con i valori specificati.
     *
     * @param yearFilm Anno di uscita del film.
     * @param yearCeremony Anno della cerimonia degli Oscar.
     * @param category Categoria del premio Oscar.
     * @param name Nome del destinatario del premio.
     * @param film Titolo del film.
     * @param winner Indica se il premio è stato vinto.
     * @param ceremony Nome della cerimonia.
     */
    public OscarAward(int yearFilm, int yearCeremony, String category, String name, String film, boolean winner, String ceremony) {
        this.yearFilm = yearFilm;
        this.yearCeremony = yearCeremony;
        this.category = category;
        this.name = name;
        this.film = film;
        this.winner = winner;
        this.ceremony = ceremony;
    }

    /**
     * Costruttore vuoto per la creazione di oggetti OscarAward senza parametri.
     */
    public OscarAward() {}

    /**
     * Restituisce il nome della cerimonia.
     *
     * @return Nome della cerimonia.
     */
    public String getCeremony() {
        return ceremony;
    }

    /**
     * Imposta il nome della cerimonia.
     *
     * @param ceremony Nome della cerimonia.
     */
    public void setCeremony(String ceremony) {
        this.ceremony = ceremony;
    }

    /**
     * Restituisce l'anno di uscita del film.
     *
     * @return Anno di uscita del film.
     */
    public int getYearFilm() {
        return yearFilm;
    }

    /**
     * Imposta l'anno di uscita del film.
     *
     * @param yearFilm Anno di uscita del film.
     */
    public void setYearFilm(int yearFilm) {
        this.yearFilm = yearFilm;
    }

    /**
     * Restituisce l'anno della cerimonia degli Oscar.
     *
     * @return Anno della cerimonia.
     */
    public int getYearCeremony() {
        return yearCeremony;
    }

    /**
     * Imposta l'anno della cerimonia degli Oscar.
     *
     * @param yearCeremony Anno della cerimonia.
     */
    public void setYearCeremony(int yearCeremony) {
        this.yearCeremony = yearCeremony;
    }

    /**
     * Restituisce la categoria del premio Oscar.
     *
     * @return Categoria del premio Oscar.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Imposta la categoria del premio Oscar.
     *
     * @param category Categoria del premio Oscar.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Restituisce il nome del destinatario del premio.
     *
     * @return Nome del destinatario del premio.
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome del destinatario del premio.
     *
     * @param name Nome del destinatario del premio.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce il titolo del film vincitore del premio.
     *
     * @return Titolo del film vincitore.
     */
    public String getFilm() {
        return film;
    }

    /**
     * Imposta il titolo del film vincitore del premio.
     *
     * @param film Titolo del film.
     */
    public void setFilm(String film) {
        this.film = film;
    }

    /**
     * Restituisce se il premio è stato vinto o meno.
     *
     * @return "true" se il premio è stato vinto, "false" altrimenti.
     */
    public boolean isWinner() {
        return winner;
    }

    /**
     * Imposta lo stato del premio (vinto o meno).
     *
     * @param winner "true" se il premio è stato vinto, "false" altrimenti.
     */
    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
