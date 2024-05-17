package aufgaben.auf00_observer_pattern_sv01;

public class Feuerwehr implements Feuerloescher {
    @Override
    public void feuerLoeschen() {
        System.out.println("Feuer löschen!");
    }
}
