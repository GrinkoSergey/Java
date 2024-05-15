package aufgaben;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Auf_03_20240420_Liste_von_Arrays_sv01 {
    public static void main(String[] args) {
        // eine Liste von String-Arrays
        ArrayList<String[]> stringArrayListe = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean isOk1 = true;
        boolean isOk2 = true;
        int zaehler = 1;
        String entscheidung = null;

        // Endlos-Schleife
        while (isOk1) {
            isOk2 = true;

            String[] stringArray = new String[2];

            // Eingabe eines Wortes
            System.out.print("Geben Sie ein " + zaehler + ". deutsches Wort ein: ");
            stringArray[0] = scan.nextLine();

            // Engabe der Übersetzung
            System.out.print("Geben Sie die englische Übersetzung des " + zaehler + ". Wortes ein: ");
            stringArray[1] = scan.nextLine();

            // Array in die Liste abspeichern
            stringArrayListe.add(stringArray);

            // Fortfahren oder beenden
            do {
                System.out.print("Drücken Sie\n1 <- Wenn Sie fortfahren möchten.\n2 <- Wenn Sie beenden möchten.\nAuswahl: ");
                entscheidung = scan.nextLine();
                switch (entscheidung) {
                    case "1":
                        isOk2 = false;
                        break;
                    case "2":
                        isOk1 = false;
                        isOk2 = false;
                        break;
                    default:
                        System.out.println("Falsche Eingabe");
                }
            } while (isOk2);

            zaehler++;
        }

        // Ausgabe for-each
        System.out.println("Ausgabe for-each");
        for (String[] s : stringArrayListe) {
            System.out.println("Das deutsche Wort: \"" + s[0] + "\" und seine englische Übersetzung: \"" + s[1] + "\"");
        }

        // Ausgabe Iterator
        System.out.println("Ausgabe Iterator");
        Iterator<String[]> iterator = stringArrayListe.listIterator();
        while (iterator.hasNext()) {
            String[] element = iterator.next();
            for (String str : element) {
                System.out.println(str);
            }
        }
    }
}
