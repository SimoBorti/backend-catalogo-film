package main.postgresserver.springboot.Genres;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Servizio che gestisce la logica di business per l'entità Genre.
 * Fornisce metodi per recuperare generi associati ai film.
 */
@Service
public class GenreService {
    private final GenreRepository genreRepository;

    /**
     * Costruttore per iniettare il repository dei generi.
     *
     * @param genreRepository Il repository dei generi.
     */
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    /**
     * Recupera tutti i generi associati a un film dato il suo id.
     *
     * @param id L'id del film.
     * @return Una lista di generi associati al film specificato.
     */
    public List<String> getGenresByMovieId(Long id) {
        List<Genre> genres = genreRepository.findById(id);
        return genres.stream()
                .map(Genre::getGenre)
                .collect(Collectors.toList());
    }
}
