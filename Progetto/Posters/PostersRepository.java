package main.postgresserver.springboot.Posters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository per gestire l'accesso ai dati relativi ai {@link Poster}.
 * <p>
 * L'interfaccia {@link PostersRepository} estende {@link JpaRepository} e fornisce i metodi per effettuare operazioni
 * CRUD (Create, Read, Update, Delete) sull'entità {@link Poster}, interagendo direttamente con il database.
 * </p>
 */
@Repository
public interface PostersRepository extends JpaRepository<Poster, Long> {
}
