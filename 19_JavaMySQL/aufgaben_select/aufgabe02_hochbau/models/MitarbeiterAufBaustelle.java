package aufgaben_select.aufgabe02_hochbau.models;


import java.math.BigDecimal;
import java.util.ArrayList;

public class MitarbeiterAufBaustelle {

    public static final ArrayList<MitarbeiterAufBaustelle> einsätze = new ArrayList<>();

    private Mitarbeiter mitarbeiter;
    private Baustelle baustelle;
    private BigDecimal einsatzzeit;

    public MitarbeiterAufBaustelle(Mitarbeiter mitarbeiter, Baustelle baustelle, BigDecimal einsatzzeit)
    {
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
