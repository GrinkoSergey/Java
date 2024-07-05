package aufgabe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Einfacher Server, der auf Verbindungen von Clients auf Port 5675 wartet.
 * Wenn ein Client eine Verbindung herstellt, liest der Server die Nachricht des Clients,
 * gibt sie auf der Konsole aus und sendet eine Antwort zurück an den Client.
 */
public class SimpleServer {
    public static void main(String[] args) {
        Socket clientSocket = null; // Socket für die Client-Verbindung
        ServerSocket serverSocket = null; // Server-Socket zum Horchen auf eingehende Verbindungen
        PrintWriter out = null; // PrintWriter zum Senden von Daten an den Client
        BufferedReader in = null; // BufferedReader zum Lesen von Daten vom Client

        try {
            serverSocket = new ServerSocket(5675); // Server-Socket auf Port 5675 erstellen
            System.out.println("Server gestartet. Warte auf Client...");

            clientSocket = serverSocket.accept(); // Warten und Akzeptieren einer eingehenden Client-Verbindung
            System.out.println("Client verbunden.");

            // Initialisieren von PrintWriter und BufferedReader für die Kommunikation mit dem Client
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Nachricht vom Client lesen
            String message = in.readLine();
            System.out.println("Vom Client erhalten: " + message);

            // Antwort an den Client senden
            out.println("Hallo, Client! Deine Nachricht wurde empfangen.");

        } catch (IOException e) {
            System.out.println("Fehler: " + e.getMessage());
        } finally {
            // Aufräumen: Schließen von Streams und Sockets
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.out.println("Fehler beim Schließen der Ressourcen: " + e.getMessage());
            }
        }
    }
}
