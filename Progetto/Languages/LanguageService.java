package main.postgresserver.springboot.Languages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servizio per la gestione della logica di business relativa alle lingue.
 * Fornisce metodi per ottenere le lingue associate a un determinato ID.
 */
@Service
public class LanguageService {

    /**
     * Repository per l'accesso ai dati delle lingue.
     * Utilizzato dal servizio `LanguageService` per recuperare informazioni sulle lingue.
     */
    private final LanguageRepository languageRepository;


    /**
     * Costruttore che inizializza il servizio con il repository delle lingue.
     *
     * @param languageRepository Il repository per l'accesso ai dati delle lingue.
     */
    @Autowired
    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    /**
     * Restituisce una lista di lingue associate a un determinato ID.
     *
     * @param id L'ID per il quale trovare le lingue.
     * @return Una lista di stringhe contenente le lingue associate all'ID fornito.
     */
    public List<String> getLanguagesById(Long id) {
        return languageRepository.findAllById(id)
        .stream()
        .map(Language::getLanguage)
        .collect(Collectors.toList());
    }
}
