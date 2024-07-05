import java.io.*;

/**
 * Diese Klasse demonstriert das Einlesen von Benutzereingaben,
 * Schreiben des eingegebenen Texts in eine Datei und anschließendes Lesen und Ausgeben der Datei.
 */
public class Main {
    public static void main(String[] args) {
        // Initialisierung der Variablen
        String text = "";
        InputStream inputStream;

        // Erstellen einer Datei im Verzeichnis "docs" mit dem Namen "aufgabe.txt"
        File aufgabe = new File("docs" + File.separator + "aufgabe.txt");

        // Einlesen von Benutzereingaben über BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            // Benutzer wird aufgefordert, einen Text einzugeben
            System.out.println("Text eingeben: ");
            text = br.readLine();

            // Schreiben des eingegebenen Texts in die Datei mit BufferedWriter
            BufferedWriter bw = new BufferedWriter(new FileWriter(aufgabe));
            bw.write(text);
            bw.close(); // Schließen des BufferedWriter nach dem Schreiben
        } catch (IOException e) {
            System.out.println(e.getMessage()); // Ausgabe der Fehlermeldung, falls eine IOException auftritt
        }

        try {
            // Lesen und Ausgeben des Inhalts der Datei mit FileInputStream
            inputStream = new FileInputStream(aufgabe);
            while (inputStream.available() != 0)
                System.out.print((char) inputStream.read()); // Ausgabe jedes gelesenen Zeichens

            inputStream.close(); // Schließen des FileInputStream nach dem Lesen
        } catch (IOException e) {
            System.out.println(e.getMessage()); // Ausgabe der Fehlermeldung, falls eine IOException auftritt
        }
    }
}
