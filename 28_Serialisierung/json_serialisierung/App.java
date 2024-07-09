package json_serialisierung;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Diese Klasse zeigt die Verwendung von Jackson zur Serialisierung und Deserialisierung eines Auto-Objekts.
 */
public class App {
    static File filename = new File("resources/loesung.json");

    public static void main(String[] args) {
        serialisieren();
        deserialisieren();
    }
    /**
     * Methode zur Serialisierung eines Auto-Objekts in JSON und Speicherung in einer Datei.
     */
    private static void serialisieren() {
        ObjectMapper mapper = new ObjectMapper();
        Auto auto = new Auto("Ferrari", "rot", 2024);
        try {
            // Objekt in JSON-Datei schreiben
            mapper.writeValue(filename, auto);
            String jsonInString = mapper.writeValueAsString(auto);
            System.out.println("Die Serialisierung ist abgeschlossen!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Methode zur Deserialisierung eines Auto-Objekts aus einer JSON-Datei.
     */
    private static void deserialisieren() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // JSON-Datei in Objekt umwandeln
            Auto auto = mapper.readValue(filename, Auto.class);
            System.out.println(auto.getBaujahr());
            System.out.println(auto.getFarbe());
            System.out.println(auto.getMarke());
            System.out.println("Die Deserialisierung ist abgeschlossen!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

/**
 * Die Klasse Auto repräsentiert ein Auto mit Marke, Farbe und Baujahr.
 */
class Auto {
    private String marke; // Marke des Autos
    private String farbe; // Farbe des Autos
    private int baujahr; // Baujahr des Autos

    /**
     * Standardkonstruktor für die Klasse Auto.
     */
    public Auto() {}

    /**
     * Konstruktor für die Klasse Auto mit Parametern für Marke, Farbe und Baujahr.
     * @param marke Die Marke des Autos.
     * @param farbe Die Farbe des Autos.
     * @param baujahr Das Baujahr des Autos.
     */
    public Auto(String marke, String farbe, int baujahr) {
        this.marke = marke;
        this.farbe = farbe;
        this.baujahr = baujahr;
    }

    /**
     * Getter für die Marke des Autos.
     * @return Die Marke des Autos.
     */
    public String getMarke() {
        return marke;
    }

    /**
     * Setter für die Marke des Autos.
     * @param marke Die Marke des Autos.
     */
    public void setMarke(String marke) {
        this.marke = marke;
    }

    /**
     * Getter für die Farbe des Autos.
     * @return Die Farbe des Autos.
     */
    public String getFarbe() {
        return farbe;
    }

    /**
     * Setter für die Farbe des Autos.
     * @param farbe Die Farbe des Autos.
     */
    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    /**
     * Getter für das Baujahr des Autos.
     * @return Das Baujahr des Autos.
     */
    public int getBaujahr() {
        return baujahr;
    }

    /**
     * Setter für das Baujahr des Autos.
     * @param baujahr Das Baujahr des Autos.
     */
    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }
}