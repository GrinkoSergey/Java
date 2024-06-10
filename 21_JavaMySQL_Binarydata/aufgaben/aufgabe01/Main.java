package aufgaben.aufgabe01;
/* Erstellen Sie eine Konsolenanwendung zur Verwaltung von Benutzeraccounts.
    In diesem Beispiel werden Benutzer nur mit Benutzername und Profilbild gespeichert.
    Erstellen Sie eine Datenbank mit passender Tabelle für Benutzer.
    Erstellen Sie in Java eine passende Model-Klasse mit Methoden zum Erstellen von Accounts und dem Aktualisieren mit Profilbild.
    Testen Sie Ihr Programm, indem Sie einen Benutzer erstellen und anschließend diesen mit einem Bild aktualisieren.
*/
import java.util.Scanner;

public class Main {

    private static String benutzerName;
    private static String bildPfad;
    private static int benutzerNummer;
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Geben Sie den Namen des Benutzers ein: ");
        benutzerName = scan.nextLine();
        System.out.println("Geben Sie Dateipfad ein: ");
        bildPfad = scan.nextLine();
        BenutzeraccountModel.insertAccountMitBild(benutzerName, bildPfad);

        //BenutzeraccountModel.insertAccountOhneBild("Schmidt");

        /*
        System.out.println("Geben Sie Dateipfad ein: ");
        bildPfad = scan.nextLine();
        System.out.print("Geben Sie Account-ID ein: ");
        benutzerNummer = scan.nextInt(); // Ein vernünftiger Benutzer gibt immer Zahlen ein, wenn es erforderlich ist.
        BenutzeraccountModel.updateBild(bildPfad, benutzerNummer);

         */
    }
}
