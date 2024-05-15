package aufgaben;

class Fussballfeld {

    //- Member:
    //  3 private Attribute:
    //    breite (Integer)
    //    länge (Integer)
    //    dfbTauglich (Boolean)

    private int breite;
    private int laenge;
    private boolean dfbTauglich;

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getLaenge(){
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public boolean isDhbTauglich(){
        return dfbTauglich;
    }

    public void setDhbTauglich(boolean dhbTauglich) {
        this.dfbTauglich = dhbTauglich;
    }

    //  1 Konstruktor:
    //    Name: Fußballfeld
    //    Übergabewerte: Länge und Breite des Fußballfeldes
    //    Funktion: - initialisiert die Felder "breite" und "länge" mit den Übergabewerten
    //              - setzt dfbTauglich auf True, falls 45<=breite<=55 UND 90<=länge<=110, sonst dfbTauglich=False
    //    Rückgabewert: Keiner
    public Fussballfeld(int breite, int laenge) {
        this.breite = breite;
        this.laenge = laenge;
        if((breite >= 45 && breite <= 55) && (laenge >= 90 && laenge <= 110)) {
            dfbTauglich = true;
        } else {
            dfbTauglich = false;
        }
    }

    //   1 public Methode:
    //    Name: zeigeAlle
    //    Übergabewerte: Keine
    //    Funktion: Gibt die Werte der drei Felder auf der Konsole aus
    //    Rückgabewert: Keiner

    public void zeigeAlle() {
        String s = null;
        if(isDhbTauglich()) {
            s = "das Fussballfeld ist DFB-tauglich";
        }else {
            s = "das Fussballfeld ist nicht DFB-tauglich";
        }
        System.out.printf("\n\tBreite des Fussballfeldes: %d, Länge des Fussballfeldes: %d, %s\n",getBreite(),getLaenge(),s);
    }

    /*
    public void zeigeAlle() {
        System.out.printf("\n\tBreite des Fussballfeldes: %d, Länge des Fussballfeldes: %d, DFB-tauglich: %b\n",getBreite(),getLaenge(),isDhbTauglich());
    }
     */

}

public class Auf_01_20240408_sv01 {
    public static void main(String[] args) {
        Fussballfeld f1 = new Fussballfeld(200, 100);
        Fussballfeld f2 = new Fussballfeld(300, 200);
        Fussballfeld f3 = new Fussballfeld(50, 100);

        f1.zeigeAlle();
        f2.zeigeAlle();
        f3.zeigeAlle();
    }
}
