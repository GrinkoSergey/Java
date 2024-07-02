package aufgaben.slp_02_00_b;

import java.io.*;
/**
 * Diese Klasse demonstriert die Erstellung und Verwaltung von Dateien in einem Verzeichnis.
 * Es werden mehrere Dateien erstellt und mit Inhalten gefüllt.
 * Anschließend werden die Inhalte dieser Dateien gelesen und ausgegeben.
 */
public class DateiErstellungUndVerwaltung {
    public static void main(String[] args) {
        // Erstellung eines neuen Verzeichnisses
        File ordner = new File("SLP_02_00_b");
        ordner.mkdir();

        // Erstellung neuer Dateien im Verzeichnis
        File datei1 = new File("SLP_02_00_b" + File.separator + "datei1");
        File datei2 = new File("SLP_02_00_b" + File.separator + "datei2");
        File datei3 = new File("SLP_02_00_b" + File.separator + "datei3");
        File datei4 = new File("SLP_02_00_b" + File.separator + "datei4");
        File datei5 = new File("SLP_02_00_b" + File.separator + "datei5");

        try {

            datei1.createNewFile();
            datei2.createNewFile();
            datei3.createNewFile();
            datei4.createNewFile();
            datei5.createNewFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Array mit Wörtern, die in die Dateien geschrieben werden sollen
        String[] woerte = {
            "Wort1",
            "Wort2",
            "Wort3",
            "Wort4",
            "Wort5",
            "Wort6",
            "Wort7"
        };

        // Schreiben von "Hallo Welt!" in die Datei "datei1" mit FileWriter
        try (FileWriter schreiben = new FileWriter(datei1, false)) {
            schreiben.write("Hallo Welt!" + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Lesen und Ausgabe des Inhalts der Datei "datei1" mit FileReader
        char[] zeichen = new char[100]; // Char-Array zum Speichern der gelesenen Zeichen
        try (FileReader lesen = new FileReader(datei1)) {
            int anzahl = lesen.read(zeichen); // Zeichen aus der Datei "datei1" lesen und in das Array "zeichen" speichern; die Anzahl der gelesenen Zeichen wird in der Variable 'anzahl' gespeichert
            for (int i = 0; i < anzahl; i++) {
                System.out.println(zeichen[i]);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        // Schreiben in die erste Datei mit Try-with-Resources
        try (FileWriter schreiben = new FileWriter(datei1, false);
            BufferedWriter bufferedSchreiben = new BufferedWriter(schreiben)) {

            for (String zeile : woerte) {
                bufferedSchreiben.write(zeile);
                bufferedSchreiben.newLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Schreiben in die restlichen Dateien mit Try-Catch-Block
        try {
            // Schreiben in datei2
            FileWriter schreiben = new FileWriter(datei2, false);
            BufferedWriter bufferedSchreiben = new BufferedWriter(schreiben);

            for (String zeile : woerte) {
                bufferedSchreiben.write(zeile);
                bufferedSchreiben.newLine();
            }
            bufferedSchreiben.close();

            // Schreiben in datei3
            schreiben = new FileWriter(datei3, false);
            bufferedSchreiben = new BufferedWriter(schreiben);

            for (String zeile : woerte) {
                bufferedSchreiben.write(zeile);
                bufferedSchreiben.newLine();
            }
            bufferedSchreiben.close();

            // Schreiben in datei4
            schreiben = new FileWriter(datei4, false);
            bufferedSchreiben = new BufferedWriter(schreiben);

            for (String zeile : woerte) {
                bufferedSchreiben.write(zeile);
                bufferedSchreiben.newLine();
            }
            bufferedSchreiben.close();

            // Schreiben in datei5 mit Append-Mode
            schreiben = new FileWriter(datei5, true);
            bufferedSchreiben = new BufferedWriter(schreiben);

            for (String zeile : woerte) {
                bufferedSchreiben.write(zeile);
                bufferedSchreiben.newLine();
            }
            bufferedSchreiben.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Lesen und Ausgeben des Inhalts von datei1 mit Try-with-Resources
        try (FileReader lesen = new FileReader(datei1);
            BufferedReader bufferedLesen = new BufferedReader(lesen)) {

            // Variable zum Speichern jeder gelesenen Zeile
            String zeile;
            System.out.println(datei1.getName());
            while ((zeile = bufferedLesen.readLine()) != null) {
                System.out.println(zeile);
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // Lesen und Ausgeben des Inhalts der restlichen Dateien mit Try-Catch-Block
        try {
            // Lesen von datei2
            FileReader lesen = new FileReader(datei2);
            BufferedReader bufferedLesen = new BufferedReader(lesen);

            // Variable zum Speichern jeder gelesenen Zeile
            String zeile = null;
            System.out.println(datei2.getName()); // Ausgabe des Dateinamens
            // Schleife, um jede Zeile der Datei zu lesen
            do {
                zeile = bufferedLesen.readLine(); // Lesen einer Zeile
                if (zeile != null) // Überprüfen, ob die Zeile nicht null ist
                    System.out.println(zeile);
            } while (zeile != null); // Fortfahren, bis keine Zeilen mehr vorhanden sind
            System.out.println();

            // Lesen von datei3
            lesen = new FileReader(datei3);
            bufferedLesen = new BufferedReader(lesen);
            System.out.println(datei3.getName());
            zeile = ""; // Initialisieren der Variablen mit leerem String
            while (zeile != null) { // Schleife zum Lesen der Datei
                zeile = bufferedLesen.readLine(); // Lesen einer Zeile
                if (zeile != null) // Überprüfen, ob die Zeile nicht null ist
                    System.out.println(zeile);
            }
            System.out.println();

            // Lesen von datei4
            lesen = new FileReader(datei4);
            bufferedLesen = new BufferedReader(lesen);
            System.out.println(datei4.getName());
            while ((zeile = bufferedLesen.readLine()) != null) {
                System.out.println(zeile);
            }
            System.out.println();

            // Lesen von datei5
            lesen = new FileReader(datei5);
            bufferedLesen = new BufferedReader(lesen);
            System.out.println(datei5.getName());
            while ((zeile = bufferedLesen.readLine()) != null) {
                System.out.println(zeile);
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
