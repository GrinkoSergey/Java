package aufgaben.auf01_interfaces_sv01;

import java.util.ArrayList;
import java.util.List;

public abstract class Fahrzeug {
    public static List<Fahrzeug> fahrzeugListe = new ArrayList<>();
    protected Fahrzeug() {
        fahrzeugListe.add(this);
    }
}
