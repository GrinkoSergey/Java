package aufgabe;

import java.io.File;
import java.io.FileFilter;

/**
 * Diese Klasse implementiert das Interface FileFilter und wird verwendet, um Dateien zu filtern,
 * die einen bestimmten Suchbegriff in ihrem Dateinamen enthalten.
 */
public class Auftragsfilter implements FileFilter {
    // Suchbegriff für Dateinamen, die akzeptiert werden sollen
    private String suchbegrif = ".txt";

    /**
     * Gibt den aktuellen Suchbegriff zurück.
     *
     * @return der aktuelle Suchbegriff
     */
    public String getSuchbegrif() {
        return suchbegrif;
    }

    /**
     * Setzt den Suchbegriff auf einen neuen Wert.
     *
     * @param suchbegrif der neue Suchbegriff
     */
    public void setSuchbegrif(String suchbegrif) {
        this.suchbegrif = suchbegrif;
    }

    /**
     * Überprüft, ob die übergebene Datei vom Filter akzeptiert wird.
     *
     * @param file die zu überprüfende Datei
     * @return true, wenn die Datei den Suchbegriff im Dateinamen enthält; sonst false
     */
    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(suchbegrif);
    }
}
