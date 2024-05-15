package aufgaben.auf02_20240422_abstrakt_sv01;
// die Klassen Auto, Hund und Mensch, die von GeräuscheMacher erben
public class Auto extends GerauuscheMacher {

    // Konsolenausgabe von macheGeräusch in Auto:   "Brummmmmm ..."
    @Override
    public void macheGerauusch() {
        System.out.println("Brummmmmm ...");
    }
}
