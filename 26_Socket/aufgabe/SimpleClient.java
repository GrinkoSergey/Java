package aufgabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Einfacher Client, der eine Verbindung zum Server auf localhost:5675 herstellt.
 * Der Client sendet eine Nachricht an den Server und gibt die Antwort des Servers auf der Konsole aus.
 */
public class SimpleClient {

    /**
     * Hauptmethode zum Ausführen des Clients.
     * @param args Kommandozeilenargumente (nicht verwendet).
     */
    public static void main(String[] args) {
        Socket socket = null; // Socket für die Server-Verbindung
        PrintWriter out = null; // PrintWriter zum Senden von Daten an den Server
        BufferedReader in = null; // BufferedReader zum Lesen von Daten vom Server

        try {
            socket = new Socket("localhost", 5675); // Verbindung zum Server auf localhost:5675 herstellen
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Nachricht an den Server senden
            out.println("Hallo, Server! Hier ist der Client.");

            // Antwort des Servers lesen und auf der Konsole ausgeben
            String antwort = in.readLine();
            System.out.println("Vom Server erhalten: " + antwort);

        } catch (IOException e) {
            System.out.println("Fehler: " + e.getMessage());
        } finally {
            // Aufräumen: Schließen von Streams und Socket
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                System.out.println("Fehler beim Schließen der Ressourcen: " + e.getMessage());
            }
        }
    }
}
