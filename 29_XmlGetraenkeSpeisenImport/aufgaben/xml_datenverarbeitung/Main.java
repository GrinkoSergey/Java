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
        GetraenkService getraenkService = new GetraenkService();
        Getraenk getraenk = null;

        SpeiseService speiseService = new SpeiseService();
        Speise speise = null;

        // Import und Ausgabe des Getränks
        getraenk = getraenkService.getraenkeImport();
        getraenkService.getraenkeAusgabe(getraenk);

        // Import und Ausgabe der Speise
        speise = speiseService.speiseImport();
        speiseService.speiseAusgabe(speise);

    }
}
