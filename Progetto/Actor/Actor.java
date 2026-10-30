package main.postgresserver.springboot.Actor;

import jakarta.persistence.*;
import main.postgresserver.springboot.Movie.Movie;


/**
 * Rappresenta un attore nel database. Questa classe è mappata sulla tabella "actors"
 * e include l'ID dell'attore, il nome, il ruolo e una lista di film associati.
 *
 * @version 1.0
 */
@Entity
@Table(name = "actors", indexes = {
        @Index(name = "idx_actors_id_name", columnList = "id,name"),
        @Index(name = "idx_actors_name", columnList = "name"),
        @Index(name = "idx_actors_role", columnList = "role")
})
@IdClass(ActorId.class)
public class Actor {

    /**
     * L'identificatore unico dell'attore.
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Il nome dell'attore.
     */
    @Id
    @Column(name = "name", columnDefinition = "text")
    private String nome;

    /**
     * Il ruolo dell'attore in un film.
     */
    @Id
    @Column(name = "role", columnDefinition = "text")
    private String ruolo;

    @ManyToOne
    @JoinColumn(name = "id")  // nome della colonna nella tabella degli attori
    private Movie movie;

    /**
     * Costruttore vuoto per l'attore.
     */
    public Actor() {}

    /**
     * Costruttore per l'attore con ID, nome e ruolo.
     *
     * @param id   l'ID dell'attore
     * @param nome il nome dell'attore
     * @param ruolo il ruolo dell'attore
     */
    public Actor(Long id, String nome, String ruolo) {
        this.id = id;
        this.nome = nome;
        this.ruolo = ruolo;
    }

    /**
     * Restituisce l'ID dell'attore.
     *
     * @return l'ID dell'attore
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID dell'attore.
     *
     * @param id l'ID dell'attore
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dell'attore.
     *
     * @return il nome dell'attore
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome dell'attore.
     *
     * @param nome il nome dell'attore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il ruolo dell'attore.
     *
     * @return il ruolo dell'attore
     */
    public String getRuolo() {
        return ruolo;
    }

    /**
     * Imposta il ruolo dell'attore.
     *
     * @param ruolo il ruolo dell'attore
     */
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
