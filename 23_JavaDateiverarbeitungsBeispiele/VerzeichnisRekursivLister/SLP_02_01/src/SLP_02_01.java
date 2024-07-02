import java.io.File;
import java.util.Scanner;

/**
 * Diese Klasse liest einen Benutzerpfad ein und gibt rekursiv alle Verzeichnisse und Unterverzeichnisse aus.
 */
public class SLP_02_01 {
    /**
     * Hauptmethode der Anwendung, die den Benutzer zur Eingabe eines Pfads auffordert
     * und dann die rekursive Methode aufruft, um die Verzeichnisse auszugeben.
     * @param args Die Befehlszeilenargumente (nicht verwendet in dieser Anwendung).
     */
    public static void main(String[] args) {

        String eingabe = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie einen Pfad und Sie bekommen alle Verzeichnisse und Unterverzeichnisse aufgelistet: ");
        eingabe = scanner.nextLine();
        scanner.close();

        File directory = new File(eingabe);

        // Überprüfen, ob der eingegebene Pfad ein Verzeichnis ist
        if (!directory.isDirectory()) {
            System.out.println("Die falsche Pfadeingabe!");
            System.exit(1);
        }

        File[] filesListe = directory.listFiles();
        System.out.println("Anzeige der Verzeichnisse von: " + directory.getName());
        rekursiv(filesListe); // Aufruf der rekursiven Methode


    }

    /**
     * Rekursive Methode zur Ausgabe aller Verzeichnisse und Unterverzeichnisse.
     * @param fileList Ein Array von Dateien, die durchsucht werden sollen.
     */
    public static void rekursiv(File[] fileList) {
        File[] filesListe = fileList;
        // Überprüfen, ob das Array nicht null ist (es könnten keine Dateien oder Verzeichnisse vorhanden sein)
        if (filesListe != null) {
            // Durchlaufen aller Dateien und Verzeichnisse im aktuellen Verzeichnis
            for (File f : filesListe) {
                // Überprüfen, ob das aktuelle File ein Verzeichnis ist
                if (f.isDirectory()) {
                    // Ausgabe des Verzeichnisnamens
                    System.out.println(f.getName());
                    // Erstellen eines neuen Arrays mit den Dateien und Verzeichnissen im aktuellen Verzeichnis
                    File[] filesListe2 = f.listFiles();
                    // Überprüfen, ob das Array nicht null ist (Abbruchkriterium: Das Verzeichnis ist leer oder es gibt keine Berechtigung zum Lesen)
                    if (filesListe2 != null) {
                        // Rekursiver Aufruf für Unterverzeichnisse
                        rekursiv(filesListe2);
                    }
                }
            }
        }
    }
}
