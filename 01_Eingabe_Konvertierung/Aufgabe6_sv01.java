package aufgaben;

import java.util.Scanner;

public class Aufgabe6_sv01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] zahlen = new int[5];
        int zahlGerade = 0, zahlUngerade = 0, pruefZiffer = 0;
        int i = 0;
        // Eingabe
        while(i<zahlen.length) {
            System.out.printf("Geben Sie die %d. Zahl ein: ", i+1);
            try {
                zahlen[i] = Integer.parseInt(scan.nextLine());
                i++;
            } catch (NumberFormatException ex) {
                System.out.println("Nur Zahlen eingeben!");
                scan.nextLine();
            }
        }

        // 5-stellige Zahl
        StringBuilder zahlString = new StringBuilder();
//        String zahlString = ""; // <-- mit String
        for(int x:zahlen) {
            zahlString.append(x);
            //zahlString = zahlString + x;  // <-- mit String
        }
        // System.out.println(zahlString);

        for (i = 0; i < zahlen.length; i++) {
            if (zahlen[i] % 2 == 0){
                zahlGerade += zahlen[i];
            } else {
                zahlUngerade = zahlUngerade + zahlen[i] * 3;
            }
        }
//        System.out.println("zahlUngerade: " + zahlUngerade);
//        System.out.println("zahlGerade: " + zahlGerade);
        pruefZiffer = (zahlGerade + zahlUngerade) % 10;
        zahlString.append('-').append(pruefZiffer);
        System.out.println("Artikelnummer: " + String.valueOf(zahlString));
    }
}
