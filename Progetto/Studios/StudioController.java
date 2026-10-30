package main.postgresserver.springboot.Studios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe che gestisce le richieste HTTP relative agli studi cinematografici.
 * <p>
 * La classe {@link StudioController} è un controller REST che espone API per interagire con i dati degli studi cinematografici
 * tramite il repository {@link StudioRepository}. Attualmente, la classe è configurata per gestire le richieste,
 * ma non implementa alcun metodo di manipolazione specifico dei dati.
 * </p>
 */
@RestController
public class StudioController {

    private final StudioService studioService;

    /**
     * Costruttore per inizializzare il controller con il servizio {@link StudioService}.
     *
     * @param studioService Il servizio per gestire la logica di business relativa agli studi cinematografici.
     */
    public StudioController(StudioService studioService) {
        this.studioService = studioService;
    }

    /**
     * Restituisce un elenco degli studi cinematografici associati a un film dato il suo ID.
     * <p>
     * Questo metodo gestisce le richieste GET all'endpoint "/film/studio" e utilizza il parametro `id` per recuperare gli studi
     * dal servizio {@link StudioService}.
     * </p>
     *
     * @param id L'ID del film per il quale recuperare gli studi cinematografici.
     * @return Una lista di stringhe contenente i nomi degli studi cinematografici associati al film.
     */
    @GetMapping("/film/studio")
    public List<String> getMovieStudios(@RequestParam Long id) {
        return studioService.getStudiosById(id);
    }
}
