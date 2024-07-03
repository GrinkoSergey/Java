package aufgabe;

import java.io.Serializable;

public class Kunde implements Serializable {
    String name;

    public Kunde(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
