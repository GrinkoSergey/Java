package aufgaben_select_insert_update.aufgabe02_hochbau.models;

import java.util.HashMap;

public class Baustelle {
    public static final HashMap<String, Baustelle> baustelleMap = new HashMap<>();

    private final String baustellennummer;
    private String Bezeichnung;

    public Baustelle(String baustellennummer, String bezeichnung) {
        this.baustellennummer = baustellennummer;
        Bezeichnung = bezeichnung;

        baustelleMap.put(baustellennummer, this);
    }

    public String getBaustellennummer() {
        return baustellennummer;
    }

    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }

    @Override
    public String toString() {
        return "Baustelle{" +
                "baustellennummer=" + baustellennummer +
                ", Bezeichnung='" + Bezeichnung + '\'' +
                '}';
    }
}
