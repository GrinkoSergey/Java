package aufgaben.auf02_menue_strategiemuster_sv01.strategie;

public class DateiOeffnenStrategie implements MenueStrategie {
    @Override
    public void ausfuehren() {
        System.out.println("Öffnet eine Datei...");
    }
}
