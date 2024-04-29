package aufgaben.auf01_interfaces_sv01;

public class Bagger extends Fahrzeug implements IFahrbar, ISchwimmfähig {
    public Bagger() {
        super();
    }

    @Override
    public void fahren() {
        System.out.println("Bagger kann fahren");
    }

    @Override
    public void schwimmen() {
        System.out.println("Bagger kann schwimmen");
    }
}
