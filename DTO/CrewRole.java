package main.postgresserver.springboot.DTO;
import lombok.Data;
import java.util.List;

/**
 * Classe DTO (Data Transfer Object) che rappresenta i vari ruoli all'interno della troupe di un film.
 * Ogni ruolo è rappresentato da una lista di nomi delle persone che ricoprono quel ruolo nel film.
 */
@Data
public class CrewRole {
    /**
     * Lista di nomi dei produttori (Producers).
     */
    public List<String> produttore;
    /**
     * Lista di nomi dei registi (Directors).
     */
    public List<String> regista;
    /**
     * Lista di nomi dei direttori della fotografia (Cinematography).
     */
    private List<String> direttoreFotografia;

    /**
     * Lista di nomi dei montatori (Editor).
     */
    private List<String> montatore;

    /**
     * Lista di nomi dei tecnici del suono (Sound).
     */
    private List<String> tecnicoSuono;

    /**
     * Lista di nomi dei compositori (Composer).
     */
    private List<String> compositore;

    /**
     * Lista di nomi dei produttori esecutivi (Executive producer).
     */
    private List<String> produttoreEsecutivo;

    /**
     * Lista di nomi degli stuntman (Stunts).
     */
    private List<String> stuntman;

    /**
     * Lista di nomi dei truccatori (Makeup).
     */
    private List<String> truccatore;

    /**
     * Lista di nomi degli assistenti alla regia (Assistant director).
     */
    private List<String> assistenteRegista;

    /**
     * Lista di nomi dei direttori artistici (Art direction).
     */
    private List<String> direttoreArtistico;

    /**
     * Lista di nomi dei scenografi (Production design).
     */
    private List<String> scenografo;

    /**
     * Lista di nomi dei costumisti (Costume design).
     */
    private List<String> costumista;

    /**
     * Lista di nomi degli operatori di macchina (Camera operator).
     */
    private List<String> operatoreCamera;

    /**
     * Lista di nomi dei decoratori di set (Set decoration).
     */
    private List<String> decoratoreSet;

    /**
     * Lista di nomi dei casting director (Casting).
     */
    private List<String> casting;

    /**
     * Lista di nomi degli scrittori originali (Original writer).
     */
    private List<String> scrittoreOriginale;

    /**
     * Lista di nomi degli specialisti degli effetti visivi (Visual effects).
     */
    private List<String> effettiVisivi;

    /**
     * Lista di nomi dei tecnici di illuminazione (Lighting).
     */
    private List<String> tecnicoIlluminazione;

    /**
     * Lista di nomi dei parrucchieri (Hairstyling).
     */
    private List<String> parrucchiere;

    /**
     * Lista di nomi dei fotografi aggiuntivi (Additional photography).
     */
    private List<String> fotografiaAggiuntiva;

    /**
     * Lista di nomi degli specialisti degli effetti speciali (Special effects).
     */
    private List<String> effettiSpeciali;

    /**
     * Lista di nomi degli autori delle canzoni (Songs).
     */
    private List<String> canzoni;

    /**
     * Lista di nomi degli autori della storia (Story).
     */
    private List<String> storia;

    /**
     * Lista di nomi dei registi aggiuntivi (Additional directing).
     */
    private List<String> regiaAggiuntiva;

    /**
     * Lista di nomi dei coreografi (Choreography).
     */
    private List<String> coreografia;
    /**
     * Lista di nomi dei titoli (Title).
     */
    private List<String> titoloDesign;
    /**
     * Lista di nomi dei codirettori (Codirectors).
     */
    private List<String> coDirettore;
}
