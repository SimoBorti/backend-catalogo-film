package main.postgresserver.springboot.Countries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaccia di repository per la gestione delle operazioni di persistenza
 * sull'entità {@link Country}. Estende {@link JpaRepository} per l'accesso ai dati.
 *
 * @version 1.0
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    /**
     * Trova tutte le voci di paese con un determinato ID.
     *
     * @param id L'ID del paese da cercare.
     * @return Una lista di paesi che corrispondono all'ID specificato.
     */
    List<Country> findAllById(Long id);

}
