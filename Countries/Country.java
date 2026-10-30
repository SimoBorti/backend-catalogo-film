package main.postgresserver.springboot.Countries;

import jakarta.persistence.*;

/**
 * Entità che rappresenta un paese nel sistema.
 * La classe mappa la tabella {@code countries} nel database.
 * Ogni paese ha un ID univoco e un nome.
 *
 * @version 1.0
 */
@Entity
@Table(name = "countries", indexes = {
        @Index(name = "idx_countries_id_country", columnList = "id,country"),
        @Index(name = "idx_countries_country", columnList = "country")
})
@IdClass(CountryId.class)
public class Country {

    /**
     * L'ID univoco del paese. È utilizzato come chiave primaria nella tabella {@code countries}.
     */
    @Id
    @Column(name="id")
    private Long id;

    /**
     * Il nome del paese.
     */
    @Column(name="country", columnDefinition = "text")
    private String country;

    /**
     * Costruttore vuoto per la creazione di un'istanza della classe {@link Country}.
     */
    public Country() {}

    /**
     * Costruttore che inizializza un oggetto {@link Country} con l'ID e il nome del paese.
     *
     * @param id L'ID del paese.
     * @param country Il nome del paese.
     */
    public Country(Long id, String country) {
        this.id = id;
        this.country = country;
    }

    /**
     * Restituisce l'ID del paese.
     *
     * @return L'ID del paese.
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID del paese.
     *
     * @param id L'ID del paese.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del paese.
     *
     * @return Il nome del paese.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Imposta il nome del paese.
     *
     * @param country Il nome del paese.
     */
    public void setCountry(String country) {
        this.country = country;
    }
}