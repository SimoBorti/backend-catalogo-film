package main.postgresserver.springboot.Studios;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Interfaccia per il repository della classe {@link Studio}.
 * <p>
 * Il repository estende {@link JpaRepository}, fornendo metodi per le operazioni CRUD
 * sulla tabella {@code studios} del database, utilizzando la chiave primaria composta {@link StudioId}.
 * </p>
 */
public interface StudioRepository extends JpaRepository<Studio, StudioId> {

    /**
     * Restituisce una lista di {@link Studio} filtrati per {@code id}.
     *
     * @param id il valore dell'id da cercare
     * @return una lista di studi che corrispondono all'id specificato
     */
    List<Studio> findAllById(Long id);

    /**
     * Restituisce una lista di {@link Studio} che corrispondono al nome {@code studio} specificato.
     *
     * @param studio il nome dello studio da cercare
     * @return una lista di studi che corrispondono al nome specificato
     */
    List<Studio> findAllByStudio(String studio);

    /**
     * Restituisce un elenco di {@link Studio} associati a un determinato {@code id}.
     *
     * @param id l'id dello studio da cercare
     * @return una lista di studi associati all'id specificato
     */
    List<Studio> findStudioById(Long id);
}