package main.postgresserver.springboot.Releases;

import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Servizio per la gestione delle operazioni relative alle entità {@link Release}.
 * <p>
 * La classe {@link ReleaseService} fornisce i metodi per interagire con il repository delle release,
 * in particolare per recuperare tutte le release in base all'ID.
 * </p>
 */
@Service
public class ReleaseService {

    private final ReleaseRepository releaseRepository;

    /**
     * Costruttore del servizio per inizializzare il repository delle release.
     * @param releaseRepository il repository delle release da utilizzare nel servizio
     */
    public ReleaseService(ReleaseRepository releaseRepository) {
        this.releaseRepository = releaseRepository;
    }

    /**
     * Trova tutte le release con un determinato ID.
     * @param id l'ID della release
     * @return una lista di {@link Release} che corrispondono all'ID fornito
     */
    public List<Release> findAllById(Long id) {
        return releaseRepository.findAllById(id);
    }
}
