package main.postgresserver.springboot.Countries;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe che rappresenta una chiave primaria composta per l'entità {@link Country}.
 * Utilizzata per identificare un paese in modo univoco tramite un ID e un nome.
 *
 * @version 1.0
 */
@Embeddable
public class CountryId implements Serializable {

    /**
     * L'ID univoco del paese.
     */
    private Long id;

    /**
     * Il nome del paese.
     */
    private String country;

    /**
     * Costruttore vuoto per la creazione di un'istanza di {@link CountryId}.
     */
    public CountryId() {}

    /**
     * Costruttore che inizializza un oggetto {@link CountryId} con l'ID e il nome del paese.
     *
     * @param id L'ID del paese.
     * @param country Il nome del paese.
     */
    public CountryId(Long id, String country) {
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

    /**
     * Confronta due oggetti {@link CountryId} per verificarne l'uguaglianza.
     * Due {@link CountryId} sono considerati uguali se hanno lo stesso ID e lo stesso nome.
     *
     * @param o L'oggetto da confrontare.
     * @return {@code true} se gli oggetti sono uguali, {@code false} altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryId countryId = (CountryId) o;
        return Objects.equals(id, countryId.id) &&
                Objects.equals(country, countryId.country);
    }

    /**
     * Calcola il valore hash per un oggetto {@link CountryId}.
     * Il valore hash è basato sull'ID e sul nome del paese.
     *
     * @return Il valore hash dell'oggetto {@link CountryId}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, country);
    }
}
