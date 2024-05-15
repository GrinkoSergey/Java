package aufgaben;

import java.util.Scanner;

public class Auf_02_20240417_Enum_sv01 {

    public static Scanner scan;
    public static void main(String[] args) {

        // dem Benutzer in einer Schleife eine Auswahl präsentieren
        // *      - Kyu-Grad (1)
        // *      - Gürtel-Farbe (2)
        // *      - Nächste Prüfung (3)


        scan = new Scanner(System.in);
        boolean isOk = true;
        int eingabe;
        String farbe;

        while (isOk) {
            eingabe = 0;
            System.out.print("Geben Sie ein: \nKyu-Grad (1)\nGürtel-Farbe (2)\nNächste Prüfung (3)\nAuswahl: ");
            try {
                eingabe = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Falsche Eingabe");
                continue;
            }

    // - Bei der ersten Auswahl gibt der Benutzer seinen Kyu-Grad (zwischen 1 und 9) ein und bekommt die Gürtelfarbe ausgegeben
            switch (eingabe) {
                case 1:
                    while (isOk) {
                        System.out.print("Geben Sie Ihren Kyu-Grad (eine Zahl zwischen 1 und 9) ein: ");
                        eingabe = Integer.parseInt(scan.nextLine());
                        for(Kyu k : Kyu.values()) {
                            if (eingabe == k.getGrad()) {
                                System.out.println(k.name());
                            }
                        }
                        if(eingabe > 0 && eingabe < 10) {
                            isOk = false;
                        } else {
                            System.out.println("\nFalsche Eingabe\n");
                        }
                    }
                    break;

    // - Bei der zweiten Auswahl sollen dem Benutzer die möglichen Gürtelfarben ausgegeben werden.
                case 2:
                    while (isOk) {
                        guertelFarbenAusgabe();

                        // *      - anschließend gibt der Benutzer eine Farbe ein und bekommt den Kyu-Grad als Ausgabe.
                        System.out.print("\nGeben Sie die Farbe ein: ");
                        farbe = scan.nextLine();
                        for (Kyu k : Kyu.values()) {
                            if (farbe.equalsIgnoreCase(k.name())) {
                                System.out.println("Der Kyu-Grad für " + farbe + " ist " + k.getGrad());
                                isOk = false;
                            }
                        }
                        if (isOk) {
                            System.out.println("\nFalsche Eingabe\n");
                        }
                    }
                    break;
                case 3:
    // Bei der dritten Auswahl sollen dem Benutzer wieder die möglichen Gürtelfarben ausgegeben werden.
                    while (isOk) {
                        guertelFarbenAusgabe();
                        // Der Benutzer gibt seine aktuelle Gürtelfarbe ein und bekommt als Ausgabe die Farbe des nächsten Gürtels.
                        System.out.print("\nGeben Sie Ihre aktuelle Gürtelfarbe ein: ");
                        farbe = scan.nextLine();
                        if(farbe.equalsIgnoreCase("braun")) {
                            System.out.println("Sie haben den höchsten Kyu-Grad");
                            isOk = false;
                            break;
                        }

                        Kyu[] kyus = Kyu.values();
                        for (Kyu k : Kyu.values()) {
                            if (farbe.equalsIgnoreCase(k.name())) {
                                System.out.println("Ihre nächste Gürtelfarbe: " + (kyus[k.getGrad()]).name());
                                isOk = false;
                            }
                        }
                        if (isOk) {
                            System.out.println("\nFalsche Eingabe\n");
                        }

                    }
                    break;
                default:
                    System.out.println("Sie dürfen nur 1, 2 oder 3 eingeben! Versuchen Sie noch einmal");
            }

        }

    }
    static void guertelFarbenAusgabe() {
        System.out.println("Hier sind die möglichen Gürtelfarben: ");
        int i = 1;
        for (Kyu k : Kyu.values()) {
            System.out.print(i + " -> " + k.name());
            if (i < (Kyu.values().length)) {
                System.out.print(", ");
            }
            i++;
        }
    }
}

// enum Kyu einführen
enum Kyu {
    BRAUN(1),
    BLAU(2),
    GRÜN(3),
    ORANGEGRÜN(4),
    ORANGE(5),
    GELBORANGE(6),
    GELB(7),
    WEIßGELB(8),
    WEIß(9);

    private final int grad;
    Kyu(int grad) {
        this.grad = grad;
    }

    public int getGrad() {
        return grad;
    }

}





