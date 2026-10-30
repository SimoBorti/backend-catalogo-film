package main.postgresserver.springboot.Oscar;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * Servizio che gestisce le operazioni relative agli Oscar Award.
 * <p>
 * Questa classe fornisce metodi per recuperare i premi Oscar da un repository, inclusi i premi vinti da un determinato film.
 * </p>
 */
@Service
public class OscarAwardService {

    private final OscarAwardRepository oscarAwardRepository;

    /**
     * Costruttore per inizializzare il servizio con il repository degli Oscar Award.
     * @param oscarAwardRepository il repository da cui recuperare i dati sugli Oscar Award
     */
    public OscarAwardService(OscarAwardRepository oscarAwardRepository) {
        this.oscarAwardRepository = oscarAwardRepository;
    }

    /**
     * Recupera tutti gli Oscar Award.
     * @return una lista di tutti gli Oscar Award presenti nel repository
     */
    public List<OscarAward> getAll() {
        return oscarAwardRepository.findAll();
    }

    /**
     * Recupera un Oscar Award in base al suo ID.
     * @param id l'ID dell'Oscar Award da recuperare
     * @return un oggetto Optional contenente l'Oscar Award se trovato, altrimenti vuoto
     */
    public Optional<OscarAward> getById(Long id) {
        return oscarAwardRepository.findById(id);
    }

    /**
     * Recupera tutti i premi Oscar vinti da un determinato film.
     * @param film il titolo del film per cui recuperare i premi vinti
     * @return una lista di Oscar Award vinti dal film specificato
     */
    public List<OscarAward> getWinningAwardsByFilm(String film){
        return oscarAwardRepository.findByFilmAndWinner(film, true);
    }
}
