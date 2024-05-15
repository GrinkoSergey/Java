package aufgaben.auf01_20240422_abstrakt_sv01;
/* Erstellen Sie die abstrakte Klasse "Kreatur" mit einem privaten Attribut "name", einer abstrakten Methode "angreifen" und einem Konstruktor, der name initialisiert.
 * Erstellen Sie zwei weitere Klassen "Ritter" und "Drache", die beide von "Kreatur" erben.
 * Die beiden Subklassen implementieren die Methode der Basisklasse.
 * Der Ritter nutzt sein Schwert, der Drache spuckt Feuer.
 * In main() erzeugen Sie je ein Objekt von Ritter und Drache.
 * Rufen Sie in der main-Methode() für beide Objekte die überschriebene angreifen()-Methode auf.
 */
public class Hauptklasse {
    public static void main(String[] args) {
        Ritter ritter = new Ritter("Ritter1");
        Drache drache = new Drache("Drache1");

        ritter.angreifen();
        drache.angreifen();

        System.out.println(ritter.getName());
        System.out.println(drache.getName());
        System.out.println(drache.drachenName);
    }
}
