package aufgaben.auf02_produkt_factory_sv01;

import aufgaben.auf02_produkt_factory_sv01.Produkt.Produkt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Produkt produkt = null;
        String produktName;
        Scanner scan = new Scanner(System.in);

        System.out.print("Geben Sie ein, was für ein Produkt Sie erzeugen möchten:\ne <- von dem Typ Elektronik\nb <- von dem Typ Buch\nk <- von dem Typ Kleidung\nEingabe: ");
        produktName = scan.nextLine();

        try {
            produkt = ProduktFabrik.erzeugeProdukt(produktName);
            produkt.displayInfo();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
