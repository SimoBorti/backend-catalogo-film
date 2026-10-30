package main.postgresserver.springboot.Genres;

import main.postgresserver.springboot.Genres.GenreService;
import main.postgresserver.springboot.Genres.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller REST per gestire le richieste relative ai generi dei film.
 * Fornisce metodi per ottenere i generi associati a un film.
 */
@RestController
public class GenreController {
    private final GenreService genreService;

    /**
     * Costruttore che inietta il servizio per la gestione dei generi.
     *
     * @param genreService Il servizio per gestire le operazioni relative ai generi.
     */
    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    /**
     * Restituisce i generi associati a un film specifico.
     * <p>
     * Questo metodo recupera l'elenco dei generi del film in base all'ID fornito.
     *
     * @param id l'ID del film di cui ottenere i generi
     * @return una lista di stringhe rappresentanti i generi del film
     */
    @GetMapping("/film/genres")
    public List<String> getMovieGenres(@RequestParam Long id) {
        return genreService.getGenresByMovieId(id);
    }



}