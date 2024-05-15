package aufgaben;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Auf_01_240402_Arrays_sv01 {
    /*
 * Aufgabe 1
Schreiben Sie bitte ein Java-Programm, das
a) in einer Endlosschleife den User zu Beginn jeden Durchlaufs fragt, ob er eine  ...
	(1) Übersetzung, oder
	(2) Monatsnummer wünscht
	(3) Programm Beenden

b) bei Eingabe von (1) einen deutschen Monatsnamen abfragt und die englische Übersetzung ausgibt
c) bei Eingabe von (2) einen deutschen Monatsnamen abfragt und die Monatsnummer ausgibt (Januar=1, ...)
d) bei Fehleingaben (Auswahl ungleich 1 und 2 / nicht-existenter deutscher Monatsname) eine entsprechende Fehlermeldung ausgibt

Bemerkung:
Versuchen Sie die Aufgabe bitte zunächst durch zwei 1-dimensionale String-Arrays zu lösen.
*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int auswahl = 0;
        String monatsName;

        while (true) {

            System.out.print("\nGeben Sie ein, was Sie wollen: \n\t(1) Übersetzung\n\t(2) Monatsnummer wünscht \n\t(3) Programm Beenden\n\tHIER EINGEBEN: ");

            try {
                auswahl = scan.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Nur Zahlen eingeben!");
            } finally {
                scan.nextLine();
                System.out.println();
            }

            if (auswahl == 1) {
                System.out.print("Geben Sie einen Monatsnamen auf Deutsch ein: ");
                monatsName = scan.nextLine();
                monatsName = monatsName.toUpperCase();

                System.out.println();
                switch (monatsName){
                    case "JANUAR":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: January!"); break;
                    case "FEBRUAR":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: February!"); break;
                    case "MÄRZ":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: March!"); break;
                    case "APRIL":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: April!"); break;
                    case "MAI":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: May!"); break;
                    case "JUNI":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: June!"); break;
                    case "JULI":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: July!"); break;
                    case "AUGUST":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: August!"); break;
                    case "SEPTEMBER":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: September!"); break;
                    case "OKTOBER":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: October!"); break;
                    case "NOVEMBER":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: November!"); break;
                    case "DEZEMBER":
                        System.out.println(monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist auf Englisch: December!"); break;
                    default:
                        System.out.println("So etwas gibt es nicht. Versuche noch einmal");
                }
            } else if (auswahl == 2) {
                System.out.print("Geben Sie einen Monatsnamen ein: ");
                monatsName = scan.nextLine();
                monatsName = monatsName.toUpperCase();

                switch (monatsName) {
                    case "JANUAR":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 1"); break;
                    case "FEBRUAR":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 2"); break;
                    case "MÄRZ":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 3"); break;
                    case "APRIL":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 4"); break;
                    case "MAI":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 5"); break;
                    case "JUNI":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 6"); break;
                    case "JULI":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 7"); break;
                    case "AUGUST":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 8"); break;
                    case "SEPTEMBER":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 9"); break;
                    case "OKTOBER":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 10"); break;
                    case "NOVEMBER":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 11"); break;
                    case "DEZEMBER":
                        System.out.println("Die Monatsnummer von " + monatsName.charAt(0) + monatsName.substring(1, monatsName.length()).toLowerCase() + " ist 12"); break;
                    default:
                        System.out.println("So etwas gibt es nicht. Versuche noch einmal");
                }
            } else if (auswahl == 3) {
                return;
            } else {
                System.out.println("Zur Auswahl haben Sie nur 1, 2 und 3");
            }



        }

    }
}
