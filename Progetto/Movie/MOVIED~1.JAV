package main.postgresserver.springboot.Movie;

/**
 * Interfaccia di proiezione che definisce i metodi per ottenere i dettagli di un film.
 * Questa interfaccia viene utilizzata per proiettare un sottoinsieme delle colonne di un film,
 * incluse informazioni di base come titolo, descrizione e data.
 */
public interface MovieDetailProjection {

    /**
     * Ottiene l'ID del film.
     *
     * @return L'ID del film.
     */
    Long getId();

    /**
     * Ottiene il titolo del film.
     *
     * @return Il titolo del film.
     */
    String getTitolo();

    /**
     * Ottiene la descrizione del film.
     *
     * @return La descrizione del film.
     */
    String getDescrizione();

    /**
     * Ottiene la data di uscita del film.
     *
     * @return La data di uscita del film.
     */
    Integer getData();
}
