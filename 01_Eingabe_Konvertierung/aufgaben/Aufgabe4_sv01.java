package aufgaben;

import java.util.Random;
import java.util.Scanner;

public class Aufgabe4_sv01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int zufZahl = rand.nextInt(99) + 1;
        int versuch = 0;
        int eingabe = 0;

        while (eingabe != zufZahl) {
            versuch++;
            System.out.print("Erraten Sie eine Zahl zwischen 1 und 99. Geben Sie die Zahl ein: ");
            try {
                eingabe = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println();
                System.out.println("Nur Zahlen sind erlaubt!");
                System.out.println();
                continue;
            }
            if(eingabe == zufZahl) {
                System.out.println("Getroffen. Sie brauchen dafür " + versuch + " Versuche");
            } else if (zufZahl > eingabe) {
                System.out.println("Die gewürfelte Zahl größer als " + eingabe);
            } else {
                System.out.println("Die gewürfelte Zahl kleiner als " + eingabe);
            }
            System.out.println();
        }
    }
}
