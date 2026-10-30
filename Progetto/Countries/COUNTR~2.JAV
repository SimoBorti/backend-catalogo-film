package main.postgresserver.springboot.Countries;

import main.postgresserver.springboot.Countries.CountryService;
import main.postgresserver.springboot.Countries.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controller REST che gestisce le richieste relative ai paesi.
 * Fornisce endpoint per recuperare informazioni sui paesi dal sistema.
 *
 * @version 1.0
 */
@RestController
public class CountryController {

    /**
     * Il servizio che gestisce la logica di business per i paesi.
     */
    private final CountryService countryService;

    /**
     * Costruttore che inizializza il controller con il servizio {@link CountryService}.
     *
     * @param countryService Il servizio per la gestione dei paesi.
     */
    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    /**
     * Recupera la lista dei paesi di un film.
     * <p>
     * L'endpoint {@code /film/countries} restituisce la lista dei paesi di un film
     * identificato dal parametro {@code id}.
     * </p>
     * <p>
     * La lista dei paesi viene restituita come lista di stringhe.
     * </p>
     * @param id L'ID del film di cui si vuole conoscere la lista dei paesi.
     * @return La lista dei paesi del film.
     */
    @GetMapping("/film/countries")
    public List<String> getMovieCountries(@RequestParam Long id) {
        return countryService.getCountriesById(id);
    }

}