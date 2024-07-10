package aufgaben.xml_datenverarbeitung;

import aufgaben.xml_datenverarbeitung.model.Getraenk;
import aufgaben.xml_datenverarbeitung.model.Speise;
import aufgaben.xml_datenverarbeitung.service.GetraenkService;
import aufgaben.xml_datenverarbeitung.service.SpeiseService;
/**
 * Hauptklasse zum Testen des Imports und der Ausgabe von Getränken und Speisen.
 */
public class Main {
    public static void main(String[] args) {
        // Erzeugt eine Instanz von GetraenkService, um den Import und die Verarbeitung von Getränken zu ermöglichen.
        GetraenkService getraenkService = new GetraenkService();
        // Deklariert eine Variable, um später ein Getraenk-Objekt zu speichern.
        Getraenk getraenk = null;

        // Erzeugt eine Instanz von SpeiseService, um den Import und die Verarbeitung von Speisen zu ermöglichen.
        SpeiseService speiseService = new SpeiseService();
        // Deklariert eine Variable, um später ein Speise-Objekt zu speichern.
        Speise speise = null;

        // Import und Ausgabe des Getränks
        getraenk = getraenkService.getraenkeImport();
        getraenkService.getraenkeAusgabe(getraenk);

        // Import und Ausgabe der Speise
        speise = speiseService.speiseImport();
        speiseService.speiseAusgabe(speise);

    }
}
