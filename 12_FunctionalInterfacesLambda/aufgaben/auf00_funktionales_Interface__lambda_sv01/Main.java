package aufgaben.auf00_funktionales_Interface__lambda_sv01;

public class Main {
    public static void main(String[] args) {

        // Version 1
        // einen Sportler, rufen Sie "führeAktionAus" auf und übergeben Sie einmal "schwimmen" und einmal "laufen" mit Hilfe der Methodenreferenzsyntax
        Spotler spotler1 = new Spotler();
        spotler1.fuehreAktionAus(Main::schwimmen);
        spotler1.fuehreAktionAus(Main::laufen);



        // Version 2 mit Lambda-Ausdrücken
        System.out.println();
        Spotler spotler2 = new Spotler();
        spotler2.fuehreAktionAus(() -> System.out.println("Ich schwimme"));
        spotler2.fuehreAktionAus(() -> System.out.println("Ich laufe"));

    } // main-Methode Ende
    // eine statische void Methode "schwimmen" ohne Parameter. Die Methode gibt auf der Konsole "Ich schwimme." aus
    public static void schwimmen() {
        System.out.println("Ich schwimme");
    }
    // eine statische void Methode "laufen" ohne Parameter. Die Methode gibt auf der Konsole "Ich laufe." aus
    public static void laufen() {
        System.out.println("Ich laufe");
    }
}
