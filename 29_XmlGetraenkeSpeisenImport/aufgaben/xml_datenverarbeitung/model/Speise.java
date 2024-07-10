package aufgaben.xml_datenverarbeitung.model;

import java.util.List;

/**
 * Klasse, die eine Speise als spezielle Verkaufseinheit repräsentiert.
 */
public class Speise extends Verkaufsware {
    // Liste der Zutaten der Speise
    private List<String> zutaten;

    /**
     * Standardkonstruktor.
     */
    public Speise() {}

    /**
     * Konstruktor mit Parametern.
     *
     * @param bezeichnung Bezeichnung der Speise
     * @param preis       Preis der Speise
     * @param zutaten     Liste der Zutaten der Speise
     */
    public Speise(String bezeichnung, double preis, List<String> zutaten) {
        super(bezeichnung, preis);
        this.zutaten = zutaten;
    }

    /**
     * Gibt die Liste der Zutaten der Speise zurück.
     *
     * @return Liste der Zutaten der Speise
     */
    public List<String> getZutaten() {
        return zutaten;
    }

    /**
     * Setzt die Liste der Zutaten der Speise.
     *
     * @param zutaten Liste der Zutaten der Speise
     */
    public void setZutaten(List<String> zutaten) {
        this.zutaten = zutaten;
    }

    /**
     * Überschreibt die toString-Methode für die Ausgabe einer Speise.
     *
     * @return String-Repräsentation der Speise
     */
    @Override
    public String toString() {
        return "Speise{" +
                "zutaten=" + zutaten +
                ", Bezeichnung='" + this.getBezeichnung() + '\'' +
                ", preis=" + this.getPreis() +
                '}';
    }
}
