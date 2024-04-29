package aufgaben.auf03_20240422_abstrakt_sv01;

import java.util.ArrayList;

public class Hauptklasse {
    public static void main(String[] args) {

        // erstellen Sie ein Getränk, eine Speise
        Speisen speise = new Speisen("Speise1", 12.12323, new ArrayList<>());
        Getraenke getraenk = new Getraenke("Getränk1", 04.345435, 500);

        speise.zutaten.add("Zutat1");
        speise.zutaten.add("Zutat2");
        speise.zutaten.add("Zutat3");

        // direkte Ausgabe
        speise.toString();
        getraenk.toString();

        // Ausgabe über die Elemente der Liste
        System.out.println();
        for (Verkaufsware vw : Verkaufsware.verkaufswaren) {
            vw.toString();
        }

    }
}
