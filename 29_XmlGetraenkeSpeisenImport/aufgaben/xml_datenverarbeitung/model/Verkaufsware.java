package aufgaben.xml_datenverarbeitung.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstrakte Klasse, die eine Verkaufseinheit repräsentiert.
 */
public abstract class Verkaufsware {
    // Liste aller Verkaufseinheiten
    static final List<Verkaufsware> verkaufswaren = new ArrayList<>();

    // Bezeichnung der Verkaufseinheit
    @JsonProperty("bezeichnung")
    private String bezeichnung;

    // Preis der Verkaufseinheit
    @JsonProperty("preis")
    private double preis;

    /**
     * Standardkonstruktor.
     */
    protected Verkaufsware() {}

    /**
     * Konstruktor mit Parametern.
     *
     * @param bezeichnung Bezeichnung der Verkaufseinheit
     * @param preis       Preis der Verkaufseinheit
     */
    protected Verkaufsware(String bezeichnung, double preis) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        verkaufswaren.add(this);
    }

    /**
     * Gibt die Bezeichnung der Verkaufseinheit zurück.
     *
     * @return Bezeichnung der Verkaufseinheit
     */
    public String getBezeichnung() {
        return bezeichnung;
    }

    /**
     * Setzt die Bezeichnung der Verkaufseinheit.
     *
     * @param bezeichnung Bezeichnung der Verkaufseinheit
     */
    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    /**
     * Gibt den Preis der Verkaufseinheit zurück.
     *
     * @return Preis der Verkaufseinheit
     */
    public double getPreis() {
        return preis;
    }

    /**
     * Setzt den Preis der Verkaufseinheit.
     *
     * @param preis Preis der Verkaufseinheit
     */
    public void setPreis(double preis) {
        this.preis = preis;
    }
}
