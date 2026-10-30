package main.postgresserver.springboot.Crew;

import jakarta.persistence.Tuple;
import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interfaccia per la gestione delle operazioni sul database relative agli oggetti {@link Crew}.
 * Estende {@link JpaRepository} per sfruttare le operazioni CRUD standard e aggiunge query personalizzate.
 */
public interface CrewRepository extends JpaRepository<Crew, CrewId> {

    /**
     * Restituisce una lista di membri del team per un dato ID e ruolo, ordinata per nome.
     *
     * @param id   L'ID del film.
     * @param role Il ruolo del membro del team.
     * @return Una lista di membri del team che corrispondono all'ID e al ruolo specificati.
     */
    @Query("SELECT c FROM Crew c WHERE c.id = :id AND c.role = :role ORDER BY c.name")
    List<Crew> findAllByIdAndRole(@Param("id") Long id, @Param("role") String role);

    /**
     * Restituisce una lista di ruoli per una persona specificata da ID e nome.
     *
     * @param id   L'ID del film.
     * @param name Il nome del membro del team.
     * @return Una lista di ruoli che il membro del team ha ricoperto per il film specificato.
     */
    @Query("SELECT c FROM Crew c WHERE c.id = :id AND c.name = :name")
    List<Crew> findAllRolesForPerson(@Param("id") Long id, @Param("name") String name);

    /**
     * Trova tutte le istanze di {@link Crew} associate a un determinato film.
     * <p>
     * I risultati sono ordinati per ruolo del membro del team di produzione e successivamente per nome.
     *
     * @param id l'ID del film
     * @return una lista di istanze {@link Crew}
     */
    @Query("SELECT c FROM Crew c WHERE c.id = :id ORDER BY c.role, c.name")
    List<Crew> findAllByMovieId(@Param("id") Long id);

    /**
     * Trova tutti i nomi distinti dei membri del team di produzione ({@link Crew}) che corrispondono alla chiave di ricerca fornita.
     * <p>
     * La ricerca non fa distinzione tra maiuscole e minuscole e la chiave viene trattata come un pattern SQL LIKE.
     * <p>
     * Il risultato è ordinato in base all'ordine naturale dei nomi e viene restituito in modalità paginata.
     *
     * @param chiave la chiave di ricerca
     * @param pageable l'oggetto per la paginazione dei risultati
     * @return una pagina contenente i nomi distinti dei membri del team di produzione
     */
    @Query("SELECT c.name FROM Crew c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :chiave, '%')) GROUP BY c.name")
    Page<String> findDistinctNames(@Param("chiave") String chiave, Pageable pageable);



    /**
     * Trova i film con poster associati a un membro del team di produzione specificato da nome.
     * <p>
     * La ricerca non fa distinzione tra maiuscole e minuscole e la chiave viene trattata come un pattern SQL LIKE.
     * <p>
     * I risultati sono restituiti come lista di oggetti {@link MovieWithPosterDTO}.
     *
     * @param crewName il nome del membro del team di produzione
     * @return una lista di oggetti {@link MovieWithPosterDTO} contenenti i film con poster associati al membro del team di produzione
     */
    @Query("SELECT DISTINCT new main.postgresserver.springboot.DTO.MovieWithPosterDTO(" +
            "m.id, m.titolo, m.data, m.rating, p.link) " +
            "FROM Movie m " +
            "JOIN Crew c ON c.id = m.id " +
            "LEFT JOIN Poster p ON p.id = m.id " +
            "WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :crewName, '%'))")
    List<MovieWithPosterDTO> findMoviesWithPostersByCrewName(@Param("crewName") String crewName);


}