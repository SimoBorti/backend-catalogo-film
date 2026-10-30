package main.postgresserver.springboot.Theme;

import main.postgresserver.springboot.Posters.PostersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller REST per la gestione dei temi associati ai film.
 * <p>
 * Questo controller espone le API che permettono di interagire con i temi tramite il servizio {@link ThemeService}.
 * </p>
 */
@RestController
public class ThemeController {

    /**
     * Servizio che gestisce le operazioni relative ai temi cinematografici.
     * <p>
     * Il campo {@code themeService} è utilizzato per accedere alla logica di business associata alla gestione dei temi
     * e interagire con il repository per recuperare e manipolare i dati dei temi cinematografici.
     * </p>
     */
    private final ThemeService themeService;

    /**
     * Costruttore del controller {@link ThemeController}.
     * Inizializza il servizio {@link ThemeService} per la gestione dei temi.
     *
     * @param themeService il servizio da utilizzare per le operazioni sui temi
     */
    @Autowired
    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }


    /**
     * Ottiene i temi associati a un film specifico, identificato dall'ID.
     * <p>
     * Questo metodo utilizza il servizio {@link ThemeService} per recuperare i temi associati a un film
     * specifico, identificato dall'ID. I temi sono restituiti come lista di stringhe.
     * </p>
     *
     * @param id L'ID del film di cui si vogliono ottenere i temi associati.
     * @return Una lista contenente i temi associati al film specificato.
     */
    @GetMapping("/film/themes")
    public List<String> getMovieTheme(@RequestParam Long id) {
        return themeService.getThemeByMovieId(id);
    }



}
