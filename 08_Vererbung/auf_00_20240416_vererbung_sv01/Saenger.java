package aufgaben_sv01.auf_00_20240416_vererbung_sv01;

public final class Saenger extends Kuenstler { // von dieser Klasse kann man weiter nicht vererben <-- 'final'

    public Saenger(String name) {
        super(name);
        System.out.println("Ich bin ein Sänger");
    }

    // optional
    @Override
    public void ausgabe() {
        System.out.println("Ich bin die Klasse 'Saenger'");
    }

}
