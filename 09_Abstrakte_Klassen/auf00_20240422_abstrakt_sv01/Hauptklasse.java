package aufgaben.auf00_20240422_abstrakt_sv01;
/* Aufgabe 0 (Basics)
 * Erstellen Sie die abstrakte Klasse "Künstler" mit einer abstrakten Methode "kunstErstellen()".
 * Erstellen Sie zwei weitere Klassen "Maler" und "Sänger", die beide von "Künstler" erben.
 * Die beiden Subklassen überschreiben die Methode der Basisklasse.
 * Dabei gibt der Maler auf der Konsole "Ich male ein Bild" und der Sänger "Ich singe einen Song" aus.
 * Im main() erzeugen Sie je ein Objekt von Maler und Sänger.
 * Rufen Sie in der main()-Methode für beide Objekte die Methode kunstErstellen() auf.
 *
 * Zeichnen Sie ein Klassendiagramm.
 */
public class Hauptklasse {
    public static void main(String[] args) {
        // erzeugen Sie je ein Objekt von Maler und Sänger

        Maler maler = new Maler();
        Saenger saenger = new Saenger();

        // Rufen Sie in der main()-Methode für beide Objekte die Methode kunstErstellen() auf
        maler.kunstErstellen();
        saenger.kunstErstellen();

    }
}
