package aufgaben.auf02_factory_produkt_sv01.Produkt;

public class Elektronik extends Produkt {
    @Override
    public void displayInfo() {
        System.out.println("Hier ist ein Produkt von dem Typ: " + this.getClass().getSimpleName());
    }
}
