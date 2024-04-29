package aufgaben.auf01_interfaces_sv01;

public class Main {
    public static void main(String[] args) {

        Flugzeug flugzeug1 = new Flugzeug();
        Auto auto1 = new Auto();
        Bagger bagger1 = new Bagger();
        Boot boot1 = new Boot();

        for (Fahrzeug f : Fahrzeug.fahrzeugListe) {
            System.out.println(f.getClass().getSimpleName());
            if (f instanceof Flugzeug) {
                ((Flugzeug) f).fahren();
                ((Flugzeug) f).fliegen();
                System.out.println();
            } else if (f instanceof Auto) {
                ((Auto) f).fahren();
                System.out.println();
            } else if (f instanceof Bagger) {
                ((Bagger) f).fahren();
                ((Bagger) f).schwimmen();
                System.out.println();
            } else if (f instanceof Boot) {
                ((Boot) f).schwimmen();
                System.out.println();
            }
        }

    }
}
