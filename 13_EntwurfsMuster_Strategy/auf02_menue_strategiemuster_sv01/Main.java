package aufgaben.auf02_menue_strategiemuster_sv01;

import aufgaben.auf02_menue_strategiemuster_sv01.kontext.MenueEintrag;
import aufgaben.auf02_menue_strategiemuster_sv01.strategie.DateiOeffnenStrategie;
import aufgaben.auf02_menue_strategiemuster_sv01.strategie.DateiSpeichernStrategie;

/* Aufgabe: Erstellen Sie ein Menüsystem für eine Konsolenanwendung. Verwenden Sie das Strategy Pattern, um das Verhalten der Menüelemente zu definieren.
 * Erstellen Sie die Menüstrategien
 * Erstellen Sie die Menüelemente
 * Testen Sie Ihr Menü
 */

public class Main {
    public static void main(String[] args) {
        MenueEintrag menueEintrag = new MenueEintrag();
        //menueEintrag.setMenueStrategie(new DateiOeffnenStrategie());
        menueEintrag.beimKlicken();

        menueEintrag.setMenueStrategie(new DateiSpeichernStrategie());
        menueEintrag.beimKlicken();

        menueEintrag.setMenueStrategie(new DateiOeffnenStrategie());
        menueEintrag.beimKlicken();
    }
}
