package aufgaben.xml_datenverarbeitung.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Klasse, die ein Getränk als spezielle Verkaufseinheit repräsentiert.
 */
public class Getraenk extends Verkaufsware {
    // Füllmenge des Getränks in Millilitern
    @JsonProperty("fuellmengeML")
    private int fuellmengeML;

    /**
     * Standardkonstruktor.
     */
    public Getraenk() {
        super();
    }

    /**
     * Konstruktor mit Parametern.
     *
     * @param bezeichnung Bezeichnung des Getränks
     * @param preis       Preis des Getränks
     * @param fuellmengeML Füllmenge des Getränks in Millilitern
     */
    public Getraenk(String bezeichnung, double preis, int fuellmengeML) {
        super(bezeichnung, preis);
        this.fuellmengeML = fuellmengeML;
    }

    /**
     * Gibt die Füllmenge des Getränks zurück.
     *
     * @return Füllmenge des Getränks in Millilitern
     */
    public int getFuellmengeML() {
        return fuellmengeML;
    }

    /**
     * Setzt die Füllmenge des Getränks.
     *
     * @param fuellmengeML Füllmenge des Getränks in Millilitern
     */
    public void setFuellmengeML(int fuellmengeML) {
        this.fuellmengeML = fuellmengeML;
    }

    /**
     * Überschreibt die toString-Methode für die Ausgabe eines Getränks.
     *
     * @return String-Repräsentation des Getränks
     */
    @Override
    public String toString() {
        return "Getraenk{" +
                "fuellmenge=" + fuellmengeML +
                ", Bezeichnung='" + this.getBezeichnung() + '\'' +
                ", preis=" + this.getPreis() +
                '}';
    }
}
