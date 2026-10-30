package main.postgresserver.springboot.Genres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository per l'entità Genre, che estende JpaRepository.
 * Fornisce metodi per operazioni CRUD e altre query personalizzate per l'entità Genre.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, GenreId> {

    /**
     * Trova un elenco di generi associati a un determinato id.
     *
     * @param id L'id del genere.
     * @return Una lista di generi associati all'id specificato.
     */
    List<Genre> findById(Long id);
}
