package aufgaben_sv01.auf_00_20240416_vererbung_sv01;


public class Kuenstler {
    private String name;

    protected Kuenstler(String name) { // man kann keine Objekte der Klasse Kuenstler außerhalb des Packages erstellen
        this.name = name;
        System.out.println("Der Konstruktor der Klasse 'Kuenstler'");
        System.out.println("Ein Künstler mit dem Namen " + name);
    }

    public String getName() {
        return name;
    }

    // optional
    public void ausgabe() {
        System.out.println("Ich bin die Klasse 'Kuenstler'");
    }
}
