package main.postgresserver.springboot.Movie;

/**
 * Interfaccia di proiezione che definisce i metodi per ottenere le informazioni di base su un film.
 * Questa interfaccia viene utilizzata per proiettare un sottoinsieme delle colonne del film,
 * inclusi i dettagli fondamentali come il titolo, la descrizione e il link al poster.
 */
public interface MovieBasicProjection {

    /**
     * Ottiene l'ID del film.
     * Questo campo rappresenta l'identificatore univoco del film.
     *
     * @return L'ID del film.
     */
    Long getId();

    /**
     * Ottiene il titolo del film.
     * Questo campo rappresenta il nome del film.
     *
     * @return Il titolo del film.
     */
    String getTitolo();

    /**
     * Ottiene la descrizione del film.
     * Questo campo fornisce una breve descrizione del film.
     *
     * @return La descrizione del film.
     */
    String getDescrizione();

    /**
     * Ottiene il link del poster del film.
     * Questo campo rappresenta l'URL dell'immagine del poster del film.
     *
     * @return Il link del poster del film.
     */
    String getPosterLink();

    /**
     * Ottiene l'anno di uscita del film.
     * Questo campo rappresenta l'anno in cui il film è stato distribuito.
     *
     * @return L'anno di uscita del film.
     */
    Integer getData();

    /**
     * Ottiene la durata del film in minuti.
     * Questo campo indica la durata complessiva del film, espressa in minuti.
     *
     * @return La durata del film in minuti.
     */
    Integer getMinute();

    /**
     * Ottiene il rating del film.
     * Questo campo rappresenta il punteggio medio del film, solitamente espresso come valore decimale.
     *
     * @return Il rating del film.
     */
    Double getRating();

    /**
     * Imposta il link del poster del film.
     * Questo metodo consente di impostare un nuovo URL per il poster del film.
     *
     * @param posterLink Il link del nuovo poster del film.
     */
    void setPosterLink(String posterLink);
}
