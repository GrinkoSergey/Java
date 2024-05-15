package aufgaben.auf02_20240422_abstrakt_sv01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // eine Liste vom Typ GeräuscheMacher
        ArrayList<GerauuscheMacher> macherListe = new ArrayList<>();
        
        // von allen drei Subklassen ein Objekt
        macherListe.add(new Auto());
        macherListe.add(new Hund());
        macherListe.add(new Mensch());

        // mittels einer foreach-Schleife, für alle Elemente der Liste, die Methode macheGeräusch
        for (GerauuscheMacher gm : macherListe) {
            gm.macheGerauusch();
        }

        System.out.println();
        // optional
        for (GerauuscheMacher gm : macherListe) {

            if(gm instanceof Auto) {
                ((Auto) gm).macheGerauusch();
            }
            if(gm instanceof Hund) {
                ((Hund) gm).macheGerauusch();
            }
            if(gm instanceof Mensch) {
                ((Mensch) gm).macheGerauusch();
            }
        }

    }
}
