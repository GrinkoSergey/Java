package aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.publisher;

import aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.observer.Kunde;

import java.util.ArrayList;
import java.util.List;

public class ZeitschriftenImpl implements ZeitschriftenAbo {

    private final List<Kunde> kundenListe = new ArrayList<>();

    private String zeitschrift = "eine aktuelle Zeitschrift";
    @Override
    public void setZeitschrift(String zeitschrift) {
        this.zeitschrift = zeitschrift;
        benachrichtigen();
    }

    @Override
    public void abonnieren(Kunde k) {
        kundenListe.add(k);
    }

    @Override
    public void kuendigen(Kunde k) {
        kundenListe.remove(k);
    }

    @Override
    public void benachrichtigen() {
        for (Kunde kunde : kundenListe) {
            kunde.update(zeitschrift);
        }
    }
}
