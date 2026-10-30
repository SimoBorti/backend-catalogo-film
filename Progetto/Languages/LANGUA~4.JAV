package main.postgresserver.springboot.Languages;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interfaccia per la gestione delle operazioni di accesso ai dati relativi alle lingue nel database.
 * Estende `JpaRepository` per fornire metodi di persistenza generici.
 */
public interface LanguageRepository extends JpaRepository<Language, Long> {

    /**
     * Restituisce una lista di lingue associate a un determinato ID.
     *
     * @param id L'ID per il quale trovare le lingue.
     * @return Una lista di oggetti `Language` corrispondenti all'ID fornito.
     */
    List<Language> findAllById(Long id);
}
