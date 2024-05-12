package aufgaben.auf01_entwurfsmuster_sv01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String auswahl = null;
        double a = 0;
        double b = 0;
        char ausgewählt;
        boolean isOk = true;
        Kontext kontext = new Kontext();
        Scanner scanner = new Scanner(System.in);

        while (isOk) {
            System.out.print("Wählen Sie eine der Operationen und geben Sie den entsprechenden Buchstaben ein:\na <- Addition\ns <- Subtraktion\nm <- Multiplikation\nd <- Division\nIhre Auswahl: ");

            auswahl = scanner.nextLine();
            if (auswahl.equals("a") || auswahl.equals("s") || auswahl.equals("m") || auswahl.equals("d")) {
                isOk = false;
            } else {
                System.out.println("Falsche Eingabe");
            }
        }

        isOk = true;
        while (isOk) {
            try {
                System.out.print("Geben Sie die Zahl 1 ein: ");
                a = Double.parseDouble(scanner.nextLine());
                System.out.print("Geben Sie die Zahl 2 ein: ");
                b = Double.parseDouble(scanner.nextLine());
                isOk = false;
            } catch (NumberFormatException ex) {
                System.out.println("Falsche Eingabe");
            }
            if(auswahl.equals("d") && b == 0) {
                isOk = true;
                System.out.println("\nDas Teilen durch Null ist nicht erlaubt.\n");
            }
        }


        ausgewählt = auswahl.charAt(0);
        switch (ausgewählt) {
            case 'a':
                kontext.setStrategie(new Addition());
                break;
            case 's':
                kontext.setStrategie(new Subtraktion());
                break;
            case 'm':
                kontext.setStrategie(new Multiplikation());
                break;
            case 'd':
                kontext.setStrategie(new Division());
                break;
            default:
                System.out.println("Eingabe wurde schon überprüft");
        }

        System.out.println("Das Ergebnis der Rechenoperation ist: " + kontext.berechne(a, b));

    }
}
