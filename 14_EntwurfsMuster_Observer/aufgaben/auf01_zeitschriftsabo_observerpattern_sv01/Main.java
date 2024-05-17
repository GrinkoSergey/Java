package aufgaben.auf01_zeitschriftsabo_observerpattern_sv01;

import aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.observer.Kunde;
import aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.observer.KundeImpl;
import aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.publisher.ZeitschriftenAbo;
import aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.publisher.ZeitschriftenImpl;

/* Aufgabe: Implementieren Sie das Observer-Pattern. Erstellen Sie ein Modell für einen Zeitschriftenhandel, bei dem Kunden Zeitschriftenabonnements bestellen können. Jedes Mal, wenn eine neue Ausgabe einer Zeitschrift erscheint, wird diese an alle Abonnen-ten des jeweiligen Abonnements geliefert.
 */

public class Main {
    public static void main(String[] args) {
        Kunde kunde1 = new KundeImpl("Hans");
        Kunde kunde2 = new KundeImpl("Anika");

        ZeitschriftenAbo zeitschriftenAbo = new ZeitschriftenImpl();

        zeitschriftenAbo.abonnieren(kunde1);
        zeitschriftenAbo.abonnieren(kunde2);

        zeitschriftenAbo.benachrichtigen();

        System.out.println();
        zeitschriftenAbo.setZeitschrift("eine neue Zeitschrift");

        System.out.println();
        zeitschriftenAbo.kuendigen(kunde1);
        zeitschriftenAbo.benachrichtigen();
    }
}
