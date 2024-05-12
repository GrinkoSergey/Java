package aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.publisher;

import aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.observer.Kunde;

public interface ZeitschriftenAbo {
    public void setZeitschrift(String zeitschrift);
    public abstract void abonnieren(Kunde k);

    public abstract void kuendigen(Kunde k);

    public abstract void benachrichtigen();
}
