package aufgaben_select_insert_update.aufgabe02_hochbau.models;

import aufgaben_select_insert_update.aufgabe02_hochbau.models.services.MitarbeiterService;

import java.util.HashMap;

public class Mitarbeiter {
    public static final HashMap<String, Mitarbeiter> mitarbeiterMap = new HashMap<>();

    private final String mitarbeiternummer;
    private boolean maschinenberechtigung;
    private String vorname;
    private String nachname;
    private String plz;
    private final Abteilung abteilung;

    public Mitarbeiter(String mitarbeiternummer, boolean maschinenberechtigung, String vorname, String nachname, String plz, Abteilung abteilung) {
        this.mitarbeiternummer = mitarbeiternummer;
        this.maschinenberechtigung = maschinenberechtigung;
        this.vorname = vorname;
        this.nachname = nachname;
        this.plz = plz;
        this.abteilung = abteilung;

        mitarbeiterMap.put(mitarbeiternummer, this);
    }

    public String getMitarbeiternummer() {
        return mitarbeiternummer;
    }

    public boolean isMaschinenberechtigung() {
        return maschinenberechtigung;
    }

    public void setMaschinenberechtigung(boolean maschinenberechtigung) {
        this.maschinenberechtigung = maschinenberechtigung;
        MitarbeiterService.updateMitarbeiter(this, "maschinenberechtigung", maschinenberechtigung);
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public Abteilung getAbteilung() {
        return abteilung;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "mitarbeiternummer='" + mitarbeiternummer + '\'' +
                ", maschinenberechtigung=" + maschinenberechtigung +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", plz='" + plz + '\'' +
                ", abteilung=" + abteilung +
                '}';
    }
}
