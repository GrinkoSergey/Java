package aufgaben_select_insert_update.aufgabe03_ticketautomat;
/*Bereiten Sie die Datenbank vor:
•	Erstellen Sie eine MySQL-Datenbank namens ticketautomat.
•	Erstellen Sie eine Tabelle ticket in der Datenbank mit den folgenden Spalten:
o	ticketID (INT, AUTO_INCREMENT, PRIMARY KEY)
o	zufNummer (INT)
Passen Sie die Datenbank-Verbindung an:
•	Stellen Sie sicher, dass die Verbindungseinstellungen in der Klasse MySQL korrekt sind (URL, Benutzername, Passwort).
Erstellen Sie Tickets:
•	Implementieren Sie die Methode createTicket in der Klasse TicketService, um ein neues Ticket mit einer zufällig generierten Nummer zu erstellen und in die Datenbank einzufügen.
Überprüfen Sie den Ticket-Login:
•	Implementieren Sie die Methode login in der Klasse TicketService, um die Ticket-ID und die zugehörige zufällige Nummer zu überprüfen.
Testen Sie das System:
•	Schreiben Sie ein kleines Testprogramm in der Main-Klasse, um die Funktionen zu testen. Erstellen Sie ein neues Ticket und versuchen Sie, sich mit diesem Ticket anzumelden.

*/

import aufgaben_select_insert_update.aufgabe03_ticketautomat.model.Service.TicketService;

import java.util.Scanner;

/**
 * Die Main-Klasse dient als Einstiegspunkt für das Programm.
 * Sie erstellt ein Ticket und überprüft den Login.
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int ticketID;
    private static int meineNummer;

    public static void main(String[] args) {
        // Erstellen eines neuen Tickets und Ausgabe der Ticketinformationen
        System.out.println(TicketService.createTicket());

        System.out.print("Geben Sie TicketID ein: ");
        ticketID = scanner.nextInt();
        System.out.print("Geben Sie die generierte Nummer ein: ");
        meineNummer = scanner.nextInt();
        // Überprüfen des Logins mit einem Beispiel-TicketID und Zufallsnummer
        System.out.println(TicketService.login(ticketID,meineNummer));
    }
}
