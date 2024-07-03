import java.io.*;

/**
 * Eine Klasse, die die Ein- und Ausgabe von Daten mit Datei-Streams demonstriert.
 */
public class DateiStreamEinAusgabe {

    public static void main(String[] args) {
        File aufgabe_streams = new File("docs/Aufgabe_streams.txt"); // Dateiobjekt für die Aufgabe
        String inhalt = "Java OP 4 Arbeiten mit Streams"; // Inhalt, der in die Datei geschrieben wird
        int abbruch = 1; // Schleifenabbruchbedingung für die Leseschleife

        // Schreiben von Daten in die Datei
        try (FileOutputStream fos = new FileOutputStream(aufgabe_streams)) {
            fos.write(inhalt.getBytes()); // Schreibe den String-Inhalt in die Datei als Bytes
        } catch (IOException e) {
            System.out.println("Es gibt einen Fehler beim Schreiben der Datei: " + e.getMessage());
        }

        // Lesen von Daten aus der Datei
        try (FileInputStream inputStream = new FileInputStream(aufgabe_streams)) {
            while (abbruch != 0) {
                if (abbruch != 0) {
                    System.out.println((char) inputStream.read()); // Lese ein Byte und konvertiere es in einen Charakter
                }
                abbruch = inputStream.available(); // Anzahl der verfügbaren Bytes im Stream
                System.out.println("Verbleibende Bytes, die gelesen werden können: " + abbruch);
            }
        } catch (IOException e) {
            System.out.println("Es gibt einen Fehler beim Lesen der Datei: " + e.getMessage());
        }

    }
}