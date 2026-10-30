package main.postgresserver.springboot.Movie;

/**
 * Interfaccia di proiezione per rappresentare una vista semplificata dei dati del film,
 * escludendo il campo relativo al poster.
 * Questa interfaccia viene utilizzata per ottenere un insieme di informazioni base su un film
 * senza includere i dettagli del poster.
 */
public interface MovieBasicPojectionNoPoster {

    /**
     * Restituisce l'ID del film.
     * Questo è l'identificatore univoco del film.
     *
     * @return L'ID del film.
     */
    Long getId();

    /**
     * Restituisce il titolo del film.
     * Questo campo rappresenta il nome del film.
     *
     * @return Il titolo del film.
     */
    String getTitolo();

    /**
     * Restituisce la descrizione del film.
     * Questo campo fornisce una breve descrizione del film.
     *
     * @return La descrizione del film.
     */
    String getDescrizione();

    /**
     * Restituisce l'anno di uscita del film.
     * Questo campo rappresenta l'anno in cui il film è stato distribuito.
     *
     * @return L'anno di uscita del film.
     */
    Integer getData();

    /**
     * Restituisce la durata del film in minuti.
     * Questo campo indica il numero di minuti della durata totale del film.
     *
     * @return La durata del film in minuti.
     */
    Integer getMinute();

    /**
     * Restituisce il rating del film.
     * Questo campo rappresenta il punteggio medio del film, in genere espresso come valore decimale.
     *
     * @return Il rating del film.
     */
    Double getRating();

    /**
     * Restituisce il tagline del film.
     * Questo campo contiene una breve frase promozionale che descrive il film, solitamente usata nelle campagne pubblicitarie.
     *
     * @return Il tagline del film.
     */
    String getTagline();
}
