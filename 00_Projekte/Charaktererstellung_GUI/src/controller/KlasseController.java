package controller;

import model.klasse.Klassen;

// 11
public class KlasseController {
    public static String[] getKlassen() {
        String[] namen = new String[Klassen.values().length];
        int count = 0;
        for (Klassen k : Klassen.values()) {
            namen[count] = k.toString();
            count ++;
        }
        return namen;
    }
}
