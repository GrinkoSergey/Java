package aufgaben.auf00_observer_pattern_sv01;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Feuerwehr feuerwehr1 = new Feuerwehr();

        person1.flHinzufuegen(feuerwehr1);

        person1.feuerRufen(feuerwehr1);
    }
}
