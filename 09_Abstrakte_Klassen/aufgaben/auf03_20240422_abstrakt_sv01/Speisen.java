package aufgaben.auf03_20240422_abstrakt_sv01;

import java.util.ArrayList;
import java.util.List;

public class Speisen extends Verkaufsware {

    // Speisen bestehen zudem aus einer Auflistung der Zutaten
    List<String> zutaten = new ArrayList<>();


    // Alle benötigten Daten werden über Konstruktoren erfasst
    public Speisen(String bezeichnung, double preis, List<String> zutaten) {
        super(bezeichnung, preis);
        this.zutaten = zutaten;
    }

    // Waren bequem ausgeben zu können, überschreiben Sie die toString-Methode
    @Override
    public String toString() {
        System.out.printf("Die Speise %s kostet %.2f Euro und besteht aus fogenden Zutaten:\n", bezeichnung, preis);
        int i = 1;
        for (String s : zutaten) {
            System.out.println(i + ": " + s);
            i++;
        }
        System.out.println();
        return null;
    }
}
