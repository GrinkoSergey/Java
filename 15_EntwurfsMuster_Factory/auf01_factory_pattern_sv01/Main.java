package aufgaben.auf01_factory_pattern_sv01;

import aufgaben.auf01_factory_pattern_sv01.Fabrik.Fabrik;
import aufgaben.auf01_factory_pattern_sv01.Fabrik.MarsFabrik;
import aufgaben.auf01_factory_pattern_sv01.Fabrik.VenusFabrik;
import aufgaben.auf01_factory_pattern_sv01.Pizza.Pizza;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Fabrik fabrik = null;
        Pizza pizza = null;
        String eingabe = null;
        System.out.print("Geben Sie an, wo Sie sich befinden:\n1 <- für Mars\n2 <- für Venus\nEingabe: ");
        eingabe = scan.nextLine();
        switch (eingabe.toLowerCase()) {
            case "1":
                fabrik = new MarsFabrik();
                break;
            case "2":
                fabrik = new VenusFabrik();
                break;
            default:
                System.out.println("Falsche Eingabe");
                return;
        }

        System.out.print("Geben Sie an, welche Pizza Sie bestellen möchten:\nSalami <- für eine Pizza mit Salami\nSchinken <- für eine Pizza mit Schinken\nEngabe: ");
        eingabe = scan.nextLine();
        if (!eingabe.equalsIgnoreCase("salami") && !eingabe.equalsIgnoreCase("schinken")) {
            System.out.println("So eine Pizza haben wir nicht");
        } else {
            pizza = fabrik.erstellePizza(eingabe);
            System.out.println(pizza.toString());
        }

    }
}
