package main.postgresserver.springboot.mainController;

import main.postgresserver.springboot.Actor.*;
import main.postgresserver.springboot.Crew.CrewService;
import main.postgresserver.springboot.Movie.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller principale per la gestione delle ricerche di film e attori.
 * Questo controller espone un endpoint per effettuare ricerche sia di film che di attori,
 * con la possibilità di includere i poster dei film nei risultati.
 */
@RestController
public class mainController {

    private final ActorService actorService;
    private final MovieService movieService;
    private final CrewService crewService;

    /**
     * Costruttore per inizializzare il controller con i servizi necessari.
     *
     * @param actorService Il servizio per la gestione delle operazioni relative agli attori.
     * @param movieService Il servizio per la gestione delle operazioni relative ai film.
     * @param crewService  Il servizio per la gestione delle operazioni relative alla troupe.
     */
    public mainController(ActorService actorService, MovieService movieService, CrewService crewService) {
        this.actorService = actorService;
        this.movieService = movieService;
        this.crewService = crewService;
    }

    /**
     * Esegue una ricerca di film o attori in base a una chiave di ricerca e una categoria,
     * includendo i poster dei film nei risultati.
     * Se la categoria è "movies", vengono cercati i film. Se la categoria è "crews", vengono cercati i membri della troupe.
     * Altrimenti, vengono cercati gli attori.
     *
     * @param chiave      La chiave di ricerca per il titolo del film o il nome dell'attore.
     * @param pagina      La pagina di risultati da restituire.
     * @param categoria   La categoria di ricerca: "movies" per film, "crews" per la troupe, altrimenti per attori.
     * @param ordinaPer   Il criterio di ordinamento dei risultati (opzionale, default è "titolo").
     * @return Un oggetto che contiene i risultati della ricerca, inclusi i poster per i film.
     */
    @GetMapping("/findP")
    public resultsList<?> searchMoviesWithPosters(
            @RequestParam String chiave,
            @RequestParam int pagina,
            @RequestParam String categoria,
            @RequestParam(required = false, defaultValue = "titolo") String ordinaPer
    ) {
        if (categoria.equals("movies")) {
            resultsList<Movie> movies = movieService.findByTitleWithPosters(chiave, pagina, ordinaPer);
            return movies;
        } else if (categoria.equals("crews")) {
            List<String> list = crewService.findByName(chiave, pagina);
            resultsList<String> p = new resultsList<>(list, list.size() == 10);
            return p;
        } else {
            List<String> list = actorService.findByName(chiave, pagina);
            resultsList<String> p = new resultsList<>(list, list.size() == 10);
            return p;
        }
    }
}
