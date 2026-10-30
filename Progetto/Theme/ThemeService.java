package main.postgresserver.springboot.Theme;

import jakarta.persistence.*;
import main.postgresserver.springboot.Genres.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Servizio che gestisce le operazioni relative agli {@link Theme}.
 * <p>
 * La classe {@link ThemeService} fornisce metodi per recuperare tutte le istanze di {@link Theme}
 * o cercare un {@link Theme} specifico tramite il suo ID, utilizzando il repository {@link ThemeRepository}.
 * </p>
 */
@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    /**
     * Costruttore del servizio {@link ThemeService}.
     * <p>
     * Inietta il {@link ThemeRepository} necessario per l'accesso al database.
     * </p>
     *
     * @param themeRepository Il repository per l'entità {@link Theme}.
     */
    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    /**
     * Recupera tutti i temi.
     *
     * @return Una lista contenente tutti i {@link Theme}.
     */
    public List<Theme> getAll() {
        return themeRepository.findAll();
    }

    /**
     * Recupera un tema specifico tramite l'ID.
     *
     * @param id L'ID del tema da cercare.
     * @return Un oggetto {@link Optional} contenente il tema se trovato, altrimenti vuoto.
     */
    public List<String> getThemeByMovieId(Long id) {
        List<Theme> genres = themeRepository.findById(id);
        return genres.stream()
                .map(Theme::getTheme)
                .collect(Collectors.toList());
    }
}
