package main.postgresserver.springboot.mainController;

import java.util.List;

/**
 * Classe generica per rappresentare una lista di risultati paginati.
 * Contiene i dati della pagina corrente e un flag che indica se ci sono altri risultati.
 *
 * @param <T> Tipo di elemento contenuto nella lista dei risultati.
 */
public class resultsList<T> {

    private List<T> data;
    private boolean next;

    /**
     * Costruttore per inizializzare la lista dei risultati e il flag di continuazione.
     *
     * @param data La lista dei risultati della ricerca.
     * @param next Il flag che indica se ci sono più risultati.
     */
    public resultsList(List<T> data, boolean next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Restituisce i dati contenuti nella lista dei risultati.
     *
     * @return La lista dei risultati.
     */
    public List<T> getData() {
        return data;
    }

    /**
     * Imposta la lista dei risultati.
     *
     * @param data La nuova lista dei risultati.
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * Restituisce il flag che indica se ci sono altri risultati disponibili.
     *
     * @return true se ci sono altri risultati, false altrimenti.
     */
    public boolean isNext() {
        return next;
    }

    /**
     * Imposta il flag che indica se ci sono altri risultati.
     *
     * @param next Il nuovo valore del flag.
     */
    public void setNext(boolean next) {
        this.next = next;
    }

    /**
     * Restituisce la dimensione della lista dei risultati.
     *
     * @return La dimensione della lista dei risultati.
     */
    public int getSize() {
        return data.size();
    }
}
