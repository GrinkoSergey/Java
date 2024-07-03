package aufgabe;

import java.io.Serializable;

public class Auftrag implements Serializable {
    Kunde kunde;
    String geraet;

    public Auftrag(Kunde kunde, String geraet) {
        this.kunde = kunde;
        this.geraet = geraet;
    }

    @Override
    public String toString() {
        return "Auftrag{" +
                "kunde=" + kunde.getName() +
                ", Gerät='" + geraet + '\'' +
                '}';
    }
}
