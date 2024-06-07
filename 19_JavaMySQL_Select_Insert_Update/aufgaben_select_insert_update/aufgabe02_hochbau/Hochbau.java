package aufgaben_select_insert_update.aufgabe02_hochbau;

import aufgaben_select_insert_update.aufgabe02_hochbau.models.Abteilung;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.Baustelle;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.Mitarbeiter;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.MitarbeiterAufBaustelle;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.services.AbteilungService;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.services.BaustelleService;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.services.MitarbeiterAufBaustelleService;
import aufgaben_select_insert_update.aufgabe02_hochbau.models.services.MitarbeiterService;

public class Hochbau {
    public static void main(String[] args) {
        AbteilungService.selectAbteilung();
        BaustelleService.selectBaustelle();
        MitarbeiterService.selectMitarbeiter();
        MitarbeiterAufBaustelleService.selectMitarbeiterAufBaustelle();

        for (Abteilung a : Abteilung.abteilungMap.values()) {
            System.out.println(a);
        }

        System.out.println();
        for (Baustelle b : Baustelle.baustelleMap.values()) {
            System.out.println(b);
        }

        System.out.println();
        for (Mitarbeiter m : Mitarbeiter.mitarbeiterMap.values()) {
            System.out.println(m);
        }

        System.out.println();
        for (MitarbeiterAufBaustelle mb : MitarbeiterAufBaustelle.einsätze) {
            System.out.println(mb);
        }

        // -------------------------------------------------- Insert, Update
        // Abteilung neueAbteilung = AbteilungService.createAbteilung("Eine neue Abteilung");

        //if (neueAbteilung != null)
        //    neueAbteilung.setAbteilungsname("Diese Abteilung hat nun einen neuen Namen");

        System.out.println();
        for (Abteilung a : Abteilung.abteilungMap.values())
            System.out.println(a);

        AbteilungService.updateAbteilung(Abteilung.abteilungMap.get(17), "abteilungsname", "Eine coole Abteilung");

        System.out.println();
        for (Abteilung a : Abteilung.abteilungMap.values())
            System.out.println(a);



    }
}
