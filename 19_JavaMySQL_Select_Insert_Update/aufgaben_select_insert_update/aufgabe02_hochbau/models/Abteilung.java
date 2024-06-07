package aufgaben_select_insert_update.aufgabe02_hochbau.models;

import aufgaben_select_insert_update.aufgabe02_hochbau.models.services.AbteilungService;

import java.util.HashMap;

public class Abteilung {
    public static final HashMap<Integer, Abteilung> abteilungMap = new HashMap<>();

    private final int abteilungsnummer;
    private String abteilungsname;

    public Abteilung(int abteilungsnummer, String abteilungsname) {
        this.abteilungsnummer = abteilungsnummer;
        this.abteilungsname = abteilungsname;

        abteilungMap.put(abteilungsnummer, this);
    }


    public int getAbteilungsnummer() {
        return abteilungsnummer;
    }

    public String getAbteilungsname() {
        return abteilungsname;
    }

    public void setAbteilungsname(String abteilungsname) {
        this.abteilungsname = abteilungsname;
        AbteilungService.updateAbteilung(this, "abteilungsname", abteilungsname);
    }

    @Override
    public String toString() {
        return "Abteilung{" +
                "abteilungsnummer=" + abteilungsnummer +
                ", abteilungsname='" + abteilungsname + '\'' +
                '}';
    }
}
