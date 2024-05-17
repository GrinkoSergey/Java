package aufgaben.auf02_menue_strategiemuster_sv01.strategie;

public class DateiSpeichernStrategie implements MenueStrategie {
    @Override
    public void ausfuehren() {
        System.out.println("Speichert eine Datei...");
    }
}
