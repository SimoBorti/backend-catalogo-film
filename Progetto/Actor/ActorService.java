package main.postgresserver.springboot.Actor;

import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import main.postgresserver.springboot.Movie.Movie;
import main.postgresserver.springboot.Movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Servizio per la gestione degli attori.
 * Fornisce metodi per la ricerca degli attori in base al nome e all'ID,
 * nonché per la gestione delle informazioni relative ai film associati agli attori.
 *
 * @version 1.0
 */
@Service
public class ActorService {

    /**
     * Il repository per l'entità {@link Actor}.
     */
    private final ActorRepository actorRepository;

    /**
     * Costruttore per l'ActorService con il repository per l'entità {@link Actor}.
     *
     * @param actorRepository il repository per l'entità {@link Actor}
     */
    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    /**
     * Trova i nomi distinti degli attori che corrispondono a una chiave di ricerca,
     * restituendo i risultati in base alla paginazione.
     *
     * @param chiave La chiave di ricerca per il nome dell'attore.
     * @param pag Il numero di pagina per la paginazione.
     * @return Una lista di nomi distinti degli attori che corrispondono alla chiave di ricerca.
     */
    public List<String> findByName(String chiave, int pag) {
        Pageable pageable = PageRequest.of(pag, 10, Sort.by("nome").ascending());
        Page<String> page = actorRepository.findDistinctNames(chiave, pageable);
        return page.getContent();
    }

    /**
     * Ottiene la lista degli attori con i rispettivi ruoli in un film, dato l'ID del film.
     * Restituisce una lista di mappe contenenti il nome e il ruolo dell'attore.
     *
     * @param id L'ID del film.
     * @return Una lista di mappe, ciascuna contenente il nome e il ruolo di un attore.
     */
    public List<Map<String, String>> getActorsWithRolesByMovieId(Long id) {
        List<Actor> actors = actorRepository.findByMovie_Id(id);

        // Aggiungi un controllo per la lista null o vuota
        if (actors == null || actors.isEmpty()) {
            return Collections.emptyList(); // Restituisci una lista vuota
        }

        return actors.stream()
                .filter(Objects::nonNull) // Filtra eventuali actor null
                .map(actor -> {
                    Map<String, String> actorInfo = new HashMap<>();
                    actorInfo.put("nome",
                            StringUtils.hasText(actor.getNome()) ? actor.getNome() : "Unknown Actor");
                    actorInfo.put("ruolo",
                            StringUtils.hasText(actor.getRuolo()) ? actor.getRuolo() : "Unspecified Role");
                    return actorInfo;
                })
                .collect(Collectors.toList());
    }

    /**
     * Ottiene la lista degli attori con i rispettivi ruoli in un film, dato l'ID del film,
     * limitando i risultati ai primi 15 attori.
     *
     * @param id L'ID del film.
     * @return Una lista di mappe, ciascuna contenente il nome e il ruolo di un attore.
     */
    public List<Map<String, String>> getActorsWithRolesByMovieIdTop15(Long id) {
        List<Actor> actors = actorRepository.findByMovie_Id(id);

        // Aggiungi un controllo per la lista null o vuota
        if (actors == null || actors.isEmpty()) {
            return Collections.emptyList(); // Restituisci una lista vuota
        }

        return actors.stream()
                .limit(15)
                .filter(Objects::nonNull) // Filtra eventuali actor null
                .map(actor -> {
                    Map<String, String> actorInfo = new HashMap<>();
                    actorInfo.put("nome",
                            StringUtils.hasText(actor.getNome()) ? actor.getNome() : "Unknown Actor");
                    actorInfo.put("ruolo",
                            StringUtils.hasText(actor.getRuolo()) ? actor.getRuolo() : "Unspecified Role");
                    return actorInfo;
                })
                .collect(Collectors.toList());
    }

    /**
     * Trova i film con poster associati a un attore specifico.
     *
     * @param actorName Il nome dell'attore da cercare.
     * @return Una lista di film con poster associati all'attore specificato.
     */
    public List<MovieWithPosterDTO> findMoviesByActorName(String actorName) {
        return actorRepository.findMoviesWithPostersByActorName(actorName);
    }
}