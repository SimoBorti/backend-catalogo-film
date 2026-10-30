package main.postgresserver.springboot.Actor;

import main.postgresserver.springboot.Movie.Movie;
import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

/**
 * Interfaccia repository per l'entità {@link Actor}.
 * Estende {@link JpaRepository} per fornire metodi di accesso ai dati relativi agli attori nel database.
 * Include metodi personalizzati per la ricerca degli attori in base al nome e all'ID.
 *
 * @version 1.0
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor, String> {

    /**
     * Trova i nomi distinti degli attori che corrispondono a una chiave di ricerca,
     * con la ricerca che non tiene conto delle maiuscole/minuscole.
     * I risultati sono restituiti in pagine per gestire grandi volumi di dati.
     *
     * @param chiave La chiave di ricerca per il nome dell'attore.
     * @param pageable Oggetto contenente le informazioni di paginazione.
     * @return Una pagina di nomi distinti degli attori che corrispondono alla chiave di ricerca.
     */
    @Query("SELECT a.nome FROM Actor a WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :chiave, '%')) GROUP BY a.nome")
    Page<String> findDistinctNames(@Param("chiave") String chiave, Pageable pageable);

    /**
     * Trova una lista di attori basata sul loro ID.
     *
     * @param movieId L'ID dell'attore da cercare.
     * @return Una lista di attori che corrispondono all'ID specificato.
     */
    List<Actor> findByMovie_Id(Long movieId);

    /**
     * Trova una lista di film con poster associati a un attore specifico.
     *
     * @param actorName Il nome dell'attore da cercare.
     * @return Una lista di film con poster associati all'attore specificato.
     */
    @Query("SELECT new main.postgresserver.springboot.DTO.MovieWithPosterDTO(" +
            "m.id, m.titolo, m.data, m.rating, p.link) " +
            "FROM Movie m " +
            "JOIN Actor a ON a.id = m.id " +
            "LEFT JOIN Poster p ON p.id = m.id " +
            "WHERE LOWER(a.nome) LIKE LOWER(CONCAT('%', :actorName, '%'))")
    List<MovieWithPosterDTO> findMoviesWithPostersByActorName(@Param("actorName") String actorName);
}