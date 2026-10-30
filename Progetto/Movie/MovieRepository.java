package main.postgresserver.springboot.Movie;

import main.postgresserver.springboot.DTO.MovieBasicDTO;
import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jndi.support.SimpleJndiBeanFactory;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;


/**
 * Interfaccia del repository per l'entità {@link Movie}.
 * Estende {@link JpaRepository} per fornire le operazioni CRUD di base per l'entità {@link Movie}.
 * Contiene metodi per la ricerca di film basata su vari criteri e per la proiezione di dati.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /**
     * Trova i film che contengono il titolo dato, ignorando maiuscole e minuscole, 
     * e restituisce i risultati in una pagina.
     *
     * @param title Il titolo del film da cercare.
     * @param pageable Il parametro per la paginazione dei risultati.
     * @return Una pagina di film che corrispondono alla ricerca.
     */
    Page<Movie> findByTitoloContainingIgnoreCase(String title, Pageable pageable);

    /**
     * Trova i film che contengono il titolo dato, ignorando maiuscole e minuscole, 
     * restituendo una proiezione di tipo {@link MovieBasicDTO}.
     *
     * @param title Il titolo del film da cercare.
     * @param pageable Il parametro per la paginazione dei risultati.
     * @return Una pagina di proiezioni {@link MovieBasicDTO} che corrispondono alla ricerca.
     */
    Page<MovieBasicDTO> findSearchProjectionByTitoloContainingIgnoreCase(String title, Pageable pageable);

    /**
     * Trova un film con una proiezione di tipo {@link MovieBasicPojectionNoPoster} basata sull'ID.
     *
     * @param id L'ID del film.
     * @return La proiezione del film.
     */
    MovieBasicPojectionNoPoster findProjectedById(Long id);

    /**
     * Trova i dettagli di un film con una proiezione di tipo {@link MovieDetailProjection} basata sull'ID.
     *
     * @param id L'ID del film.
     * @return La proiezione del dettaglio del film.
     */
    MovieDetailProjection findDetailProjectionById(Long id);

    /**
     * Esegue una ricerca avanzata dei film in base ai vari parametri di filtro e restituisce una pagina di risultati.
     * La ricerca considera parametri come titolo, data di uscita, rating, durata, paese, studio, cast, e altri criteri.
     *
     * @param title Il titolo del film.
     * @param startDate La data di inizio per il filtro delle date di uscita.
     * @param endDate La data di fine per il filtro delle date di uscita.
     * @param startRating Il rating minimo per il filtro.
     * @param endRating Il rating massimo per il filtro.
     * @param startDuration La durata minima per il filtro.
     * @param endDuration La durata massima per il filtro.
     * @param country Il paese del film.
     * @param studio Lo studio che ha prodotto il film.
     * @param cast Il nome del cast (attore).
     * @param character Il nome del personaggio interpretato dall'attore.
     * @param oscar Il tipo di premi Oscar (candidati o vincitori).
     * @param languages La lingua del film.
     * @param myList Una lista di generi del film.
     * @param pageable Il parametro per la paginazione dei risultati.
     * @return Una pagina di risultati della ricerca avanzata.
     */
    @Query("""
   SELECT DISTINCT new main.postgresserver.springboot.DTO.MovieBasicDTO(
        m.id,
        m.titolo,
        m.descrizione,
        m.data,
        m.minute,
        m.rating
    ) FROM Movie m
    LEFT JOIN m.genres g
    LEFT JOIN m.countries c
    LEFT JOIN m.studios s
    WHERE
        (:title IS NULL OR CAST(m.titolo AS string) ILIKE CONCAT('%', CAST(:title AS string), '%'))
        AND (:startDate IS NULL OR m.data >= :startDate)
        AND (:endDate IS NULL OR m.data <= :endDate)
        AND (:startRating IS NULL OR m.rating >= :startRating)
        AND (:endRating IS NULL OR m.rating <= :endRating)
        AND (:startDuration IS NULL OR m.minute >= :startDuration)
        AND (:endDuration IS NULL OR m.minute <= :endDuration)
        AND (:country IS NULL OR CAST(c.country AS string) ILIKE CONCAT('%', CAST(:country AS string), '%'))
        AND (:studio IS NULL OR CAST(s.studio AS string) ILIKE (CONCAT('%', CAST(:studio AS string), '%')))
        AND (
                    'DUMMY' IN :myList OR
                    EXISTS (
                        SELECT 1
                        FROM m.genres g2
                        WHERE g2.genre IN :myList
                        GROUP BY m.id
                        HAVING COUNT(DISTINCT g2.genre) = :myListSize
                    )
                )
        AND ( 'DUMMYUFT' IN :character  OR EXISTS (
                    SELECT 1 FROM Actor a
                    WHERE a.id = m.id
                    AND LOWER(CAST(a.ruolo AS string)) LIKE LOWER(CONCAT('%', :character, '%'))
                    ))
        AND ( 'DUMMYUFT' IN :cast  OR EXISTS (
                    SELECT 1 FROM Actor a
                    WHERE a.id = m.id
                    AND LOWER(CAST(a.nome AS string)) LIKE LOWER(CONCAT('%', :cast, '%'))
                    ))
        AND (
                    'DUMMYUFT' IN :oscar OR
                    (
                        :oscar = 'candidates' AND
                        EXISTS (
                            SELECT 1 FROM OscarAward o
                            WHERE o.film = m.titolo
                            AND (m.data IS NULL OR o.yearFilm Between m.data-1 AND m.data+1)
                        )
                    ) OR (
                        :oscar = 'winners' AND
                        EXISTS (
                            SELECT 1 FROM OscarAward o
                            WHERE o.film = m.titolo
                            AND (m.data IS NULL OR o.yearFilm Between m.data-1 AND m.data+1)
                            AND o.winner = True
                        )
                    )
                )
        AND ( 'DUMMYUFT' IN :languages  OR EXISTS (
                    SELECT 1 FROM Language l
                    WHERE l.id = m.id
                    AND LOWER(CAST(l.language AS string)) LIKE LOWER(CONCAT('%', :languages, '%'))
                    ))
        AND (
            'DUMMYUFT' IN :themeList OR
            (
                SELECT COUNT(DISTINCT t2.theme)
                FROM Theme t2
                WHERE t2.id = m.id AND t2.theme IN :themeList
            ) = :themeListSize
        )
    GROUP BY m.id, m.titolo, m.descrizione, m.data, m.minute, m.rating
    order by m.data desc nulls last
   """)
    Page<MovieBasicDTO> advancedSearchBasic(
            @Param("title")
            String title,
            @Param("startDate")
            Integer startDate,
            @Param("endDate")
            Integer endDate,
            @Param("startRating")
            Double startRating,
            @Param("endRating")
            Integer endRating,
            @Param("startDuration")
            Integer startDuration,
            @Param("endDuration")
            Integer endDuration,
            @Param("country")
            String country,
            @Param("studio")
            String studio,
            @Param("cast") String cast,
            @Param("character") String character,
            @Param("oscar") String oscar,
            @Param("languages") String languages,
            @Param("myList") List<String> myList,
            @Param("myListSize") int myListSize,
            @Param("themeList") List<String> themeList,
            @Param("themeListSize") int themeListSize,
            Pageable pageable
    );




        @Query("SELECT m FROM Movie m " +
                "JOIN Poster p ON p.id = m.id " +
                "WHERE m.data >= :cutoffDate " +
                "ORDER BY m.rating DESC")
        List<MovieWithPosterDTO> findTopRatedRecent(@Param("cutoffDate") LocalDate cutoffDate, Pageable pageable);










}
