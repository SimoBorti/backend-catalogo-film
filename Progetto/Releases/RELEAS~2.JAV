package main.postgresserver.springboot.Releases;

import main.postgresserver.springboot.Releases.ReleaseService;
import main.postgresserver.springboot.Releases.Release;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;

/**
 * Controller REST per la gestione delle release.
 * <p>
 * La classe {@link ReleaseController} espone endpoint per la gestione delle release di film.
 * Essa interagisce con il servizio {@link ReleaseService} per recuperare e manipolare i dati delle release.
 * </p>
 */
@RestController
public class ReleaseController {
    private final ReleaseService releaseService;

    /**
     * Costruttore che inietta il servizio {@link ReleaseService}.
     * @param releaseService il servizio per la gestione delle release
     */
    @Autowired
    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

}
