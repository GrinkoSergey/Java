package aufgaben.auf03_20240422_abstrakt_sv01;

import java.util.ArrayList;
import java.util.List;

// von der Basisklasse darf kein Objekt erstellt werden
public abstract class Verkaufsware {
    // Alle Waren werden in der Basisklasse in einer Liste gespeichert
    public static final List<Verkaufsware> verkaufswaren = new ArrayList<>();

    // Für alle Waren erfassen Sie die Bezeichnung und den Preis
    protected String bezeichnung;
    protected double preis;
    protected Verkaufsware(String bezeichnung, double preis) {
        this.bezeichnung = bezeichnung;
        this.preis = preis;
        verkaufswaren.add(this);
    }

    public abstract String toString();
}
