package buch_serialisierung_socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


/**
 * Diese Klasse einen einfachen Server, der mit einem Client kommuniziert, um Bücherdaten auszutauschen.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null; // ServerSocket für die Serververbindung
        Socket clientSocket = null; // Socket für die Clientverbindung
        PrintWriter pwServer = null; // OutputStream für den Server
        BufferedReader brServer = null; // InputStream für den Server
        ObjectMapper om = null; // ObjectMapper für die Serialisierung von Büchern in JSON
        String nachricht = ""; // Nachricht vom Client
        List<Buch> buecher = new ArrayList<>(); // Liste zur Speicherung empfangener Buchobjekte
        File datei = null; // Datei, in die die Bücherliste gespeichert wird

        try {
            // Server-Socket erstellen und auf Verbindung warten
            serverSocket = new ServerSocket(8080);
            System.out.println("Server gestartet. Warte auf Client...");

            clientSocket = serverSocket.accept();
            System.out.println("Client verbunden.");

            // Streams für die Kommunikation mit dem Client initialisieren
            pwServer = new PrintWriter(clientSocket.getOutputStream(), true);
            brServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Begrüßungsnachricht an den Client senden
            pwServer.println("Hallo Client!");

            // ObjectMapper für die JSON-Verarbeitung initialisieren
            om = new ObjectMapper();

            // Server wartet auf Nachrichten vom Client
            while (true) {
                try {
                    nachricht = brServer.readLine();

                    // Wenn die Nachricht null oder "exit" ist, die Schleife beenden
                    if (nachricht == null || nachricht.equalsIgnoreCase("exit")) {
                        break;
                    }

                    // JSON-Nachricht in ein Buchobjekt konvertieren und zur Liste hinzufügen
                    Buch buch = om.readValue(nachricht, Buch.class);
                    buecher.add(buch);
                    System.out.println("Buch empfangen: " + buch.getTitel());
                } catch (JsonProcessingException e) {
                    System.out.println("Nachricht vom Client: " + nachricht);
                }
            }
            
            // Bestätigung an den Client senden, dass alle Bücher empfangen wurden
            pwServer.println("Alle Bücher sind angekommen!");

            // Bücherliste nach dem Erscheinungsjahr sortieren
            buecher.sort((b1, b2) -> Integer.compare(b1.getJahr(), b2.getJahr()));
            System.out.println("Bücher sind sortiert!");

            // Bücherliste in eine JSON-Datei schreiben
            datei = new File("docs/buecher.json");
            om.writeValue(datei, buecher);

            // Bücher als JSON an den Client senden
            for (int i = 0; i < buecher.size(); i++) {
                pwServer.println(om.writeValueAsString(buecher.get(i)));
            }
            // "exit" an den Client senden, um das Ende der Übertragung anzukündigen
            pwServer.println("exit");

            System.out.println("Bücher sind zurückgesendet!");

            // Verbindungen schließen
            clientSocket.close();
            pwServer.close();
            brServer.close();

        } catch (IOException e) {
            // Fehler beim Aufbau der Verbindung oder während der Kommunikation mit dem Client
            System.out.println("Fehler beim Kommunizieren mit dem Client: " + e.getMessage());
        }
    }
}