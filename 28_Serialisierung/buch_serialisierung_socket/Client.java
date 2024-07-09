package buch_serialisierung_socket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse implementiert einen Client, der mit einem Server kommuniziert, um Bücherobjekte auszutauschen.
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null; // Socket für die Verbindung zum Server
        PrintWriter pwClient = null; // OutputStream für den Client
        BufferedReader brClient = null; // InputStream für den Client
        ObjectMapper om = null; // ObjectMapper für die Serialisierung von Büchern in JSON
        Buch buch1 = null; // Erstes Buchobjekt
        Buch buch2 = null; // Zweites Buchobjekt
        Buch buch3 = null; // Drittes Buchobjekt
        String message = ""; // Nachricht vom Server
        String objekt1 = ""; // JSON-Repräsentation des ersten Buchs
        String objekt2 = ""; // JSON-Repräsentation des zweiten Buchs
        String objekt3 = ""; // JSON-Repräsentation des dritten Buchs
        List<String> objekteListe = new ArrayList<>(); // Liste zum Speichern der JSON-Repräsentationen der Bücher
        List<Buch> buecherListe = new ArrayList<>(); // Liste zum Speichern der empfangenen Buchobjekte

        try {
            // Verbindung zum Server aufbauen
            socket = new Socket("localhost", 8080);
            pwClient = new PrintWriter(socket.getOutputStream(), true);
            brClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Nachricht an den Server senden
            pwClient.println("Hallo, Server! Ich bin Client!");

            // while (!socket.isClosed()) {
            //System.out.print("Um zu beenden, geben Sie das Wort 'exit' ein: ");
            // eingabe = bwClient.readLine();

            // Bücherobjekte erstellen und in JSON konvertieren
            om = new ObjectMapper();
            buch1 = new Buch("Krieg und Frieden", "Leo Tolstoi", 1869);
            buch2 = new Buch("Harry Potter und der Stein der Weisen", "J.K. Rowling", 1997);
            buch3 = new Buch("Im Osten nichts Neues", "Erich Maria Remarque", 1929);
            objekt1 = om.writeValueAsString(buch1);
            objekt2 = om.writeValueAsString(buch2);
            objekt3 = om.writeValueAsString(buch3);

            // JSON-Objekte zur Liste hinzufügen
            objekteListe.add(objekt1);
            objekteListe.add(objekt2);
            objekteListe.add(objekt3);
            objekteListe.add("exit");


            // JSON-Objekte an den Server senden
            for (String s : objekteListe) {
                pwClient.println(s);
            }

            // Nachrichten vom Server lesen und verarbeiten
            while (true) {
                try {
                    message = brClient.readLine();

                    // Wenn die Nachricht null oder "exit" ist, die Schleife beenden
                    if (message == null || message.equalsIgnoreCase("exit")) {
                        break;
                    }

                    // JSON-Nachricht in ein Buchobjekt konvertieren und zur Liste hinzufügen
                    Buch buch = om.readValue(message, Buch.class);
                    buecherListe.add(buch);
                    System.out.println("Buch empfangen: " + buch.getTitel());
                } catch (JsonProcessingException e) {
                    System.out.println("Nachricht vom Server: " + message);
                }
            }

            // Socket und Streams schließen
            socket.close();
            pwClient.close();
            brClient.close();
        } catch (IOException e) {
            // Fehler beim Verbindungsaufbau oder während der Kommunikation mit dem Server
            System.out.println("Fehler beim Kommunizieren mit dem Server: " + e.getMessage());
        }

    }

}

/**
 * Die Klasse Buch repräsentiert ein Buch mit Titel, Autor und Erscheinungsjahr.
 */
class Buch {
    private String titel; // Titel des Buchs
    private String schriftsteller; // Autor des Buchs
    private int jahr; // Erscheinungsjahr des Buchs

    /**
     * Standardkonstruktor für die Klasse Buch.
     */
    public Buch(){}

    /**
     * Konstruktor für die Klasse Buch mit Parametern für Titel, Autor und Erscheinungsjahr.
     * @param titel Der Titel des Buchs.
     * @param schriftsteller Der Autor des Buchs.
     * @param jahr Das Erscheinungsjahr des Buchs.
     */
    public Buch(String titel, String schriftsteller, int jahr) {
        this.titel = titel;
        this.schriftsteller = schriftsteller;
        this.jahr = jahr;
    }

    /**
     * Getter für den Titel des Buchs.
     * @return Der Titel des Buchs.
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Setter für den Titel des Buchs.
     * @param titel Der Titel des Buchs.
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Getter für den Autor des Buchs.
     * @return Der Autor des Buchs.
     */
    public String getSchriftsteller() {
        return schriftsteller;
    }

    /**
     * Setter für den Autor des Buchs.
     * @param schriftsteller Der Autor des Buchs.
     */
    public void setSchriftsteller(String schriftsteller) {
        this.schriftsteller = schriftsteller;
    }

    /**
     * Getter für das Erscheinungsjahr des Buchs.
     * @return Das Erscheinungsjahr des Buchs.
     */
    public int getJahr() {
        return jahr;
    }

    /**
     * Setter für das Erscheinungsjahr des Buchs.
     * @param jahr Das Erscheinungsjahr des Buchs.
     */
    public void setJahr(int jahr) {
        this.jahr = jahr;
    }

    /**
     * Überschriebene toString-Methode, die eine textuelle Repräsentation des Buchs zurückgibt.
     * @return Textuelle Repräsentation des Buchs.
     */
    @Override
    public String toString() {
        return "Buch{" +
                "titel='" + titel + '\'' +
                ", schriftsteller='" + schriftsteller + '\'' +
                ", jahr=" + jahr +
                '}';
    }
}