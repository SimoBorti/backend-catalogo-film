package main.postgresserver.springboot.Movie;


import main.postgresserver.springboot.DTO.MovieBasicDTO;

import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import main.postgresserver.springboot.Posters.PostersService;
import main.postgresserver.springboot.DTO.ThemeMapping;
import main.postgresserver.springboot.mainController.resultsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import main.postgresserver.springboot.Movie.MovieBasicProjection;
import main.postgresserver.springboot.Movie.MovieBasicPojectionNoPoster;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
/**
 * Service che gestisce le operazioni relative ai film, inclusi la ricerca e la gestione dei dettagli dei film.
 */
public class MovieService {
    private final MovieRepository movieRepository;
    private final PostersService postersService;

    private final ProjectInfoProperties projectInfoProperties;

    /**
     * Costruttore per iniettare i servizi necessari.
     * @param movieRepository Repository per la gestione dei film.
     * @param postersService Servizio per la gestione dei poster.

     * @param projectInfoProperties Proprietà del progetto.
     */
    @Autowired
    public MovieService(MovieRepository movieRepository, PostersService postersService, ProjectInfoProperties projectInfoProperties) {
        this.movieRepository = movieRepository;
        this.postersService = postersService;

        this.projectInfoProperties = projectInfoProperties;
    }

    /**
     * Recupera un film in base al suo ID.
     * @param id ID del film.
     * @return Un'opzione contenente il film, se trovato.
     */
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);

    }

    /**
     * Recupera un film con solo le informazioni base (senza poster) in base al suo ID.
     * @param id ID del film.
     * @return Un oggetto contenente le informazioni base del film.
     */
    public MovieBasicPojectionNoPoster getMovieBaseById(Long id) {
        return movieRepository.findProjectedById(id);
    }

    /**
     * Recupera i dettagli completi di un film in base al suo ID.
     * @param id ID del film.
     * @return Un oggetto contenente i dettagli completi del film.
     */
    public MovieDetailProjection getMovieDetailById(Long id) {
        return movieRepository.findDetailProjectionById(id);
    }

    /**
     * Cerca film in base al titolo, con paginazione.
     * @param titolo Titolo del film da cercare.
     * @param pag Numero della pagina da recuperare.
     * @return Una lista di film che corrispondono al titolo dato.
     */
    public List<Movie> findByTitle(String titolo, int pag) {
        Pageable pageable=PageRequest.of(pag, 10, Sort.by("titolo").ascending());
        Page<Movie> page=movieRepository.findByTitoloContainingIgnoreCase(titolo, pageable);
        return page.getContent();
    }

    /**
     * Cerca film in base al titolo, con paginazione e aggiunta dei poster.
     * @param titolo Titolo del film da cercare.
     * @param pag Numero della pagina da recuperare.
     * @param ordinaPer Criterio di ordinamento dei film.
     * @return Una lista di film con poster associato.
     */
    public resultsList<Movie> findByTitleWithPosters(String titolo, int pag, String ordinaPer) {
        Pageable pageable;
        System.out.println("ordina per " + ordinaPer);
        switch(ordinaPer) {
            case "rating":
                pageable = PageRequest.of(pag, 10, Sort.by(Sort.Order.desc("rating"), Sort.Order.asc("rating").nullsLast()));
                break;
            case "dataUscita":
                pageable = PageRequest.of(pag, 10, Sort.by(
                        Sort.Order.desc("data").nullsLast()
                      //  Sort.Order.desc("data")
                ));
                break;
            default:
                pageable = PageRequest.of(pag, 10, Sort.by("titolo").ascending());
        }

        Page<Movie> page = movieRepository.findByTitoloContainingIgnoreCase(titolo, pageable);
        List<Movie> movies = page.getContent().stream()
                .map(movie -> {
                    // Prepara un nuovo oggetto Movie con solo i campi necessari
                    Movie slimMovie = new Movie(
                            movie.getId(),
                            movie.getTitolo(),
                            movie.getDescrizione(),  // descrizione
                            movie.getData(),
                            null,  // minute
                            movie.getRating(),
                            null   // tagline
                    );

                    // Imposta il poster link
                    String posterLink = postersService.getLinkById(movie.getId());
                    slimMovie.setPosterLink(posterLink);

                    return slimMovie;
                })
                .collect(Collectors.toList());

        return new resultsList<>(movies, page.hasNext());
    }

    /**
     * Metodo helper per gestire valori nulli o vuoti in input.
     * @param a Valore di input.
     * @return Il valore dell'input o "DUMMYUFT" se vuoto.
     */
    public static String dummy(String a) {
        if (a == null || a.isEmpty()) {
            a ="DUMMYUFT";
        }
        return a;
    }

    /**
     * Esegui una ricerca avanzata sui film con numerosi parametri di filtro.
     * @param title Titolo del film.
     * @param cast Nome dell'attore.
     * @param character Ruolo dell'attore nel film.
     * @param studio Studio di produzione del film.
     * @param country Paese di origine del film.
     * @param startDate Data di inizio per il filtro.
     * @param endDate Data di fine per il filtro.
     * @param startRating Rating minimo per il filtro.
     * @param endRating Rating massimo per il filtro.
     * @param startDuration Durata minima del film.
     * @param endDuration Durata massima del film.
     * @param oscar Tipo di Oscar (candidates o winners).
     * @param languagees Lingua del film.
     * @param categories Categorie del film.
     * @param page Numero della pagina da recuperare.
     * @return Una lista di film che corrispondono ai criteri di ricerca avanzata.e
     * il fatto se ci sono elementi dopo
     */
    public resultsList<MovieBasicProjection> advancedSearch(
            String title,
            String cast,
            String character,
            String studio,
            String country,
            Integer startDate,
            Integer endDate,
            Double startRating,
            Integer endRating,
            Integer startDuration,
            Integer endDuration,
            String oscar,
            String languagees,
            String categories,
            String Themes,
            int page
    ) {
        List<String> myList = (categories == null || categories.isEmpty())
                ? Collections.singletonList("DUMMY")
                : Arrays.asList(categories.split(","));

        List<String> themeList = ThemeMapping.parseThemes(Themes);
        int themeListSize = themeList.size();

        cast = dummy(cast);
        character = dummy(character);
        oscar = dummy(oscar);
        languagees = dummy(languagees);

        Pageable pageable = PageRequest.of(page, 10, Sort.by("titolo").ascending());

        Page<MovieBasicDTO> moviePage = movieRepository.advancedSearchBasic(
                title,
                startDate, endDate, startRating, endRating,
                startDuration, endDuration, country, studio, cast, character, oscar, languagees,
                myList, myList.size(),themeList,themeListSize,
                pageable
        );

        List<MovieBasicDTO> movies = moviePage.getContent();
        movies.forEach(movie -> {
            String posterLink = postersService.getLinkById(movie.getId());
            movie.setPosterLink(posterLink);
        });

        System.out.println("Returning results:");
        movies.forEach(movie -> {
            System.out.println("Movie: " + movie.getTitolo() +
                    ", ID: " + movie.getId() +
                    ", Rating: " + movie.getRating() +
                    ", Poster: " + movie.getPosterLink());
        });

        // Verifica se esiste una pagina successiva
        boolean hasNextPage = moviePage.hasNext();

        return new resultsList<>(
                (List<MovieBasicProjection>)(List<?>) movies,
                hasNextPage  // Ora usa hasNext() invece di controllare la dimensione
        );
    }

    @Cacheable("topMovies")
    public List<MovieWithPosterDTO> getTopRatedRecentMovies() {
        LocalDate cutoffDate = LocalDate.now().minusMonths(6);
        return movieRepository.findTopRatedRecent(
                cutoffDate,
                PageRequest.of(0, 10)
        );
    }




}
