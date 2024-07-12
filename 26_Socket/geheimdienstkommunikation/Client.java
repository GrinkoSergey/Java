package geheimdienstkommunikation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Diese Klasse repräsentiert einen Client, der eine Verbindung zu einem Server herstellt,
 * eine Nachricht vom Server empfängt und eine Bestätigung mit der extrahierten und verschlüsselten Code-Nummer sendet.
 * Der Client empfängt dann eine Antwort vom Server und druckt sie aus.
 */
public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 8080);
        PrintWriter printWriterClient = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReaderClient = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Empfängt die Nachricht vom Server
            String nachricht = bufferedReaderClient.readLine();
            System.out.println(nachricht);
            //printWriterClient.println("Die Nachricht ist angekommen!");

            // Teilt die Nachricht in Teile auf, um die Code-Nummer zu extrahieren
            String[] parts = nachricht.split(":");
            String teilStr = parts[1].trim();
            int codeNummer = Integer.parseInt(teilStr);

            // Verschlüsselt die Ziffern der Code-Nummer
            int[] ziffernVerschluesselt = getZiffernVerschluesselt(codeNummer);
            int codeNummerVerschluesselt = zahlZusammenstellen(ziffernVerschluesselt);
            System.out.println(codeNummerVerschluesselt);

            //

            // Sendet die Bestätigung mit der extrahierten Code-Nummer an den Server
            printWriterClient.println("Die Bestätigung! Die Code-Nummer ist: " + codeNummerVerschluesselt);
            // int falscheNummer = 222;
            // printWriterClient.println("Die Bestätigung! Die Code-Nummer ist: " + falscheNummer);

            // Empfängt die Antwort vom Server
            nachricht = bufferedReaderClient.readLine();
            System.out.println(nachricht);

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Diese Methode zerlegt eine Zahl in ihre Ziffern und verschlüsselt jede Ziffer
     * nach einer bestimmten Regel.
     *
     * @param nummer Die Zahl, die in Ziffern zerlegt und verschlüsselt werden soll.
     * @return Ein Array von verschlüsselten Ziffern.
     */
    public static int[] getZiffernVerschluesselt(int nummer) {
        String nummerStr = Integer.toString(nummer);
        int[] ziffern = new int[nummerStr.length()];

        for (int i = 0; i < nummerStr.length(); i++) {
            if (i == 0) {
                ziffern[i] = Character.getNumericValue(nummerStr.charAt(i)) + 3;
            } else if (i == 1) {
                ziffern[i] = Character.getNumericValue(nummerStr.charAt(i)) + 2;
            } else if (i == 2) {
                ziffern[i] = Character.getNumericValue(nummerStr.charAt(i)) + 1;
            } else {
                ziffern[i] = Character.getNumericValue(nummerStr.charAt(i));
            }
        }

        return ziffern;
    }


    /**
     * Diese Methode baut eine Zahl aus einem Array von Ziffern zusammen.
     *
     * @param ziffern Ein Array von Ziffern, die zu einer Zahl zusammengebaut werden sollen.
     * @return Die zusammengebaute Zahl.
     */
    public static int zahlZusammenstellen(int[] ziffern) {
        StringBuilder nummerStr = new StringBuilder();

        for (int ziffer : ziffern) {
            nummerStr.append(ziffer);
        }

        return Integer.parseInt(nummerStr.toString());
    }
}
