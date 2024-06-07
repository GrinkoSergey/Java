package aufgaben_select_insert_update.aufgabe02_hochbau.models;


import aufgaben_select_insert_update.aufgabe02_hochbau.models.services.MitarbeiterAufBaustelleService;

import java.math.BigDecimal;
import java.util.ArrayList;

public class MitarbeiterAufBaustelle {

    public static final ArrayList<MitarbeiterAufBaustelle> einsätze = new ArrayList<>();

    public Mitarbeiter mitarbeiter;
    public Baustelle baustelle;
    public BigDecimal einsatzzeit;

    public MitarbeiterAufBaustelle(Mitarbeiter mitarbeiter, Baustelle baustelle, BigDecimal einsatzzeit) {
        this.mitarbeiter = mitarbeiter;
        this.baustelle = baustelle;
        this.einsatzzeit = einsatzzeit;

        einsätze.add(this);
    }

    public BigDecimal getEinsatzzeit() {
        return einsatzzeit;
    }

    public void setEinsatzzeit(BigDecimal einsatzzeit) {
        this.einsatzzeit = einsatzzeit;
        MitarbeiterAufBaustelleService.updateEinsatz(this, "einsatzzeit", einsatzzeit);
    }

    @Override
    public String toString() {
        return "MitarbeiterAufBaustelle{" +
                "mitarbeiter=" + mitarbeiter +
                ", baustelle=" + baustelle +
                ", einsatzzeit=" + einsatzzeit +
                '}';
    }
}
