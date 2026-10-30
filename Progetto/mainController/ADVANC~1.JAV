package main.postgresserver.springboot.mainController;

import main.postgresserver.springboot.Actor.ActorService;
import main.postgresserver.springboot.Countries.CountryService;
import main.postgresserver.springboot.Movie.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller REST per gestire le ricerche avanzate dei film.
 * Questo controller espone un endpoint per eseguire ricerche avanzate in base ai vari parametri.
 */
@RestController
public class AdvancedSearchController {

    // private final ActorService actorService;
    private final MovieService movieService;
    // private final CountryService countryService;

    /**
     * Costruttore per inizializzare il controller con il servizio dei film.
     *
     * @param movieService Il servizio per la gestione delle operazioni relative ai film.
     */
    public AdvancedSearchController(MovieService movieService) {
        // this.actorService = actorService;
        this.movieService = movieService;
        // this.countryService = countryService;
    }

    /**
     * Endpoint per eseguire una ricerca avanzata dei film.
     * Questo metodo consente di cercare film in base a diversi criteri come titolo, attori, paese, data, rating, durata, e altri.
     *
     * @param title        Il titolo del film da cercare.
     * @param cast         Gli attori coinvolti nel film.
     * @param character    I caratteri interpretati nel film.
     * @param studio       Lo studio di produzione del film.
     * @param country      Il paese del film.
     * @param startDate    L'anno di inizio della ricerca per la data di rilascio.
     * @param endDate      L'anno di fine della ricerca per la data di rilascio.
     * @param startRating  Il valore minimo del rating per la ricerca.
     * @param endRating    Il valore massimo del rating per la ricerca.
     * @param startDuration La durata minima del film.
     * @param endDuration  La durata massima del film.
     * @param oscar        Il premio Oscar associato al film.
     * @param languages    Le lingue in cui è stato realizzato il film.
     * @param categories   Le categorie di film (genere, etc.).
     * @param pagina       Il numero della pagina da restituire (default a 0).
     * @return Un oggetto `resultsList` contenente i film che soddisfano i criteri di ricerca.
     */
    @GetMapping("/findAdvanced")
    public resultsList<?> searchMoviesAdvanced(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String cast,
            @RequestParam(required = false) String character,
            @RequestParam(required = false) String studio,
            @RequestParam(required = false) String country,
            @RequestParam(required = false) Integer startDate,
            @RequestParam(required = false) Integer endDate,
            @RequestParam(required = false) Double startRating,
            @RequestParam(required = false) Integer endRating,
            @RequestParam(required = false) Integer startDuration,
            @RequestParam(required = false) Integer endDuration,
            @RequestParam(required = false) String oscar,
            @RequestParam(required = false) String languages,
            @RequestParam(required = false) String categories,
            @RequestParam(required = false) String themes,
            @RequestParam(defaultValue = "0") int pagina
    ) {
        return movieService.advancedSearch(
                title,
                cast,
                character,
                studio,
                country,
                startDate,
                endDate,
                startRating,
                endRating,
                startDuration,
                endDuration,
                oscar,
                languages,
                categories,
                themes,
                pagina
        );
    }
}
