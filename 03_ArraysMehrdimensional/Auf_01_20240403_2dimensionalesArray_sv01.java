package aufgaben;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Auf_01_20240403_2dimensionalesArray_sv01 {
    
    public static void main(String[] args) throws InputMismatchException{
        Scanner scan = new Scanner(System.in);
        String eingabe = null;

        // a) ein 2-dimensionales Array (Dimensionen 2,3) namens "lexikon"
        // b) in [0][x] (für alle x=0;1 oder 2) ein Begriff initialisiert wird
        // c) in [1][x] jeweils die Erläuterung des Begriffes abgespeichert wird
        String[][] lexikon = new String[][]
                {
                        {"Auto", "OOP", "Süßstoff"},

                        {"Motorisiertes Straßen-Fahrzeug mit 4 Rädern", "Abkürzung für 'Objektorientierte Programmierung'", "Kalorienarmer Zuckerersatz"}
                };

        //d) in einer Endlosschleife vom User pro Durchlauf ein Begriff abgefragt wird
        while (true) {
            System.out.print("Geben Sie einer der 3 Begriffe (\"Auto\", \"OOP\", \"Süßstoff\") ein: ");

            try {
                // Abfrage
                eingabe = scan.nextLine();

                // Ausgabe der Erläuterung über for-Schleige mit if-Bedingung
                for (int i = 0; i < lexikon.length; i++){
                    if(eingabe.equalsIgnoreCase(lexikon[0][i])) {
                        System.out.println("Die Erläuterung für " + lexikon[0][i] + ": " + lexikon[1][i]);
                    }
                }

                // Abbruchbedingung
                if (eingabe.equalsIgnoreCase("Auto") || eingabe.equalsIgnoreCase("OOP") || eingabe.equalsIgnoreCase("Süßstoff")) {
                    break;

                // Exception werfen
                } else {
                    throw new InputMismatchException("Falsche Eingabe. Versuchen Sie noch!");
                }
            } catch (InputMismatchException ex) {
                // Fehlermeldung
                System.out.println(ex.getMessage());
            }
        }

    }
}
