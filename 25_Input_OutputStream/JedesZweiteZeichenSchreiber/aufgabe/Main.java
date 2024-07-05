package aufgabe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse demonstriert das Schreiben eines Teils eines Texts in eine Datei.
 * Es werden nur jedes zweite Zeichen aus dem Text genommen und als Bytes in die Datei geschrieben.
 */
public class Main {
    public static void main(String[] args) {
        // Vordefinierter Text
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        // Datei, in die der Text geschrieben wird
        File textDatei = new File("docs" + File.separator + "textdatei.txt");

        // Liste für die Bytes des Texts
        List<Byte> textByte = new ArrayList<>();

        // Jedes zweite Zeichen des Texts wird als Byte in die Liste geschrieben
        for (int i = 1; i < text.length(); i = i + 2) {
            textByte.add((byte) text.charAt(i));
            //System.out.println(textByte.get(i));
        }

        // Array für die Bytes aus der Liste
        byte[] bytes = new byte[textByte.size()];

        // Übertragung der Bytes aus der Liste in das Array
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = textByte.get(i);
        }

        try {
            // OutputStream für die Datei
            OutputStream os = new FileOutputStream(textDatei);

            // Schreiben der Bytes in die Datei
            os.write(bytes);
            os.close(); // Schließen des OutputStream nach dem Schreiben

        } catch (IOException e) {
            System.out.println(e.getMessage()); // Ausgabe der Fehlermeldung, falls eine IOException auftritt
        }
    }
}
