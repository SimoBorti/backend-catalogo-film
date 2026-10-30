package main.postgresserver.springboot.DTO;

import main.postgresserver.springboot.Movie.MovieBasicProjection;

/**
 * DTO (Data Transfer Object) per rappresentare informazioni basilari di un film.
 * Implementa l'interfaccia {@link MovieBasicProjection} per garantire compatibilità con le proiezioni di dati.
 */
public class MovieBasicDTO implements MovieBasicProjection {
    final private Long id;
    private final String titolo;
    private final String descrizione;
    private final Integer data;
    private final Integer minute;
    private final Double rating;
    private String posterLink;

    /**
     * Costruttore per inizializzare un oggetto MovieBasicDTO.
     *
     * @param id l'ID del film
     * @param titolo il titolo del film
     * @param descrizione la descrizione del film
     * @param data l'anno di uscita del film
     * @param minute la durata del film in minuti
     * @param rating il punteggio del film
     */
    public MovieBasicDTO(Long id, String titolo, String descrizione, Integer data, Integer minute, Double rating) {
        this.id = id;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.data = data;
        this.minute = minute;
        this.rating = rating;
    }

    /**
     * Restituisce l'ID del film.
     *
     * @return l'ID del film
     */
    @Override
    public Long getId() { return id; }

    /**
     * Restituisce il titolo del film.
     *
     * @return il titolo del film
     */
    @Override
    public String getTitolo() { return titolo; }

    /**
     * Restituisce la descrizione del film.
     *
     * @return la descrizione del film
     */
    @Override
    public String getDescrizione() { return descrizione; }

    /**
     * Restituisce il link al poster del film.
     *
     * @return il link al poster del film
     */
    @Override
    public String getPosterLink() { return posterLink; }

    /**
     * Imposta il link al poster del film.
     *
     * @param posterLink il link al poster del film
     */
    @Override
    public void setPosterLink(String posterLink) { this.posterLink = posterLink; }

    /**
     * Restituisce l'anno di uscita del film.
     *
     * @return l'anno di uscita del film
     */
    @Override
    public Integer getData() { return data; }

    /**
     * Restituisce la durata del film in minuti.
     *
     * @return la durata del film in minuti
     */
    @Override
    public Integer getMinute() { return minute; }

    /**
     * Restituisce il punteggio del film.
     *
     * @return il punteggio del film
     */
    @Override
    public Double getRating() { return rating; }
}
