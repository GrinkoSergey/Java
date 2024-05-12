package aufgaben.auf03_freizeitpark_factorypattern_sv01;

import aufgaben.auf03_freizeitpark_factorypattern_sv01.attraktion.Attraktion;
import aufgaben.auf03_freizeitpark_factorypattern_sv01.factory.AttraktionFactory;

import java.util.Scanner;

/* Aufgabe: Erstellen Sie eine Factory für die Erweiterung eines Freizeitparks durch Attraktionen.
 * Neue Attraktionen hinzufügen
 * Erweiterung durch eine Factory
 * Testen Sie Ihre Implementierung
 */

public class Main {
    public static void main(String[] args) {
        Attraktion attraktion = null;
        String s = null;
        boolean isOk = true;

        Scanner scan = new Scanner(System.in);
        while(isOk) {
            System.out.print("Geben Sie an, was für eine Attraktion Sie erstellen möchten:\nA <- Achterbahn\nK <- Karussel\nEingabe: ");
            s = scan.nextLine();

            if (!s.equalsIgnoreCase("a") && !s.equalsIgnoreCase("k")) {
                System.out.println("So eine Attraktion haben wir zur Auswahl nicht. Versuchen Sie noch einmal");
            } else {
                isOk = false;
            }
        }

        attraktion = AttraktionFactory.erzeugeAttraktion(s);
        attraktion.ausgabe();

    }
}
