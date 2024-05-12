package aufgaben.auf01_zeitschriftsabo_observerpattern_sv01.observer;

public class KundeImpl implements Kunde {

    private String name;

    public KundeImpl(String name) {
        this.name = name;
    }
    @Override
    public void update(String zeitschrift) {
        System.out.println("Der Kunde " + name + " hat " + zeitschrift + " erhalten!");
    }
}
