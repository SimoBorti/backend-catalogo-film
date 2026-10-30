package main.postgresserver.springboot.DTO;

/**
 * DTO (Data Transfer Object) per rappresentare le informazioni di un film con il relativo poster.
 */
public class MovieWithPosterDTO {
    private long id;
    private String titolo;
    private Integer data;
    private Double rating;
    private String posterLink;

    /**
     * Costruttore per inizializzare un oggetto MovieWithPosterDTO.
     *
     * @param id l'ID del film
     * @param titolo il titolo del film
     * @param data l'anno di uscita del film
     * @param rating il punteggio del film
     * @param posterLink il link al poster del film
     */
    public MovieWithPosterDTO(long id, String titolo, Integer data,
                               Double rating, String posterLink) {
        this.id = id;
        this.titolo = titolo;
        this.data = data;
        this.rating = rating;
        this.posterLink = posterLink;
    }

    /**
     * Restituisce l'ID del film.
     *
     * @return l'ID del film
     */
    public long getId() {
        return id;
    }

    /**
     * Imposta l'ID del film.
     *
     * @param id l'ID del film
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Restituisce il titolo del film.
     *
     * @return il titolo del film
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
     * Restituisce l'anno di uscita del film.
     *
     * @return l'anno di uscita del film
     */
    public Integer getData() {
        return data;
    }

    /**
     * Imposta l'anno di uscita del film.
     *
     * @param data l'anno di uscita del film
     */
    public void setData(Integer data) {
        this.data = data;
    }



    /**
     * Restituisce il punteggio del film.
     *
     * @return il punteggio del film
     */
    public Double getRating() {
        return rating;
    }

    /**
     * Imposta il punteggio del film.
     *
     * @param rating il punteggio del film
     */
    public void setRating(Double rating) {
        this.rating = rating;
    }


    /**
     * Restituisce il link al poster del film.
     *
     * @return il link al poster del film
     */
    public String getPosterLink() {
        return posterLink;
    }

    /**
     * Imposta il link al poster del film.
     *
     * @param posterLink il link al poster del film
     */
    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }
}
