package aufgaben.auf03_freizeitpark_factorypattern_sv01.factory;

import aufgaben.auf03_freizeitpark_factorypattern_sv01.attraktion.Achterbahn;
import aufgaben.auf03_freizeitpark_factorypattern_sv01.attraktion.Attraktion;
import aufgaben.auf03_freizeitpark_factorypattern_sv01.attraktion.Karussell;

public class AttraktionFactory {
    public static Attraktion erzeugeAttraktion(String s) {
        switch (s.toLowerCase()) {
            case "a":
                return new Achterbahn();
            case "k":
                return new Karussell();
            default:
                System.out.println("Man braucht default hier nicht!");
                return null;
        }
    }
}
