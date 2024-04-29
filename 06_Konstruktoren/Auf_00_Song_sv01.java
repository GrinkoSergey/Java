package aufgaben;

import java.util.ArrayList;

public class Auf_00_Song_sv01 {

    // * Erstellen Sie die Klasse "Song" mit den Attributen
    // * string "titel", int "dauerSekunden", string "interpret"
    private String titel;
    private int dauerSekunden;
    private String interpret;

    // optional
    public static ArrayList<Auf_00_Song_sv01> songsListe = new ArrayList<>();


    // * passenden Getter und Setter für die Attribute
    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getDauerSekunden() {
        return dauerSekunden;
    }

    public void setDauerSekunden(int dauerSekunden) {
        this.dauerSekunden = dauerSekunden;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    // * Über einen Konstruktor sollen die Attribute initialisiert werden.
    public Auf_00_Song_sv01(String titel, int dauerSekunden, String interpret) {
        this.titel = titel;
        this.dauerSekunden = dauerSekunden;
        this.interpret = interpret;
        // optional
        songsListe.add(this);
    }

    // optional: falls nichts angegeben wurde
    public Auf_00_Song_sv01() {
        this("Der default Song", 0, "Der default Interpret");
    }

    // * und der Methode "spielen", die auf der Konsole alle Informationen über den Song ausgibt (die Dauer dabei in Minuten und Sekunden, z.B. 03:35).

    public void spielen() {
        int dauerMin = dauerSekunden / 60;
        int dauerSek = dauerSekunden % 60;
        System.out.printf("Der Song: %s dauert %02d:%02d, ist von dem Interpret %s geschrieben.\n\n", titel/*getTitel()*/, dauerMin, dauerSek, titel /*getInterpret()*/);
    }

}
