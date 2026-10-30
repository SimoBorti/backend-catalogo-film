package main.postgresserver.springboot.Releases;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Interfaccia per la gestione delle operazioni sul database per le entità {@link Release}.
 * <p>
 * La classe {@link ReleaseRepository} estende {@link JpaRepository} per fornire funzionalità di accesso al database
 * relative alle entità {@link Release}. Questa interfaccia definisce un metodo personalizzato per trovare tutte le release
 * con un determinato ID.
 * </p>
 */
public interface ReleaseRepository extends JpaRepository<Release, Long> {

    /**
     * Trova tutte le release con un determinato ID.
     * @param id l'ID della release
     * @return una lista di {@link Release} che corrispondono all'ID fornito
     */
    List<Release> findAllById(Long id);
}
