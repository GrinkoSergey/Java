package aufgaben.auf01_junit_sv01;

import java.util.Scanner;

public class Aufgabe1_sv01 {

    public static int quersumme(int zahl) {
        int summe = 0;
        String s = "" + zahl;

        for (int i = 0; i<s.length(); i++) {
            summe = summe + zahl % 10;
            zahl = zahl / 10;
        }
        return summe;
    }


}
