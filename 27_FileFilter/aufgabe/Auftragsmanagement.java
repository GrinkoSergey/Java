package aufgabe;

import java.io.*;

/**
 * Die Klasse Auftragsmanagement bietet Funktionen zur Verwaltung von Aufträgen.
 * Es ermöglicht das Erstellen neuer Aufträge und das Laden bestehender Aufträge aus Textdateien.
 */
public class Auftragsmanagement {
    private static BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

    public static void main(String[] args) {
        String eingabe = "";

        // Verzeichnis für Auftragsmanagementdateien erstellen, falls es nicht existiert
        File auftragsmanagement = new File("auftragsmanagement");
        if (!auftragsmanagement.exists()) {
            auftragsmanagement.mkdir();
        }

        System.out.print("Neuer Eintrag (N) | Eintrag Laden (L) | Beenden (B)\nEingabe: ");

        try {
            eingabe = br.readLine();
        } catch (java.io.IOException e) {
            System.out.println("Fehler bei der Eingabe");
        }

        // Menüauswahl verarbeiten
        switch (eingabe.toLowerCase()) {
            case "n":
                System.out.println("Neuer Eintrag");
                neuerEintrag(auftragsmanagement);
                break;
            case "l":
                System.out.println("Eintrag laden");
                eintragLaden(auftragsmanagement);
                break;
            case "b":
                System.out.println("Beenden");
                System.exit(0);
                break;
            default:
                System.out.println("Falsche Eingabe");
                break;
        }
    }

    /**
     * Erstellt einen neuen Auftragseintrag und speichert ihn in einer Datei.
     *
     * @param auftragsmanagement das Verzeichnis, in dem die Auftragsdateien gespeichert werden
     */
    public static void neuerEintrag(File auftragsmanagement) {
        String eingabeMethode = "";
        BufferedWriter bw;
        File[] files = auftragsmanagement.listFiles();
        File datei = null;
        int zähler = 1;

        // Überprüfen, ob das Verzeichnis leer ist
        if (files.length == 0) {
            // Erstellen einer neuen Datei für den ersten Auftrag
            datei = new File(auftragsmanagement.getName() + File.separator + "auftragsmanagement" + zähler + ".txt");
        } else {
            // Bestimmen der Nummer für die neue Datei basierend auf der letzten vorhandenen Datei
            int dateiNummer = files.length - 1;
            // Extrahiert den numerischen Teil aus dem Dateinamen und erhöht den Zähler um 1
            zähler = Integer.parseInt(
                    // Holt den Dateinamen des Files an der Position dateiNummer aus dem Array files
                    files[dateiNummer].getName().substring(
                            18, // Beginnt bei Index 18 des Dateinamens, um den numerischen Teil zu extrahieren
                            files[dateiNummer].getName().length() - 4 // Endet 4 Zeichen vor dem Ende des Namens, um ".txt" zu entfernen
                    )
            ) + 1; // Konvertiert die extrahierte Zeichenkette in eine Ganzzahl und erhöht diese um 1
            datei = new File(auftragsmanagement.getName() + File.separator + "auftragsmanagement" + zähler + ".txt");
        }

        // Schreiben der Auftragsinformationen in die Datei
        try {
            bw = new BufferedWriter(new FileWriter(datei, false));
            System.out.print("Geben Sie Auftragsnummer ein: ");
            eingabeMethode = br.readLine();
            bw.write("Auftragsnummer: " + eingabeMethode);
            bw.close();

            bw = new BufferedWriter(new FileWriter(datei, true));
            System.out.print("Geben Sie Bezeichnung ein: ");
            eingabeMethode = br.readLine();
            bw.write("\nBezeichnung: " + eingabeMethode);
            bw.close();

            bw = new BufferedWriter(new FileWriter(datei, true));
            System.out.print("Geben Sie Datum ein: ");
            eingabeMethode = br.readLine();
            bw.write("\nDatum: " + eingabeMethode);
            bw.close();

            bw = new BufferedWriter(new FileWriter(datei, true));
            System.out.print("Geben Sie Preis ein: ");
            eingabeMethode = br.readLine();
            bw.write("\nPreis: " + eingabeMethode);
            bw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Listet alle vorhandenen Auftragsdateien im Verzeichnis auf.
     *
     * @param auftragsmanagement das Verzeichnis, in dem die Auftragsdateien gespeichert werden
     */
    public static void eintragLaden(File auftragsmanagement) {
        FileFilter auftragsfilter;

        // Filter für Auftragsdateien
        auftragsfilter = new Auftragsfilter();
        File[] files = auftragsmanagement.listFiles(auftragsfilter);

        // Anzeigen der Namen aller gefilterten Dateien
        for (File f : files) {
            System.out.println(f.getName());
        }
    }
}
