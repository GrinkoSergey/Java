package aufgaben;

class Song_sv01 {
    private String titel;
    private int dauerSekunden;
    private String interpret;

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

    //  * und der Methode "spielen", die auf der Konsole alle Informationen über den Song ausgibt (die Dauer dabei in Minuten und Sekunden, z.B. 03:35).
    public void spielen() {
        int minuten = dauerSekunden / 60;
        int sekunden = dauerSekunden % 60;
        String dauer = "" + minuten + ":" + sekunden;
        System.out.println("Der Titel: " + titel + ", die Dauer (umberechnet): " + dauer + ", der Interpreter: " + interpret);
    }

}


public class Auf_00_20240405_Klassen_sv01 {
    public static void main(String[] args) {
        // * Erstellen Sie in der Main einen Song und rufen Sie die Methode auf.

        Song_sv01 song1 = new Song_sv01();
        song1.setTitel("Titel1");
        song1.setDauerSekunden(200);
        song1.setInterpret("Interpret1");

        song1.spielen();

        // * Erstellen Sie außerdem ein UML Klassendiagramm für die Klasse "Song".
        //
    }
}
