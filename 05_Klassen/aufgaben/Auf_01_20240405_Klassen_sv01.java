package aufgaben;

import java.util.ArrayList;

class Firma_sv01 {
    private String name;
    private ArrayList<Double> konten = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getKonten() {
        return konten;
    }
    public void setKonten(ArrayList<Double> konten) {
        this.konten = konten;
    }

    //     - Methode: getSumme
    //       + Funktion: berechnet den Gesamtbetrag aller Listenelemente
    //       + Rückgabewert: Gesamtbetrag

    public double getSumme() {
        double gesamtBetrag = 0;
        for (int i = 0; i < konten.size(); i++) {
            gesamtBetrag += konten.get(i);
        }
        return gesamtBetrag;
    }
}


public class Auf_01_20240405_Klassen_sv01 {
    public static void main(String[] args) {
        //- In der Main erstellen Sie zwei Firmen und geben die Werte testweise aus.

        Firma_sv01 firma1 = new Firma_sv01();
        Firma_sv01 firma2 = new Firma_sv01();
        ArrayList<Double> eintrag1 = new ArrayList<>();
        ArrayList<Double> eintrag2 = new ArrayList<>();

        firma1.setName("Firma1");
        firma2.setName("Firma2");

        // Befüllung
        for (double i = 0, j = 0; i < 3; i = i + 0.5, j = j + 0.45) {
            // für public ArrayList
            //firma1.konten.add((Double) i);
            //firma2.konten.add((Double) j);

            eintrag1.add(i);
            eintrag2.add(j);

        }
        //System.out.println(firma1.konten);

        firma1.setKonten(eintrag1);
        firma2.setKonten(eintrag2);

        System.out.println(firma1.getName() + " und Summe: " + firma1.getSumme());
        System.out.println(firma2.getName() + " und Summe: " + firma2.getSumme());
    }
}
