package main.postgresserver.springboot.Posters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servizio per la gestione dei poster.
 * <p>
 * Questa classe fornisce metodi per eseguire operazioni CRUD (Creazione, Lettura, Aggiornamento, Cancellazione)
 * sui poster tramite il repository {@link PostersRepository}.
 * </p>
 */
@Service
public class PostersService {

    private final PostersRepository postersRepository;

    /**
     * Costruttore del servizio che inietta il repository {@link PostersRepository}.
     * @param postersRepository il repository per la gestione dei poster
     */
    @Autowired
    public PostersService(PostersRepository postersRepository) {
        this.postersRepository = postersRepository;
    }

    /**
     * Restituisce tutti i poster.
     * @return una lista di tutti i poster
     */
    public List<Poster> getPosters() {
        return postersRepository.findAll();
    }

    /**
     * Restituisce un poster in base al suo ID.
     * @param id l'ID del poster
     * @return un {@link Optional} contenente il poster trovato, o vuoto se non trovato
     */
    public Optional<Poster> getPosterById(Long id) {
        return postersRepository.findById(id);
    }

    /**
     * Aggiunge un nuovo poster.
     * @param poster il poster da aggiungere
     * @return il poster appena aggiunto
     */
    public Poster addPoster(Poster poster) {
        return postersRepository.save(poster);
    }

    /**
     * Aggiorna un poster esistente.
     * @param poster il poster da aggiornare
     * @return il poster aggiornato
     */
    public Poster updatePoster(Poster poster) {
        return postersRepository.save(poster);
    }

    /**
     * Restituisce il link di un poster in base al suo ID.
     * @param id l'ID del poster
     * @return il link del poster, o {@code null} se il poster non esiste
     */
    public String getLinkById(Long id) {
        Optional<Poster> poster = postersRepository.findById(id);
        return poster.map(Poster::getLink).orElse(null);
    }

    /**
     * Elimina un poster in base al suo ID.
     * @param id l'ID del poster da eliminare
     */
    public void deletePoster(Long id) {
        postersRepository.deleteById(id);
    }
}
