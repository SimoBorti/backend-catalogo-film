package main.postgresserver.springboot.Actor;

import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import main.postgresserver.springboot.Movie.Movie;

import java.util.List;
import java.util.Map;

import java.util.List;

/**
 * Controller REST per gestire le richieste relative agli attori.
 *
 * @version 1.0
 */
@RestController
public class ActorController {

    /**
     * Il servizio per la gestione degli attori.
     */
    private final ActorService actorService;

    /**
     * Costruttore per l'ActorController con il servizio per la gestione degli attori.
     *
     * @param actorService il servizio per la gestione degli attori
     */
    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    /**
     * Restituisce la lista dei film di un attore.
     *
     * @param actorName il nome dell'attore
     * @return la lista dei film dell'attore
     */
    @GetMapping("/actor/movies")
    public List<MovieWithPosterDTO> getMoviesByActor(@RequestParam String actorName) {
        return actorService.findMoviesByActorName(actorName);
    }

    /**
     * Restituisce la lista degli attori di un film.
     *
     * @param id l'ID del film
     * @return la lista degli attori del film
     */
    @GetMapping("/film/actors")
    public List<Map<String, String>> getMovieActors(@RequestParam Long id) {
        return actorService.getActorsWithRolesByMovieId(id);
    }

    /**
     * Restituisce la lista degli attori di un film (solo i primi 15 risultati).
     *
     * @param id l'ID del film
     * @return la lista degli attori del film (solo i primi 15 risultati)
     */
    @GetMapping("/film/actors15")
    public List<Map<String, String>> getMovieActors15(@RequestParam Long id) {
        return actorService.getActorsWithRolesByMovieIdTop15(id);
    }
}