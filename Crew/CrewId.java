package main.postgresserver.springboot.Crew;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe che rappresenta la chiave primaria composta per l'entità {@link Crew}.
 * Utilizzata per identificare un membro del team di produzione in modo univoco.
 */
@Embeddable
public class CrewId implements Serializable {
    /**
     * ID univoco del membro del team.
     */
    private Long id;

    /**
     * Nome del membro del team.
     */
    private String name;

    /**
     * Ruolo del membro del team.
     */
    private String role;

    /**
     * Costruttore vuoto per la creazione di un'istanza di {@link CrewId}.
     */
    public CrewId() {}

    /**
     * Costruttore che inizializza l'ID, il nome e il ruolo.
     *
     * @param id    L'ID univoco del membro del team.
     * @param name  Il nome del membro del team.
     * @param role  Il ruolo del membro del team.
     */
    public CrewId(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    /**
     * Restituisce l'ID del membro del team.
     *
     * @return L'ID del membro del team.
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID del membro del team.
     *
     * @param id L'ID del membro del team.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del membro del team.
     *
     * @return Il nome del membro del team.
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il nome del membro del team.
     *
     * @param name Il nome del membro del team.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restituisce il ruolo del membro del team.
     *
     * @return Il ruolo del membro del team.
     */
    public String getRole() {
        return role;
    }

    /**
     * Imposta il ruolo del membro del team.
     *
     * @param role Il ruolo del membro del team.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Confronta due oggetti {@link CrewId} per verificare se sono uguali.
     * Due {@link CrewId} sono considerati uguali se hanno lo stesso ID, nome e ruolo.
     *
     * @param o L'oggetto con cui confrontare.
     * @return true se i due oggetti sono uguali, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewId crewId = (CrewId) o;
        return Objects.equals(id, crewId.id) &&
                Objects.equals(name, crewId.name) &&
                Objects.equals(role, crewId.role);
    }

    /**
     * Restituisce un codice hash per l'oggetto {@link CrewId}.
     * Il codice hash è basato su ID, nome e ruolo.
     *
     * @return Il codice hash per l'oggetto {@link CrewId}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }
}