package main.postgresserver.springboot.Oscar;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * La classe {@code OscarAwardId} rappresenta l'ID composto per l'entità {@link OscarAward}.
 * Questa classe viene utilizzata per identificare in modo univoco un premio Oscar assegnato a un film,
 * utilizzando i seguenti attributi:
 * <ul>
 *     <li>anno del film ({@link #yearFilm})</li>
 *     <li>categoria del premio ({@link #category})</li>
 *     <li>nome del premiato ({@link #name})</li>
 *     <li>titolo del film ({@link #film})</li>
 * </ul>
 * La classe implementa l'interfaccia {@link Serializable}, il che consente di serializzare l'ID per essere
 * utilizzato come chiave primaria composta nella tabella {@code the_oscar_awards}.
 */
@Embeddable
public class OscarAwardId implements Serializable {

    /**
     * Anno di uscita del film premiato.
     */
    private int yearFilm;

    /**
     * Categoria del premio Oscar (ad esempio, "Miglior attore").
     */
    private String category;

    /**
     * Nome del premiato.
     */
    private String name;

    /**
     * Titolo del film premiato.
     */
    private String film;

    /**
     * Costruttore vuoto della classe {@code OscarAwardId}.
     * Questo costruttore è necessario per la corretta gestione della serializzazione.
     */
    public OscarAwardId() {}

    /**
     * Restituisce l'anno di uscita del film premiato.
     *
     * @return l'anno del film
     */
    public int getYearFilm() {
        return yearFilm;
    }

    /**
     * Imposta l'anno di uscita del film premiato.
     *
     * @param yearFilm l'anno del film
     */
    public void setYearFilm(int yearFilm) {
        this.yearFilm = yearFilm;
    }

    /**
     * Restituisce la categoria del premio Oscar.
     *
     * @return la categoria del premio
     */
    public String getCategory() {
        return category;
    }

    /**
     * Imposta la categoria del premio Oscar.
     *
     * @param category la categoria del premio
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Restituisce il nome del premiato.
     *
     * @return il nome del premiato
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome del premiato.
     *
     * @param name il nome del premiato
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce il titolo del film premiato.
     *
     * @return il titolo del film
     */
    public String getFilm() {
        return film;
    }

    /**
     * Imposta il titolo del film premiato.
     *
     * @param film il titolo del film
     */
    public void setFilm(String film) {
        this.film = film;
    }

    /**
     * Confronta questa istanza di {@code OscarAwardId} con un altro oggetto per verificare se sono uguali.
     * Due istanze di {@code OscarAwardId} sono considerate uguali se tutti i loro attributi sono uguali.
     *
     * @param o l'oggetto da confrontare
     * @return {@code true} se gli oggetti sono uguali, {@code false} altrimenti
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OscarAwardId that = (OscarAwardId) o;
        return yearFilm == that.yearFilm &&
                Objects.equals(category, that.category) &&
                Objects.equals(name, that.name) &&
                Objects.equals(film, that.film);
    }

    /**
     * Calcola l'hash code per questa istanza di {@code OscarAwardId}.
     * L'hash code viene calcolato sulla base degli attributi della classe.
     *
     * @return l'hash code dell'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(yearFilm, category, name, film);
    }
}
