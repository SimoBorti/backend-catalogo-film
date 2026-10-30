package main.postgresserver.springboot.Genres;

import jakarta.persistence.*;

/**
 * Classe che rappresenta un genere associato a un film nel database.
 * Utilizza una chiave primaria composta da due colonne: `id` e `genre`.
 */
@Entity
@Table(name = "genres", indexes = {
        @Index(name = "idx_genres_id_genre", columnList = "id,genre"),
        @Index(name = "idx_genres_genre", columnList = "genre")
})
@IdClass(GenreId.class)
public class Genre {

    /**
     * Identificativo univoco del genere.
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Nome del genere (ad esempio "Action", "Drama").
     */
    @Id
    @Column(name = "genre", columnDefinition = "text")
    private String genre;

    /**
     * Costruttore vuoto per la classe `Genre`.
     */
    public Genre() {}

    /**
     * Costruttore che inizializza un oggetto `Genre` con l'ID e il nome del genere.
     *
     * @param id L'ID del genere.
     * @param genre Il nome del genere.
     */
    public Genre(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    /**
     * Restituisce l'ID del genere.
     *
     * @return L'ID del genere.
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID del genere.
     *
     * @param id L'ID del genere.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del genere.
     *
     * @return Il nome del genere.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Imposta il nome del genere.
     *
     * @param genre Il nome del genere.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
}
