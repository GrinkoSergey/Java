package aufgaben.auf01_20240422_abstrakt_sv01;

// zwei weitere Klassen "Ritter" und "Drache", die beide von "Kreatur" erben
public class Drache extends Kreatur {

    public String drachenName;

    public Drache(String drachenName) {
        super(drachenName);
        this.drachenName = drachenName;
    }

    // Subklassen implementieren die Methode der Basisklasse
    @Override
    public void angreifen() {
        System.out.println(this.getClass().getSimpleName() + " " + this.drachenName + " spuckt Feuer");
    }

}
