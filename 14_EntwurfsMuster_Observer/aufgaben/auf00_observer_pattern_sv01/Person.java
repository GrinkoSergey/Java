package aufgaben.auf00_observer_pattern_sv01;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final List<Feuerloescher> flListe = new ArrayList<>();

    public void feuerRufen(Feuerloescher fl) {
        System.out.println("Feier!");
        for (Feuerloescher f : flListe) {
            f.feuerLoeschen();
        }
    }

    public void flHinzufuegen(Feuerloescher fl) {
        flListe.add(fl);
    }

}
