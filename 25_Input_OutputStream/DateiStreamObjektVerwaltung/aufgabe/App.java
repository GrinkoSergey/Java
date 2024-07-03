package aufgabe;

import java.io.*;

/**
 * Die Klasse App demonstriert das Schreiben und Lesen von Objekten in eine Datei und aus einer Datei.
 * Sie erstellt Kunden- und Auftragsobjekte, speichert diese in einer Datei und liest sie anschließend wieder ein.
 */
public class App {
    public static void main(String[] args) {
        // Erstellt eine Datei im Verzeichnis 'docs' mit dem Namen 'Auftrag.txt'
        File auftrag = new File("docs" + File.separator + "Auftrag.txt");

        // Erstellt zwei Kundenobjekte mit dem Namen "Hansen"
        Kunde ersterKunde = new Kunde("Hansen");
        Kunde zweiterKunde = new Kunde("Hansen");

        // Deklariert Dummy-Kundenobjekte für spätere Verwendung
        Kunde dummyKunde1;
        Kunde dummyKunde2;

        // Erstellt zwei Auftragsobjekte mit den oben erstellten Kundenobjekten
        Auftrag ersterAuftrag = new Auftrag(ersterKunde, "Laptop");
        Auftrag zweiterAuftrag = new Auftrag(zweiterKunde, "Desktop-PC");

        // Deklariert Dummy-Auftragsobjekte für spätere Verwendung
        Auftrag dummyAuftrag1;
        Auftrag dummyAuftrag2;

        try {
            // Öffnet einen FileOutputStream zum Schreiben in die Datei 'Auftrag.txt'
            FileOutputStream fout = new FileOutputStream(auftrag);
            // Erstellt einen ObjectOutputStream, um Objekte in den FileOutputStream zu schreiben
            ObjectOutputStream out = new ObjectOutputStream(fout);

            // Schreibt die Kunden- und Auftragsobjekte in den ObjectOutputStream
            out.writeObject(ersterKunde);
            out.writeObject(zweiterKunde);
            out.writeObject(ersterAuftrag);
            out.writeObject(zweiterAuftrag);

            // Schließt den ObjectOutputStream
            out.close();

        } catch (IOException e) {
            // Gibt eine Fehlermeldung aus, falls ein Fehler beim Schreiben in die Datei auftritt
            System.out.println(e.getMessage());
        }

        try {
            // Öffnet einen FileInputStream zum Lesen aus der Datei 'Auftrag.txt'
            FileInputStream fin = new FileInputStream(auftrag);
            // Erstellt einen ObjectInputStream, um Objekte aus dem FileInputStream zu lesen
            ObjectInputStream in = new ObjectInputStream(fin);

            // Liest die Kunden- und Auftragsobjekte aus dem ObjectInputStream
            dummyKunde1 = (Kunde) in.readObject();
            dummyKunde2 = (Kunde) in.readObject();
            dummyAuftrag1 = (Auftrag) in.readObject();
            dummyAuftrag2 = (Auftrag) in.readObject();

            // Gibt die Namen der eingelesenen Kundenobjekte auf der Konsole aus
            System.out.println(dummyKunde1.getName());
            System.out.println(dummyKunde2.getName());

            // Gibt die eingelesenen Auftragsobjekte auf der Konsole aus
            System.out.println(dummyAuftrag1.toString());
            System.out.println(dummyAuftrag2.toString());

            // Schließt den ObjectInputStream
            in.close();

        } catch (IOException e) {
            // Gibt eine Fehlermeldung aus, falls ein Fehler beim Lesen aus der Datei auftritt
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            // Gibt eine Fehlermeldung aus, falls die Klasse der gelesenen Objekte nicht gefunden wird
            System.out.println(e.getMessage());
        }
    }
}
