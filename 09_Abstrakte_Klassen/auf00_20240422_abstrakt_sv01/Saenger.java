package aufgaben.auf00_20240422_abstrakt_sv01;

// zwei weitere Klassen "Maler" und "Sänger", die beide von "Künstler" erben.
public class Saenger extends Kuenstler {

    public Saenger() {

    }

    // überschreiben die Methode der Basisklasse
    @Override
    public void kunstErstellen() {
        System.out.println("Ich singe einen Song");
    }

}
