package main.postgresserver.springboot.Countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servizio che gestisce la logica di business per i paesi.
 * Interagisce con il repository {@link CountryRepository} per recuperare i dati dei paesi.
 */
@Service
public class CountryService {

    /**
     * Il repository per l'accesso ai dati dei paesi.
     */
    private final CountryRepository countryRepository;

    /**
     * Costruttore che inizializza il servizio con il repository {@link CountryRepository}.
     *
     * @param countryRepository Il repository per la gestione dei dati dei paesi.
     */
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }



    /**
     * Restituisce una lista di nomi di paesi per un determinato ID.
     *
     * @param id L'ID del paese.
     * @return Una lista di nomi di paesi associati all'ID specificato.
     */
    public List<String> getCountriesById(Long id) {
        return countryRepository.findAllById(id)
                .stream()
                .map(Country::getCountry)
                .collect(Collectors.toList());
    }

}