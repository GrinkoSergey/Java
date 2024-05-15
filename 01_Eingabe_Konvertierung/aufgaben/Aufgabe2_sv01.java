package aufgaben;

import java.util.Scanner;

public class Aufgabe2_sv01 {
    /*
    Schreiben Sie bitte ein Programm, in dem  ...
    - in einer Schleife pro Durchlauf so lange 2 Double-Zahlen vom User abgefragt werden, bis deren Differenz (auf 2 Nachkommastellen gerundet) 0 beträgt
    - pro Durchlauf wird jeweils die aktuelle Differenz ausgegeben

    HINWEIS:
    Je nach Reihenfolge der Differenzbildung (bzw. Eingabe der Zahlen) kann die Differenz positiv, oder negativ sein ...
    ... sorgen Sie bitte bei der Ausgabe dafür, dass die Differenz stets als ein Wert größer gleich 0 ausgegeben wird.
    Zum Runden oder zum Bilden des positiven Betrags eines Wertes gibt es passende Methoden in der Math-Klasse
*/
    static void differenz() {
        Scanner scan = new Scanner(System.in);
        double a = 0.0;
        double b = 0.0;
        double dif = 1;

        while (dif != 0) {
            System.out.print("Geben Sie die 1. Kommazahl für eine Differenz ein: ");
//            a = scan.nextDouble();
            a = Double.parseDouble(scan.nextLine());
            System.out.println();

            System.out.print("Geben Sie die 2. Kommazahl für eine Differenz ein: ");
//            b = scan.nextDouble();
            b = Double.parseDouble(scan.nextLine());
            System.out.println();

            dif = (double) (Math.round((a - b) * 100)) / 100;
            System.out.println("Die Differenz: " + Math.abs(dif));
            System.out.println();
        }

    }

    public static void main(String[] args) {
        differenz();
    }
}
