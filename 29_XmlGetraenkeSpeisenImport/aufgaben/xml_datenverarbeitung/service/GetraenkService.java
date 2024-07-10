package aufgaben.xml_datenverarbeitung.service;

import aufgaben.xml_datenverarbeitung.model.Getraenk;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * Service-Klasse zum Importieren und Verarbeiten von Getränken aus XML.
 */
public class GetraenkService {
    // Datei, die die Getränkeinformationen enthält
    File getraenkeXml = new File("OP4_Datenverarbeitung mit Dateien und Streams in Java/Tag08/src/aufgaben/slp_03_01/getraenke.xml");

    /**
     * Importiert ein Getränk aus der XML-Datei.
     *
     * @return Importiertes Getränk
     */
    public Getraenk getraenkeImport() {
        Getraenk getraenk = null;
        XmlMapper xmlMapper = new XmlMapper();
        try {
            getraenk = xmlMapper.readValue(getraenkeXml, Getraenk.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return getraenk;
    }

    /**
     * Gibt das importierte Getränk aus.
     *
     * @param getraenk Getränk, das ausgegeben werden soll
     */
    public void getraenkeAusgabe(Getraenk getraenk) {
        System.out.println(getraenk);
    }
}
