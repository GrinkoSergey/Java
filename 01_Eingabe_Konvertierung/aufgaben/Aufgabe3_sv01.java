package aufgaben;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aufgabe3_sv01 {
    
    static Scanner scan = new Scanner(System.in);

    static int inputINT(String s){
        int a = 0;

        do {

            try {
                System.out.print(s);
                a = scan.nextInt();

                try {
                    if (a != 42) {
                        throw new IllegalArgumentException("Sie müssen 42 eingeben!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Fehler: Nur Zahlen eingeben!");;
            }

        } while (a != 42);
        return a;
    }
    public static void main(String[] args) {

        String s = "Geben Sie bitte eine ganze Zahl ein: ";

        System.out.println("Die Eingabe: " + inputINT(s));
    }
}
