package aufgaben.auf01_interfaces_sv01;

public class Boot extends Fahrzeug implements ISchwimmfähig {
    public Boot() {
        super();
    }

    @Override
    public void schwimmen() {
        System.out.println("Boot kann schwimmen");
    }
}
