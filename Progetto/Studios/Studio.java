package main.postgresserver.springboot.Studios;

import jakarta.persistence.*;

/**
 * Classe che rappresenta uno studio cinematografico.
 * <p>
 * La classe {@link Studio} è un'entità JPA mappata alla tabella "studios" nel database. Essa rappresenta
 * un record di uno studio cinematografico, che è identificato dalla combinazione di un {@link Long id}
 * e un {@link String studio}.
 * </p>
 */
@Entity
@Table(name = "studios", indexes = {
        @Index(name = "idx_studios_id_studio", columnList = "id,studio"),
        @Index(name = "idx_studios_studio", columnList = "studio")
})
@IdClass(StudioId.class)
public class Studio {

    /**
     * ID univoco per identificare l'entità.
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Studio associato all'entità, rappresentato come una stringa.
     * La colonna è definita come tipo "text" nel database.
     */
    @Id
    @Column(name = "studio", columnDefinition = "text")
    private String studio;


    /**
     * Costruttore di default per la classe {@link Studio}.
     * Questo costruttore è richiesto per il funzionamento di JPA.
     */
    public Studio() {}

    /**
     * Costruttore della classe {@link Studio} che inizializza l'id e il nome dello studio.
     * @param id l'ID dello studio
     * @param studio il nome dello studio cinematografico
     */
    public Studio(Long id, String studio) {
        this.id = id;
        this.studio = studio;
    }

    /**
     * Restituisce l'ID dello studio.
     * @return l'ID dello studio
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID dello studio.
     * @param id l'ID dello studio da impostare
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dello studio.
     * @return il nome dello studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Imposta il nome dello studio.
     * @param studio il nome dello studio da impostare
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }
}
