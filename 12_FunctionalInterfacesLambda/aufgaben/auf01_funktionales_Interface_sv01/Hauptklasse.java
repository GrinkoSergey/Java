package aufgaben.auf01_funktionales_Interface_sv01;

import java.util.Arrays;
import java.util.function.Consumer;

public class Hauptklasse {
    public static void main(String[] args) {

        // Testen Sie die Methoden und das Interface im Main, indem Sie dort ein String Array anlegen, dem Interface die Methoden zuweisen (als Array z.B.) und aufrufen

        String[] daten = new String[] {"Data1", "Data2", "Data3"};

        /* optional: ein Objekt vom Typ des Interfaces mit 1-Methodenreferenz, 2-Lambda-Ausdruck

        Ausgabe ausgabe1 = Hauptklasse::bildschirm;
        ausgabe1.ausgeben(daten);

        Ausgabe ausgabe2 = daten1 -> System.out.println(daten1); // wird Speicheradresse ausgegeben
        ausgabe2.ausgeben(daten);
         */

        // Aufgabe 01-1 'eigenes funktionales Interface'
        // Testen Sie die Methoden und das Interface im Main, indem Sie dort ein String Array anlegen, dem Interface die Methoden zuweisen (als Array z.B.) und aufrufen.
        Ausgabe[] ausgabe = new Ausgabe[] {
                Hauptklasse::bildschirm,
                Hauptklasse::datei,
                Hauptklasse::datenbank,
                d -> System.out.println("Lambda Ausgabe" + Arrays.toString(d)) };

        for (Ausgabe a : ausgabe) {
            a.ausgeben(daten);
        }

        // Aufgabe 01-2 'Consumer'
        // anstelle des eigenen Interfaces "Ausgabe" wird das in Java bereits vorhandene Interface "Consumer" verwendet
        System.out.println("\n\tConsumer\n");
        Consumer<String[]> consumer = Hauptklasse::bildschirm;
        consumer = consumer.andThen(Hauptklasse::datei);
        consumer = consumer.andThen(Hauptklasse::datenbank);
        consumer = consumer.andThen(d -> System.out.println("Lambda Ausgabe" + Arrays.toString(d)));

        consumer.accept(daten);

    } // main-Methode Ende

    // drei void Methoden bildschirm, datei und datenbank mit String[]-Parameter passend zum Interface
    // Die drei Methoden sollen jeden String im Array testweise auf der Konsole ausgeben
    static void bildschirm(String[] d){
        System.out.println("Methode 'bildschirm'");
        for(String s : d) {
            System.out.println("Zeige " + s + " auf dem Bildschirm");
        }
        System.out.println();
    }
    static void datei(String[] d){
        System.out.println("Methode 'datei'");
        for(String s : d) {
            System.out.println("Schreibe " + s + " in die Datei");
        }
        System.out.println();
    }
    static void datenbank(String[] d){
        System.out.println("Methode 'datenbank'");
        for(String s : d) {
            System.out.println("Schreibe " + s + " in die Datenbank");
        }
        System.out.println();
    }
}
