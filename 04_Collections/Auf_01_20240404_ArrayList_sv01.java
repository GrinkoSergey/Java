package aufgaben;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Auf_01_20240404_ArrayList_sv01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int eingabe = 1;
        ArrayList<Integer> zahlenListe = new ArrayList<>();

        // 1 - innerhalb einer ersten Schleife pro Durchlauf ganze Zahlen abgefragt werden:
        //   + falls der User inkorrekte Eingaben tätigt (Text, Kommazahlen, zu große Zahlen ...) wird die Eingabe ignoriert
        //   + falls die Eingabe eine positive ganze Zahl ist, wird sie in eine Integer-Liste eingetragen
        //   + falls die Eingabe eine negative Ganzzahl oder 0 ist, endet diese erste Schleife
        while (eingabe > 0) {
            System.out.print("Geben Sie eine ganze Zahl ein: ");

            try {
                eingabe = scan.nextInt();
                if(eingabe > 0) {
                    zahlenListe.add(Integer.valueOf(eingabe));
                }
            } catch (InputMismatchException ex) {
                scan.nextLine();
            }
        }

        // 2- eine foreach-Schleife startet, die alle Elemente aus der Liste ausgibt
        for (Integer a : zahlenListe) {
            System.out.print(" " + a);
        }

        System.out.println();

        // 3  - eine weitere Schleife startet, in der pro Durchlauf eine ganze Zahl abgefragt wird:
        //   + falls der User keine ganze Zahl eingibt, kommt es zum nächsten Schleifendurchlauf (Wiederholen der Abfrage)
        //   + falls der User eine ganze Zahl x eingibt, endet die Schleife
        eingabe = 1;

        while (eingabe > 0) {
            System.out.print("Geben Sie eine ganze Zahl zum Löschen ein: ");

            try {
                eingabe = scan.nextInt();
                break;
            } catch (InputMismatchException ex) {
                scan.nextLine();
            }
        }

        // 4  - aus der Liste alle Elemente gelöscht werden, deren Wert x ist (siehe vorangegangene User-Eingabe)
        Collections.sort(zahlenListe);
        System.out.println("Sortierte zahlenListe: " + zahlenListe);

        int position = 1;
        do {

            try {
                position = Collections.binarySearch(zahlenListe, eingabe);
                zahlenListe.remove(position);
            } catch (IndexOutOfBoundsException ex) {
                System.out.println(ex.getMessage());
            }

        } while (position > 0);

        // 5  - zur Kontrolle die (verkürzte) Liste ausgegeben wird
        System.out.println("Verkürzte Liste: " + zahlenListe);

    }
}
