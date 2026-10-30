package main.postgresserver.springboot.Crew;

import jakarta.persistence.Tuple;
import main.postgresserver.springboot.DTO.MovieWithPosterDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Servizio che fornisce la logica di business per la gestione delle informazioni sui membri del team.
 * Utilizza il repository {@link CrewRepository} per interagire con il database.
 */
@Service
public class CrewService {
    private final CrewRepository crewRepository;

    /**
     * Costruttore del servizio, che inietta il {@link CrewRepository}.
     *
     * @param crewRepository Il repository per la gestione dei membri del team.
     */
    public CrewService(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }



    /**
     * Trova tutti i ruoli ricoperti da una persona specificata, in base all'ID del film e al nome del membro del team.
     *
     * @param id   L'ID del film.
     * @param name Il nome del membro del team.
     * @return Una lista di oggetti {@link Crew} che rappresentano i ruoli ricoperti dalla persona nel film.
     */
    /*public List<Crew> findAllRolesForPerson(Long id, String name) {
        return crewRepository.findAllRolesForPerson(id, name);
    }*/

    /**
     * Restituisce una lista dei nomi dei membri del team per un dato ID e ruolo.
     *
     * @param id   L'ID del film.
     * @param role Il ruolo del membro del team.
     * @return Una lista di nomi dei membri del team che corrispondono all'ID e al ruolo specificati.
     */
    public List<String> findAllNamesByIdAndRole(Long id, String role) {
        return crewRepository.findAllByIdAndRole(id, role)
                .stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    /**
     * Recupera tutti i membri del team di produzione per un determinato film e li organizza per ruolo.
     *
     * @param id l'ID del film
     * @return una mappa in cui le chiavi sono i ruoli e i valori sono le liste dei nomi dei membri del team
     */
    public Map<String, List<String>> getAllCrewByMovieId(Long id) {
        List<Crew> allCrew = crewRepository.findAllByMovieId(id);
        return allCrew.stream()
                .collect(Collectors.groupingBy(
                        Crew::getRole,
                        Collectors.mapping(Crew::getName, Collectors.toList())
                ));
    }

    /**
     * Trova i nomi distinti dei membri del team di produzione in base a una chiave di ricerca.
     *
     * @param chiave la chiave di ricerca (parziale o completa)
     * @param pag il numero della pagina per la paginazione
     * @return una lista contenente i nomi distinti dei membri del team
     */
    public List<String> findByName(String chiave, int pag) {
        Pageable pageable = PageRequest.of(pag, 10, Sort.by("name").ascending());
        Page<String> page = crewRepository.findDistinctNames(chiave, pageable);
        return page.getContent();
    }

    /**
     * Trova i film con poster associati a un membro del team di produzione specificato.
     *
     * @param crewName Il nome del membro del team di produzione da cercare.
     * @return Una lista di film con poster associati al membro del team specificato.
     */
    public List<MovieWithPosterDTO> findMoviesByCrewName(String crewName) {
        return crewRepository.findMoviesWithPostersByCrewName(crewName);
    }

}