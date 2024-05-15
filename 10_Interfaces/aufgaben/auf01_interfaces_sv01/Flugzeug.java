package aufgaben.auf01_interfaces_sv01;

public class Flugzeug extends Fahrzeug implements IFlugfähig, IFahrbar {
    public Flugzeug() {
        super();
    }

    @Override
    public void fahren() {
        System.out.println("Flugzeug kann fahren");
    }

    @Override
    public void fliegen() {
        System.out.println("Flugzeug kann fliegen");
    }
}
