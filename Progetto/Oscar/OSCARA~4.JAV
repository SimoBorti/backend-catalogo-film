package main.postgresserver.springboot.Oscar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * L'interfaccia {@code OscarAwardRepository} estende {@link JpaRepository} e fornisce i metodi per eseguire
 * operazioni di persistenza sul database riguardanti i premi Oscar. Questa interfaccia consente di accedere
 * e manipolare i dati nella tabella {@code the_oscar_awards}.
 * <p>
 * Il repository fornisce funzionalità per interagire con l'entità {@link OscarAward}, come la ricerca dei premi
 * associati a un film e il filtraggio in base al vincitore del premio.
 * </p>
 */
@Repository
public interface OscarAwardRepository extends JpaRepository<OscarAward, Long> {

    /**
     * Trova una lista di premi Oscar associati a un film e al suo stato di vincitore.
     * <p>
     * Questo metodo recupera tutti i premi per un dato film e verifica se sono stati vinti o meno.
     * </p>
     *
     * @param film il titolo del film per il quale recuperare i premi
     * @param winner un valore booleano che indica se recuperare i premi vinti (true) o non vinti (false)
     * @return una lista di {@link OscarAward} che corrispondono ai criteri di ricerca
     */
    List<OscarAward> findByFilmAndWinner(String film, boolean winner);
}
