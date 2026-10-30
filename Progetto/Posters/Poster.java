package main.postgresserver.springboot.Posters;

import jakarta.persistence.*;

/**
 * Rappresenta un poster associato a un film.
 * <p>
 * Questa classe mappa la tabella "posters" nel database e contiene le informazioni relative a un poster,
 * come l'ID univoco e il link all'immagine del poster.
 * </p>
 */
@Entity
@Table(name="posters")
public class Poster {
    /**
     * ID univoco per l'entità.
     * Rappresenta l'identificativo del record nel database.
     */
    @Id
    @Column(name = "id")
    private long id;

    /**
     * Link associato all'entità.
     * La lunghezza massima del campo è di 400 caratteri.
     * Rappresenta un collegamento URL utilizzato per accedere a una risorsa esterna.
     */
    @Column(name = "link", length = 400)
    private String link;

    /**
     * Costruttore senza argomenti necessario per la persistenza dell'entità.
     */
    public Poster() {
    }

    /**
     * Costruttore che inizializza un poster con un ID e un link.
     * @param id l'ID univoco del poster
     * @param link il link dell'immagine del poster
     */
    public Poster(long id, String link) {
        this.id = id;
        this.link = link;
    }

    /**
     * Restituisce l'ID del poster.
     * @return l'ID del poster
     */
    public long getId() {
        return id;
    }

    /**
     * Imposta l'ID del poster.
     * @param id l'ID da impostare per il poster
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Restituisce il link del poster.
     * @return il link dell'immagine del poster
     */
    public String getLink() {
        return link;
    }

    /**
     * Imposta il link del poster.
     * @param link il link da impostare per il poster
     */
    public void setLink(String link) {
        this.link = link;
    }
}
//TODO : sistemare il sistema del poster da questo https://claude.ai/chat/c4ad6e59-1079-4d46-b01f-2a849ed3bc62