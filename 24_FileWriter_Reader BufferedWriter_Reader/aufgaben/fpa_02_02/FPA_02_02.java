import java.io.*;
/**
 * Diese Klasse demonstriert das Schreiben und Lesen einer Datei in Java.
 */
public class FPA_02_02 {
    public static void main(String[] args) {
        String[] lines = new String[100]; // Array für die gelesenen Zeilen
        File fpa_02_02 = new File("FPA_02_02");
        fpa_02_02.mkdir(); // Erstellt das Verzeichnis 'FPA_02_02', falls es noch nicht existiert

        // Erstellt eine neue Datei 'datei01.txt' im Verzeichnis 'FPA_02_02'
        File datei01 = new File("FPA_02_02" + File.separator + "datei01.txt");
        try {
            datei01.createNewFile(); // Erstellt die Datei 'datei01.txt'
        } catch (IOException e) {
            System.out.println(e.getMessage()); // Gibt eine Fehlermeldung aus, falls ein Fehler beim Erstellen der Datei auftritt
        }

        // Inhalt, der in die Datei geschrieben werden soll
        String[] inhalt = {
            "Wort1",
            "Wort2",
            "Wort3",
            "Wort4",
            "Wort5",
        };

        schreiben(datei01, inhalt); // Schreibt den Inhalt in die Datei 'datei01.txt'
        lines = lesen(datei01); // Liest den Inhalt aus der Datei 'datei01.txt' in das Array 'lines'

        // Gibt die gelesenen Zeilen auf der Konsole aus
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] != null)
                System.out.println(lines[i]);
        }

    }

    /**
     * Diese Methode schreibt einen String-Array in eine Datei.
     * @param datei Die Datei, in die geschrieben werden soll.
     * @param inhalt Der Inhalt, der in die Datei geschrieben werden soll.
     */
    public static void schreiben(File datei, String[] inhalt) {

        try (FileWriter dateiSchreiben = new FileWriter(datei, false);
             BufferedWriter bufferedSchreiben = new BufferedWriter(dateiSchreiben)) {

            // Schreibt jeden String aus dem 'inhalt'-Array in die Datei, jeweils in einer neuen Zeile
            for (int i = 0; i < inhalt.length; i++) {
                bufferedSchreiben.write(inhalt[i] + "\n");
            }

        } catch (IOException e) {
            System.out.println("Hier ist ein Fehler!"); // Gibt eine Fehlermeldung aus, falls ein Fehler beim Schreiben der Datei auftritt
        }
    }

    /**
     * Diese Methode liest den Inhalt einer Datei in einen String-Array.
     * @param datei Die Datei, die gelesen werden soll.
     * @return Ein String-Array mit den gelesenen Zeilen der Datei.
     */
    public static String[] lesen (File datei) {
        String[] zeilen = new String[100]; // Array für die gelesenen Zeilen
        String zeile;
        int i = 0;
        try (FileReader dateiLesen = new FileReader(datei);
            BufferedReader bufferedLesen = new BufferedReader(dateiLesen)) {

            // Liest jede Zeile aus der Datei, bis das Ende der Datei erreicht ist
            while ((zeile = bufferedLesen.readLine()) != null) {
                zeilen[i] = zeile; // Fügt die gelesene Zeile dem Array hinzu
                i++;
            }

        } catch (IOException e) {
            System.out.println("Hier ist ein Fehler!");
        }
        return zeilen;
    }

}
