package aufgaben_sv01.auf_00_20240416_vererbung_sv01;
/* Aufgabe 0 (Basics)
 * Erstellen Sie die Klasse "Künstler" mit dem privaten Attribut "name".
 * Erstellen Sie zwei weitere Klassen "Maler" und "Sänger", die beide von "Künstler" erben.
 * Die beiden Subklassen erhalten keine weiteren Attribute.
 * Für jede Klasse implementieren Sie einen Konstruktor. Das Attribut "name" soll im Code nur ein einziges Mal zugewiesen werden.
 * Außerdem soll der Konstruktor bei Künstler '"Ein Künstler mit dem Namen "+ name' ausgeben, der Konstruktor
 * von Maler "Ich bin ein Maler" und der von Sänger "Ich bin ein Sänger".
 * In der main Methode erzeugen Sie mit dem passenden parametrisierten Konstruktor je ein Objekt von Maler und Sänger.
 */
public class Hauptklasse {
    public static void main(String[] args) {
        Kuenstler k = new Kuenstler("Künstler1");
        System.out.println();

        Maler m = new Maler("Maler");
        System.out.println();

        Saenger s = new Saenger("Sänger");

        // optional
        System.out.println();
        if (s instanceof Kuenstler) {
            System.out.println("s ist ein Objekt der Klasse 'Kuenstler'");
        }
        System.out.println();
        System.out.println("Die Klasse mit Metadaten: " + s.getClass());

        System.out.println();
        System.out.println("Nur die Klasse: " + s.getClass().getSimpleName());

        System.out.print("Die Methode 'ausgabe' der Klasse 'Kuenstler': ");
        k.ausgabe();

        // casten, um Zugriff auf die Methoden der Subklasse zu bekommen
        Kuenstler k2 = new Saenger("Sänger2");
        System.out.print("Die überschriebene Methode 'ausgabe' der Klasse 'Saenger': ");
        ((Saenger) k2).ausgabe();
    }
}
