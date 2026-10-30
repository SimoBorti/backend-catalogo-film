package main.postgresserver.springboot.Theme;

import jakarta.persistence.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaccia di repository per l'entità {@link Theme}.
 * <p>
 * Questa interfaccia estende {@link JpaRepository} e fornisce metodi predefiniti per le operazioni CRUD
 * sull'entità {@link Theme}, come il salvataggio, la ricerca, l'aggiornamento e la cancellazione di
 * istanze {@link Theme}. Non è necessario implementare manualmente i metodi, poiché Spring Data JPA
 * li fornirà automaticamente.
 * </p>
 */
@Repository
public interface ThemeRepository extends JpaRepository<Theme, ThemeId> {


    List<Theme> findById(Long id);

}
