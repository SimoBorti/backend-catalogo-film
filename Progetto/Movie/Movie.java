package main.postgresserver.springboot.Movie;

import jakarta.persistence.*;
import main.postgresserver.springboot.Actor.Actor;
import main.postgresserver.springboot.Countries.Country;
import main.postgresserver.springboot.Crew.Crew;
import main.postgresserver.springboot.Genres.Genre;
import main.postgresserver.springboot.Languages.Language;
import main.postgresserver.springboot.Studios.Studio;
import main.postgresserver.springboot.Theme.Theme;

import java.util.List;
import java.util.Set;

/**
 * Entità che rappresenta un film nel sistema.
 * Ogni film ha informazioni relative al titolo, descrizione, data di uscita, durata,
 * rating, tagline e le entità correlate come generi, paesi, troupe, lingue, studi e attori.
 */
@Entity
@Table(name = "movies", indexes = {
        @Index(name = "idx_movies_title_date_rating", columnList = "name,date,rating"),
        @Index(name = "idx_movies", columnList = "Id")
})
public class Movie {

    /**
     * ID univoco del film.
     * Questo campo è la chiave primaria della tabella {@code movies}.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    /**
     * Titolo del film.
     * Questo campo contiene il nome del film, rappresentato come testo.
     */
    @Column(name = "name", columnDefinition = "text")
    private String titolo;

    /**
     * Descrizione del film.
     * Questo campo contiene una breve descrizione del film, rappresentata come testo.
     */
    @Column(name = "description", columnDefinition = "text")
    private String descrizione;

    /**
     * Anno di uscita del film.
     * Questo campo rappresenta l'anno in cui il film è stato distribuito.
     */
    @Column(name = "date")
    private Integer data;

    /**
     * Durata del film in minuti.
     * Questo campo indica il numero di minuti della durata totale del film.
     */
    @Column(name = "minute")
    private Integer minute;

    /**
     * Rating del film.
     * Questo campo rappresenta il punteggio medio del film, in genere espresso come valore decimale.
     */
    @Column(name = "rating")
    private Double rating;

    /**
     * Tagline del film.
     * Questo campo contiene una breve frase promozionale che descrive il film, solitamente usata nelle campagne pubblicitarie.
     */
    @Column(name = "tagline")
    private String tagline;


    /**
     * Lista dei generi del film.
     */
    @OneToMany
    @JoinColumn(name = "id")
    private Set<Genre> genres;

    /**
     * Lista dei paesi in cui il film è stato prodotto.
     */
    @OneToMany
    @JoinColumn(name = "id")
    private Set<Country> countries;

    /**
     * Lista dei membri della troupe che hanno lavorato al film.
     */
    @OneToMany
    @JoinColumn(name = "id")
    private Set<Crew> crews;

    /**
     * Lista delle lingue in cui il film è disponibile.
     */
    @OneToMany
    @JoinColumn(name = "id")
    private Set<Language> languages;

    /**
     * Lista degli studi che hanno prodotto il film.
     */
    @OneToMany
    @JoinColumn(name = "id")
    private Set<Studio> studios;

    /**
     * Lista degli attori che hanno partecipato al film.
     */
    @OneToMany
    @JoinColumn(name = "id")
    private Set<Actor> actors;


    @OneToMany
    @JoinColumn(name = "id")
    private Set<Theme> themes;

    /**
     * Link al poster del film.
     */
    @Transient
    private String posterLink;

    /**
     * Costruttore vuoto per la classe {@link Movie}.
     */
    public Movie() {}

    /**
     * Costruttore per inizializzare un film con i dati principali.
     *
     * @param id         L'ID del film.
     * @param titolo     Il titolo del film.
     * @param descrizione La descrizione del film.
     * @param data       La data di uscita del film.
     * @param minute     La durata del film in minuti.
     * @param rating     Il rating del film.
     * @param tagline    La tagline del film.
     */
    public Movie(long id, String titolo, String descrizione, Integer data, Integer minute, Double rating, String tagline) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.minute = minute;
        this.rating = rating;
        this.tagline = tagline;
    }

    /**
     * Getters e setters per tutti i campi
     */
    public long getId() {
        return id;
    }

    /**
     * Imposta l'ID del film.
     *
     * @param id L'ID del film.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Restituisce il titolo del film.
     * @return Titolo del film.
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Imposta il titolo del film.
     *
     * @param titolo il titolo del film
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Restituisce la descrizione del film.
     * @return La descrizione del film.
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * Imposta la descrizione del film.
     *
     * @param descrizione la descrizione del film
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Restituisce l'anno di uscita del film.
     * @return Anno di uscita del film, espresso come intero.
     */
    public Integer getData() {
        return data;
    }

    /**
     * Imposta l'anno di uscita del film.
     *
     * @param data Anno di uscita del film, espresso come intero.
     */
    public void setData(Integer data) {
        this.data = data;
    }

    /**
     * Restituisce la durata del film in minuti.
     * @return La durata del film in minuti.
     */
    public Integer getMinute() {
        return minute;
    }

    /**
     * Imposta la durata del film in minuti.
     *
     * @param minute La durata del film in minuti.
     */
    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    /**
     * Restituisce il punteggio del film, espresso come un valore decimale.
     * @return Il punteggio del film.
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Imposta il punteggio del film.
     *
     * @param rating Il punteggio del film, espresso come valore decimale.
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }

    /**
     * Restituisce la tagline del film.
     * @return La tagline del film.
     */
    public String getTagline() {
        return tagline;
    }

    /**
     * Imposta la tagline del film.
     * @param tagline la tagline del film.
     */
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    /**
     * Restituisce i generi del film.
     * @return I generi del film.
     */
    public Set<Genre> getGenres() {
        return genres;
    }

    /**
     * Imposta i generi del film.
     * @param genres i generi del film.
     */
    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    /**
     * Restituisce i paesi del film.
     * @return I paesi del film.
     */
    public Set<Country> getCountries() {
        return countries;
    }

    /**
     * Imposta i paesi del film.
     * @param countries i paesi del film.
     */
    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    /**
     * Restituisce i membri della crew del film.
     * @return I membri della crew del film.
     */
    public Set<Crew> getCrews() {
        return crews;
    }

    /**
     * Imposta i membri della crew del film.
     * @param crews i membri della crew del film.
     */
    public void setCrews(Set<Crew> crews) {
        this.crews = crews;
    }

    /**
     * Restituisce le lingue del film.
     * @return Le lingue del film.
     */
    public Set<Language> getLanguages() {
        return languages;
    }

    /**
     * Imposta le lingue del film.
     * @param languages le lingue del film.
     */
    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }

    public Set<Theme> getThemes() {
        return themes;
    }

    /**
     * Imposta le lingue del film.
     * @param themes le lingue del film.
     */
    public void setThemes(Set<Theme> themes) {
        this.themes = themes;
    }


    /**
     * Restituisce gli studi del film.
     * @return Gli studi del film.
     */
    public Set<Studio> getStudios() {
        return studios;
    }

    /**
     * Imposta gli studi del film.
     * @param studios gli studi del film.
     */
    public void setStudios(Set<Studio> studios) {
        this.studios = studios;
    }

    /**
     * Restituisce gli attori del film.
     * @return Gli attori del film.
     */
    public Set<Actor> getActors() {
        return actors;
    }

    /**
     * Imposta gli attori del film.
     * @param actors gli attori del film.
     */
    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    /**
     * Restituisce il link al poster del film.
     * @return Il link al poster del film.
     */
    public String getPosterLink() {
        return posterLink;
    }

    /**
     * Imposta il link al poster del film.
     * @param posterLink il link al poster del film.
     */
    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }
}
