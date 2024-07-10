package aufgaben.xml_datenverarbeitung.service;

import aufgaben.xml_datenverarbeitung.model.Speise;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

/**
 * Service-Klasse zum Importieren und Verarbeiten von Speisen aus XML.
 */
public class SpeiseService {
    /**
     * Importiert eine Speise aus der XML-Datei.
     *
     * @return Importierte Speise
     */
    public Speise speiseImport() {
        Speise speise = null;
        XmlMapper xmlMapper = new XmlMapper();
        try {
            speise = xmlMapper.readValue(new File("OP4_Datenverarbeitung mit Dateien und Streams in Java/Tag08/src/aufgaben/slp_03_01/speisen.xml"), Speise.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return speise;
    }

    /**
     * Gibt die importierte Speise aus.
     *
     * @param speise Speise, die ausgegeben werden soll
     */
    public void speiseAusgabe(Speise speise) {
        System.out.println(speise);
    }
}
