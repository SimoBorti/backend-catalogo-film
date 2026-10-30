package main.postgresserver.springboot.Genres;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe che rappresenta una chiave primaria composta per l'entità Genre.
 * Utilizzata in un contesto di mappatura JPA per rappresentare la combinazione
 * di id e genre come una singola chiave primaria.
 */
@Embeddable
public class GenreId implements Serializable {
    /**
     * L'id del genere.
     * Utilizzato come parte della chiave primaria composta per l'entità Genre.
     */
    private Long id;

    /**
     * Il nome del genere.
     * Utilizzato come parte della chiave primaria composta per l'entità Genre.
     */
    private String genre;


    /**
     * Costruttore di default per la classe GenreId.
     * Necessario per la serializzazione.
     */
    public GenreId() {}

    /**
     * Costruttore che inizializza il GenreId con id e genre.
     *
     * @param id L'id del genere.
     * @param genre Il nome del genere.
     */
    public GenreId(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    // Getter e Setter

    /**
     * Ottiene l'id del genere.
     *
     * @return L'id del genere.
     */
    public Long getId() { return id; }

    /**
     * Imposta l'id del genere.
     *
     * @param id L'id del genere.
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Ottiene il nome del genere.
     *
     * @return Il nome del genere.
     */
    public String getGenre() { return genre; }

    /**
     * Imposta il nome del genere.
     *
     * @param genre Il nome del genere.
     */
    public void setGenre(String genre) { this.genre = genre; }

    /**
     * Override del metodo equals. Confronta due oggetti GenreId per verificare se sono uguali.
     *
     * @param o L'oggetto da confrontare.
     * @return true se gli oggetti sono uguali, altrimenti false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenreId genreId = (GenreId) o;
        return Objects.equals(id, genreId.id) &&
                Objects.equals(genre, genreId.genre);
    }

    /**
     * Override del metodo hashCode. Genera un hash code per l'oggetto GenreId.
     *
     * @return Un valore hash per l'oggetto.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, genre);
    }
}
