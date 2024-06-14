package aufgabe01_benutzerverwaltung;

import aufgabe01_benutzerverwaltung.model.Benutzer;

import java.util.Scanner;

/**
 * Die Main-Klasse führt das Hauptprogramm aus.
 */
public class Main {

    // Scanner für die Eingabe von der Konsole initialisieren
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String benutzername;
        String passwort;
        String vorname;
        String nachname;

        // Registrierung neuer Benutzer
        for (int i = 0; i < 2; i++) {
            System.out.print("Geben Sie den Benutzername für den " + (i + 1) + ". Benutzer: ");
            benutzername = scanner.nextLine();

            System.out.print("Geben Sie das Passwort für den " + (i + 1) + ". Benutzer: ");
            passwort = scanner.nextLine();

            System.out.print("Geben Sie den Vornamen für den " + (i + 1) + ". Benutzer: ");
            vorname = scanner.nextLine();

            System.out.print("Geben Sie den Nachname für den " + (i + 1) + ". Benutzer: ");
            nachname = scanner.nextLine();

            // Aufrufen der Methode zur Registrierung eines neuen Benutzers
            Benutzer.register(benutzername, passwort, vorname, nachname);
            System.out.println();
        }


        Benutzer.selectAll(); // Laden aller Benutzerdaten aus der Datenbank
        // Ausgabe der Benutzer-HashMap nach der Registrierung
        Benutzer.benutzerHashMap.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });

        System.out.println();
        // Versuch, sich mit einem Benutzernamen und Passwort anzumelden
        System.out.print("Geben Sie den Benutzername für den Benutzer: ");
        benutzername = scanner.nextLine();

        System.out.print("Geben Sie das Passwort für den Benutzer: ");
        passwort = scanner.nextLine();

        // Aufrufen der Methode zur Benutzeranmeldung
        System.out.println(Benutzer.login(benutzername, passwort));
    }
}
