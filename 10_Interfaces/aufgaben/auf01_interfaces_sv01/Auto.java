package aufgaben.auf01_interfaces_sv01;

public class Auto extends Fahrzeug implements IFahrbar {

    public Auto() {
        super();
    }

    @Override
    public void fahren() {
        System.out.println("Auto kann fahren");
    }
}
