package main.postgresserver.springboot.Oscar;

import main.postgresserver.springboot.Movie.Movie;
import main.postgresserver.springboot.Movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Controller per la gestione delle richieste relative agli Oscar vinti dai film.
 * Fornisce un endpoint per ottenere i premi Oscar di un film specifico.
 */
@RestController
public class OscarAwardController {

    private final OscarAwardService oscarAwardService;
    private final MovieService movieService;

    /**
     * Costruttore che inizializza i servizi necessari.
     *
     * @param oscarAwardService Servizio per la gestione degli Oscar.
     * @param movieService Servizio per la gestione dei film.
     */
    @Autowired
    public OscarAwardController(OscarAwardService oscarAwardService, MovieService movieService) {
        this.oscarAwardService = oscarAwardService;
        this.movieService = movieService;
    }

    /**
     * Endpoint per ottenere i premi Oscar vinti da un film.
     *
     * @param id L'ID del film di cui recuperare i premi Oscar.
     * @return Una lista di oggetti OscarAward contenente i premi vinti dal film,
     *         o una lista vuota se il film non esiste.
     */
    @GetMapping("/film/oscars")
    public List<OscarAward> getMovieOscars(@RequestParam Long id) {
        // Recupera il film usando il MovieService
        Optional<Movie> movieOptional = movieService.getMovieById(id);

        // Se il film esiste, recupera gli Oscar
        return movieOptional
                .map(movie -> oscarAwardService.getWinningAwardsByFilm(movie.getTitolo()))
                .orElse(Collections.emptyList()); // Restituisce lista vuota se il film non esiste
    }
}
