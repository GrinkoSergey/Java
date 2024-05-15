package aufgaben.auf02_20240422_abstrakt_sv01;
// die Klassen Auto, Hund und Mensch, die von GeräuscheMacher erben
public class Mensch extends GerauuscheMacher {
    // Konsolenausgabe von macheGeräusch in Mensch: "Java lernen ist toll!"
    @Override
    public void macheGerauusch() {
        System.out.println("Java lernen ist toll!");
    }
}
