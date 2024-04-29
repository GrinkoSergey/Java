package aufgaben.auf03_20240422_abstrakt_sv01;

public class Getraenke extends Verkaufsware {
    // zu Getränken speichern Sie die Füllmenge in Milliliter

    public int fuellmenge;

    // Alle benötigten Daten werden über Konstruktoren erfasst
    public Getraenke(String bezeichnung, double preis, int fuellmenge) {
        super(bezeichnung, preis);
        this.fuellmenge = fuellmenge;
    }

    // Waren bequem ausgeben zu können, überschreiben Sie die toString-Methode
    @Override
    public String toString() {
        System.out.printf("Das Getränk %s kostet %.2f Euro und hat die Füllmenge: %d Milliliter\n", bezeichnung, preis, fuellmenge);
        return null;
    }

}
