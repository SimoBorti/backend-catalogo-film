package main.postgresserver.springboot.Posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST per gestire le operazioni relative ai poster.
 * <p>
 * Questa classe espone endpoint per interagire con i dati dei poster tramite il servizio {@link PostersService}.
 * </p>
 */
@RestController
public class PostersController {

    private final PostersService postersService;

    /**
     * Costruttore del controller che inietta il servizio {@link PostersService}.
     * @param postersService il servizio per la gestione dei poster
     */
    @Autowired
    public PostersController(PostersService postersService){
        this.postersService = postersService;
    }

    /**
     * Recupera il link del poster del film tramite l'ID.
     * Questo metodo invoca il servizio dei poster per ottenere il collegamento al poster del film.
     *
     * @param id L'ID del film di cui recuperare il poster.
     * @return Il link del poster del film, sotto forma di stringa.
     */
    @GetMapping("/film/poster")
    public String getMovieGenres(@RequestParam Long id) {
        return postersService.getLinkById(id);
    }
}