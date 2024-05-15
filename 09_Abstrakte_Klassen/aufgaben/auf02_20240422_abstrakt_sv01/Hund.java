package aufgaben.auf02_20240422_abstrakt_sv01;
// die Klassen Auto, Hund und Mensch, die von GeräuscheMacher erben
public class Hund extends GerauuscheMacher {

    // Konsolenausgabe von macheGeräusch in Hund:   "Wau Wau Kläff Grrrrr ..."
    @Override
    public void macheGerauusch() {
        System.out.println("Wau Wau Kläff Grrrrr ...");
    }

}
