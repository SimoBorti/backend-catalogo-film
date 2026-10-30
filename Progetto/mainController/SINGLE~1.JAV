package main.postgresserver.springboot.mainController;


import main.postgresserver.springboot.Movie.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller per gestire le richieste relative ai dettagli di un singolo film.
 * Fornisce due endpoint per ottenere informazioni dettagliate su un film.
 */
@RestController
public class SingleMovie {
    private final MovieService movieService;

    /**
     * Costruttore per inizializzare il servizio del film.
     *
     * @param movieService Il servizio per la gestione dei film.
     */
    @Autowired
    public SingleMovie(MovieService movieService) {
        this.movieService = movieService;
    }


}
