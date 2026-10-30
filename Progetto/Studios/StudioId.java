package main.postgresserver.springboot.Studios;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe che rappresenta una chiave primaria composta per l'entità {@link Studio}.
 * <p>
 * La classe {@link StudioId} è un oggetto di tipo {@link Serializable} che definisce la chiave primaria composta
 * per l'entità {@link Studio}, composta dal campo {@code id} e dal campo {@code studio}.
 * </p>
 */
@Embeddable
public class StudioId implements Serializable {

    private Long id;
    private String studio;

    /**
     * Costruttore vuoto della classe {@link StudioId}.
     * <p>
     * Questo costruttore è necessario per la gestione della chiave primaria composta.
     * </p>
     */
    public StudioId() {}

    /**
     * Costruttore per creare un'istanza di {@link StudioId} con i valori specificati.
     * <p>
     * Questo costruttore viene utilizzato per creare una chiave primaria composta specificando i valori per
     * {@code id} e {@code studio}.
     * </p>
     * @param id il valore del campo {@code id}
     * @param studio il valore del campo {@code studio}
     */
    public StudioId(Long id, String studio) {
        this.id = id;
        this.studio = studio;
    }

    /**
     * Restituisce l'id dello studio.
     *
     * @return il valore del campo {@code id}
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta il valore dell'id dello studio.
     *
     * @param id il valore da impostare per il campo {@code id}
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dello studio.
     *
     * @return il valore del campo {@code studio}
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Imposta il nome dello studio.
     *
     * @param studio il valore da impostare per il campo {@code studio}
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * Confronta questo oggetto {@link StudioId} con un altro per determinare se sono uguali.
     * <p>
     * Due oggetti {@link StudioId} sono considerati uguali se i loro campi {@code id} e {@code studio} sono uguali.
     * </p>
     * @param o l'oggetto da confrontare
     * @return {@code true} se gli oggetti sono uguali, altrimenti {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudioId studioId = (StudioId) o;
        return Objects.equals(id, studioId.id) &&
                Objects.equals(studio, studioId.studio);
    }

    /**
     * Restituisce il codice hash per l'oggetto {@link StudioId}.
     * <p>
     * Il codice hash è generato utilizzando i campi {@code id} e {@code studio}.
     * </p>
     * @return il codice hash per l'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, studio);
    }
}
