package aufgaben.auf01_20240422_abstrakt_sv01;

// zwei weitere Klassen "Ritter" und "Drache", die beide von "Kreatur" erben
public class Ritter extends Kreatur {
    public Ritter(String rittersName) {
        super(rittersName);
    }

    // Subklassen implementieren die Methode der Basisklasse
    @Override
    public void angreifen() {
        System.out.println("Für den Angriff nutzt " + getName() + " seinen Schwert");
    }

}
