package main.postgresserver.springboot.Crew;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * Entità che rappresenta un membro del team di produzione di un film.
 * La classe usa una chiave primaria composta tramite l'annotazione {@link IdClass}
 * e mappa la tabella "crew" del database.
 */
@Entity
@Table(name = "crew", indexes = {
        @Index(name = "idx_crew_id_role", columnList = "id,role"),
        @Index(name = "idx_crew_name", columnList = "name"),
        @Index(name = "idx_crew_role", columnList = "role")
})
@IdClass(CrewId.class)
public class Crew {

    /**
     * L'ID del membro del team di produzione.
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * Il nome del membro del team di produzione.
     */
    @Id
    @Column(name = "name")
    private String name;

    /**
     * Il ruolo del membro del team di produzione.
     */
    @Id
    @Column(name = "role")
    private String role;

    /**
     * Costruttore di default.
     */
    public Crew() {}

    /**
     * Costruttore per inizializzare un membro del team con ID, nome e ruolo.
     *
     * @param id L'ID del membro del team.
     * @param name Il nome del membro del team.
     * @param role Il ruolo del membro del team.
     */
    public Crew(Long id, String name, String role) {
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
     * Verifica se due oggetti Crew sono uguali.
     * Due oggetti sono considerati uguali se hanno lo stesso ID, nome e ruolo.
     *
     * @param o L'oggetto da confrontare.
     * @return true se gli oggetti sono uguali, false altrimenti.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crew crew = (Crew) o;
        return Objects.equals(id, crew.id) &&
                Objects.equals(name, crew.name) &&
                Objects.equals(role, crew.role);
    }

    /**
     * Restituisce il codice hash dell'oggetto Crew.
     *
     * @return Il codice hash dell'oggetto Crew.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }

    /**
     * Restituisce una rappresentazione stringa dell'oggetto Crew.
     *
     * @return Una stringa che rappresenta il membro del team.
     */
    @Override
    public String toString() {
        return "Crew{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}