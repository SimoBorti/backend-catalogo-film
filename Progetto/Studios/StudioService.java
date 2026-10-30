package main.postgresserver.springboot.Studios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servizio che gestisce le operazioni relative agli studi cinematografici.
 * <p>
 * Il servizio interagisce con il repository {@link StudioRepository} per recuperare informazioni
 * sugli studi nel database e fornisce metodi per ottenere i dati degli studi associati a un determinato {@code id}.
 * </p>
 */
@Service
public class StudioService {

    private final StudioRepository studioRepository;

    /**
     * Costruttore del servizio {@link StudioService}.
     *
     * @param studioRepository il repository per accedere ai dati degli studi
     */
    public StudioService(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    /**
     * Ottiene una lista di nomi di studi associati a un determinato {@code id}.
     *
     * @param id l'id da cui ottenere gli studi
     * @return una lista di nomi degli studi
     */
    public List<String> getStudiosById(Long id) {
        return studioRepository.findAllById(id)
                .stream()
                .map(Studio::getStudio)
                .collect(Collectors.toList());
    }
}
