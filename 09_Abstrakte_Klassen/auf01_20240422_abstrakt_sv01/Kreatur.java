package aufgaben.auf01_20240422_abstrakt_sv01;

// abstrakte Klasse "Kreatur"
public abstract class Kreatur {
    //mit einem privaten Attribut "name"
    private String name;

    // mit einem Konstruktor, der name initialisiert
    protected Kreatur(String name) {
        this.name = name;
        System.out.println("Ich bin Konstruktor der Superklasse");
    }

    public String getName() {
        return name;
    }

    // mit einer abstrakten Methode "angreifen"
    protected abstract void angreifen();

}
