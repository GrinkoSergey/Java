package aufgaben.auf02_produkt_factory_sv01;

import aufgaben.auf02_produkt_factory_sv01.Produkt.Buecher;
import aufgaben.auf02_produkt_factory_sv01.Produkt.Elektronik;
import aufgaben.auf02_produkt_factory_sv01.Produkt.Kleidung;
import aufgaben.auf02_produkt_factory_sv01.Produkt.Produkt;

public class ProduktFabrik {

    public static Produkt erzeugeProdukt(String produktName) throws IllegalArgumentException {

        if (produktName.equalsIgnoreCase("e")) {
            return new Elektronik();
        } else if (produktName.equalsIgnoreCase("b")) {
            return new Buecher();
        } else if (produktName.equalsIgnoreCase("k")) {
            return new Kleidung();
        } else {
            throw new IllegalArgumentException("Falsche Eingabe: " + produktName);
        }
    }
}
