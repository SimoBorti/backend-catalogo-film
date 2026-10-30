package main.postgresserver.springboot.Crew;

import main.postgresserver.springboot.Crew.CrewService;
import main.postgresserver.springboot.Crew.Crew;
import main.postgresserver.springboot.DTO.CrewRole;
import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * Controller REST che gestisce le richieste HTTP relative ai membri del team di produzione (Crew).
 * Fornisce un'interfaccia per ottenere informazioni sui membri del team di produzione
 * associati a un determinato film.
 */
@RestController
public class CrewController {

    /**
     * Servizio per la gestione della logica di business relativa ai membri del team di produzione.
     */
    private final CrewService crewService;

    /**
     * Costruttore che inietta il servizio {@link CrewService} per la gestione della crew.
     *
     * @param crewService Il servizio che gestisce i membri del team di produzione.
     */
    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    /**
     * Recupera una mappa dei ruoli della crew per un determinato film.
     *
     * @param id L'ID del film di cui recuperare i membri della crew.
     * @return Una mappa con due chiavi: "directors" e "producers", ciascuna contenente una lista di nomi.
     */
    @GetMapping("/film/crew")
    public Map<String, List<String>> getMovieCrew(@RequestParam Long id) {
        return Map.of(
                "directors", crewService.findAllNamesByIdAndRole(id, "Director"),
                "producers", crewService.findAllNamesByIdAndRole(id, "Producer")
        );
    }

    /**
     * Recupera informazioni dettagliate sui membri tecnici della crew per un determinato film.
     *
     * Questo metodo ottiene una mappa dei ruoli della crew associati al film specificato
     * e popola un oggetto {@link CrewRole} con vari ruoli tecnici, tra cui Regista,
     * Produttore, Direttore della Fotografia, Montatore, Tecnico del Suono, Compositore e altri.
     *
     * @param id L'ID del film di cui recuperare i dettagli della crew tecnica.
     * @return Un oggetto {@link CrewRole} contenente le liste dei membri della crew per ciascun ruolo specifico.
     */
    @GetMapping("/film/crew-tecnico")
    public CrewRole getDetailedTechnicalCrew(@RequestParam Long id) {
        Map<String, List<String>> crewByRole = crewService.getAllCrewByMovieId(id);

        CrewRole ruoliTecnici = new CrewRole();
        ruoliTecnici.setRegista(crewByRole.getOrDefault("Director", List.of()));
        ruoliTecnici.setProduttore(crewByRole.getOrDefault("Producer", List.of()));
        ruoliTecnici.setDirettoreFotografia(crewByRole.getOrDefault("Cinematography", List.of()));
        ruoliTecnici.setMontatore(crewByRole.getOrDefault("Editor", List.of()));
        ruoliTecnici.setTecnicoSuono(crewByRole.getOrDefault("Sound", List.of()));
        ruoliTecnici.setCompositore(crewByRole.getOrDefault("Composer", List.of()));
        ruoliTecnici.setProduttoreEsecutivo(crewByRole.getOrDefault("Executive producer", List.of()));
        ruoliTecnici.setStuntman(crewByRole.getOrDefault("Stunts", List.of()));
        ruoliTecnici.setTruccatore(crewByRole.getOrDefault("Makeup", List.of()));
        ruoliTecnici.setAssistenteRegista(crewByRole.getOrDefault("Assistant director", List.of()));
        ruoliTecnici.setDirettoreArtistico(crewByRole.getOrDefault("Art direction", List.of()));
        ruoliTecnici.setScenografo(crewByRole.getOrDefault("Production design", List.of()));
        ruoliTecnici.setCostumista(crewByRole.getOrDefault("Costume design", List.of()));
        ruoliTecnici.setOperatoreCamera(crewByRole.getOrDefault("Camera operator", List.of()));
        ruoliTecnici.setDecoratoreSet(crewByRole.getOrDefault("Set decoration", List.of()));
        ruoliTecnici.setCasting(crewByRole.getOrDefault("Casting", List.of()));
        ruoliTecnici.setScrittoreOriginale(crewByRole.getOrDefault("Original writer", List.of()));
        ruoliTecnici.setEffettiVisivi(crewByRole.getOrDefault("Visual effects", List.of()));
        ruoliTecnici.setTecnicoIlluminazione(crewByRole.getOrDefault("Lighting", List.of()));
        ruoliTecnici.setParrucchiere(crewByRole.getOrDefault("Hairstyling", List.of()));
        ruoliTecnici.setFotografiaAggiuntiva(crewByRole.getOrDefault("Additional photography", List.of()));
        ruoliTecnici.setEffettiSpeciali(crewByRole.getOrDefault("Special effects", List.of()));
        ruoliTecnici.setCanzoni(crewByRole.getOrDefault("Songs", List.of()));
        ruoliTecnici.setStoria(crewByRole.getOrDefault("Story", List.of()));
        ruoliTecnici.setRegiaAggiuntiva(crewByRole.getOrDefault("Additional directing", List.of()));
        ruoliTecnici.setCoreografia(crewByRole.getOrDefault("Choreography", List.of()));
        ruoliTecnici.setTitoloDesign(crewByRole.getOrDefault("Title design", List.of()));
        ruoliTecnici.setCoDirettore(crewByRole.getOrDefault("Co-director", List.of()));

        return ruoliTecnici;
    }

    /**
     * Ottiene la lista dei film in cui compare il membro della crew specificato.
     *
     * @param crewName Il nome del membro della crew di cui ottenere la lista dei film.
     * @return Una lista di oggetti {@link MovieWithPosterDTO} contenente i film in cui compare il membro della crew.
     */
    @GetMapping("/crew/movies")
    public List<MovieWithPosterDTO> getMoviesByActor(@RequestParam String crewName) {
        return crewService.findMoviesByCrewName(crewName);
    }

}
