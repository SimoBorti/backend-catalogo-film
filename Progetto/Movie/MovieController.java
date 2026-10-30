package main.postgresserver.springboot.Movie;

import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Controller REST che gestisce le operazioni relative ai film.
 * La classe offre vari endpoint per interagire con il servizio dei film.
 */
@RestController
public class MovieController {
    private final MovieService movieService;

    /**
     * Costruttore del controller che inietta il servizio dei film.
     *
     * @param movieService Il servizio che gestisce la logica dei film.
     */
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Ottiene le informazioni di base su un film, senza il poster.
     * Questo metodo restituisce un sottoinsieme dei dati relativi a un film identificato dall'ID,
     * senza includere il link al poster.
     *
     * @param id L'ID del film di cui si vogliono ottenere le informazioni di base.
     * @return Un oggetto che rappresenta le informazioni di base del film,
     *         come il titolo, la descrizione, la data, la durata, il rating e il tagline.
     */
    @GetMapping("/film/base")
    public MovieBasicPojectionNoPoster getSingleMovie(@RequestParam Long id) {
        return movieService.getMovieBaseById(id);
    }

    /**
     * Ottiene i dettagli completi di un film, inclusi i dati estesi come attori, crew, generi, etc.
     * Questo metodo restituisce tutte le informazioni dettagliate relative a un film, come il titolo,
     * la descrizione, il rating, ma anche gli attori, il cast tecnico e altri dettagli.
     *
     * @param id L'ID del film di cui si vogliono ottenere i dettagli completi.
     * @return Un oggetto che rappresenta i dettagli completi del film, inclusi attori, crew, generi, ecc.
     */
    @GetMapping("/film/dettagli")
    public MovieDetailProjection getMovieDetails(@RequestParam Long id) {
        return movieService.getMovieDetailById(id);
    }




    @GetMapping("/top-movies")
    public ResponseEntity<List<MovieWithPosterDTO>> getTopMovies() {
        return ResponseEntity.ok(movieService.getTopRatedRecentMovies());
    }



}
