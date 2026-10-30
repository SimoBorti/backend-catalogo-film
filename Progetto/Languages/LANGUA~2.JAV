package main.postgresserver.springboot.Languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller REST per la gestione delle richieste relative ai linguaggi.
 * Interagisce con il servizio `LanguageService` per la logica del business.
 */
@RestController
public class LanguageController {

    private final LanguageService languageService;

    /**
     * Costruttore per iniettare il servizio `LanguageService` nel controller.
     *
     * @param languageService Il servizio per la gestione della logica del linguaggio.
     */
    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    /**
     * Gestisce una richiesta GET per ottenere i linguaggi associati a un film tramite il suo ID.
     *
     * @param id L'ID del film per il quale recuperare i linguaggi associati.
     * @return Una lista di stringhe che rappresentano i linguaggi associati al film specificato.
     */
    @GetMapping("/film/languages")
    public List<String> getMovieGenres(@RequestParam Long id) {
        return languageService.getLanguagesById(id);
    }

}
