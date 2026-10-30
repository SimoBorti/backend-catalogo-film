package main.postgresserver.springboot.Actor;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * La classe {@code ActorId} rappresenta una chiave primaria composta per un attore.
 * Contiene un identificativo unico, il nome dell'attore e il ruolo che ricopre nel film.
 * Questa classe è annotata con {@code @Embeddable} per indicare che può essere utilizzata come
 * una chiave primaria composta in una entità JPA.
 *
 * @version 1.0
 */
@Embeddable
public class ActorId implements Serializable {

    /**
     * L'ID dell'attore.
     */
    private Long id;

    /**
     * Il nome dell'attore.
     */
    private String nome;

    /**
     * Il ruolo dell'attore nel film.
     */
    private String ruolo;

    /**
     * Costruttore senza parametri per {@code ActorId}.
     * Utilizzato per la creazione di istanze vuote o quando JPA crea l'istanza.
     */
    public ActorId() {}

    /**
     * Costruttore per inizializzare un'istanza di {@code ActorId} con i valori specificati.
     *
     * @param id   l'ID dell'attore
     * @param nome il nome dell'attore
     * @param ruolo il ruolo dell'attore
     */
    public ActorId(Long id, String nome, String ruolo) {
        this.id = id;
        this.nome = nome;
        this.ruolo = ruolo;
    }

    /**
     * Restituisce l'ID dell'attore.
     *
     * @return l'ID dell'attore
     */
    public Long getId() {
        return id;
    }

    /**
     * Imposta l'ID dell'attore.
     *
     * @param id l'ID dell'attore
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Restituisce il nome dell'attore.
     *
     * @return il nome dell'attore
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome dell'attore.
     *
     * @param nome il nome dell'attore
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il ruolo dell'attore.
     *
     * @return il ruolo dell'attore
     */
    public String getRuolo() {
        return ruolo;
    }

    /**
     * Imposta il ruolo dell'attore.
     *
     * @param ruolo il ruolo dell'attore
     */
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    /**
     * Confronta questa istanza di {@code ActorId} con un altro oggetto.
     * Ritorna {@code true} se gli oggetti sono uguali, altrimenti {@code false}.
     *
     * @param o l'oggetto con cui confrontare
     * @return {@code true} se gli oggetti sono uguali, {@code false} altrimenti
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorId actorId = (ActorId) o;
        return Objects.equals(id, actorId.id) &&
                Objects.equals(nome, actorId.nome) &&
                Objects.equals(ruolo, actorId.ruolo);
    }

    /**
     * Calcola l'hash code per questa istanza di {@code ActorId}.
     * Utilizza i valori dell'ID, nome e ruolo per determinare l'hash.
     *
     * @return l'hash code di questa istanza
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nome, ruolo);
    }
}
