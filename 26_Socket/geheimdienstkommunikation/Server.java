package geheimdienstkommunikation;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Diese Klasse repräsentiert einen Server, der eine Verbindung mit einem Client herstellt,
 * eine Nachricht aus einer Datei liest und sie an den Client sendet.
 * Der Server empfängt dann eine Nachricht vom Client, extrahiert eine Zahl und überprüft sie.
 * Basierend auf der Zahl sendet der Server eine entsprechende Antwort an den Client.
 */
public class Server {
    public static void main(String[] args) {

        // Datei, die den Auftrag enthält
        File docs = new File("docs3");
        File auftrag = new File("docs3/auftrag.txt");

        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket clientSocket = serverSocket.accept();
             PrintWriter printWriterServer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader bufferedReaderServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            // Überprüft, ob der Ordner existiert, und erstellt ihn, falls nicht
            if (!docs.exists())
                docs.mkdir();

            // Überprüft, ob die Datei existiert, und erstellt sie, falls nicht
            if (!auftrag.exists())
                auftrag.createNewFile();

            // Inhalt des Auftrags
            String auftragsInhalt = "Ihr Ziel ist das CIA-Hauptquartier. Dort befindet sich ein Computer mit vertraulichen Daten, der Ihre Unschuld beweisen kann. Beschaffen Sie diesen Computer und bringen Sie ihn zum Treffpunkt. Code-Nummer: 111";

            // Schreibt den Auftrag in die Datei
            BufferedWriter bufferedWriterServer = new BufferedWriter(new FileWriter(auftrag));
            bufferedWriterServer.write(auftragsInhalt);
            bufferedWriterServer.close();

            // Liest den Auftrag aus der Datei
            String nachricht = "";
            BufferedReader bufferedReaderAusDatei = new BufferedReader(new FileReader(auftrag));
            nachricht = bufferedReaderAusDatei.readLine();
            // System.out.println(nachricht);
            bufferedReaderAusDatei.close();

            // Sendet die Nachricht an den Client
            printWriterServer.println(nachricht);

            // Liest die Antwort vom Client
            String nachrichtVomAgent = bufferedReaderServer.readLine();
            //System.out.println(nachrichtVomAgent);
            String[] parts = nachrichtVomAgent.split(":");
            String teilStr = parts[1].trim();
            int codeNummer = Integer.parseInt(teilStr);
            System.out.println("Die Nummer vom Agent: " + codeNummer);

            // Überprüft die empfangene Code-Nummer und sendet eine entsprechende Antwort an den Client
            if (codeNummer == 432) {
                printWriterServer.println("Viel Erfolg!");
            } else {
                printWriterServer.println("Verräter");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
