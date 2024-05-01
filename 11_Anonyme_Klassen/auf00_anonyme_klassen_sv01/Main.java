package aufgaben.auf00_anonyme_klassen_sv01;

public class Main {
    public static void main(String[] args) {
        // zwei Objekte vom Typ Künstler, wobei Sie mit Hilfe anonymer Klassen die kunstErstellen()-Methode überschreiben.

        Kuenstler maler1 = new Kuenstler () {

            @Override
            void kunstErstellen() {
                System.out.println("Ich male ein Bild");
            }
        };

        Kuenstler saenger1 = new Kuenstler() {
            @Override
            void kunstErstellen() {
                System.out.println("Ich singe einen Song");
            }
        };

        // Ein Maler soll auf der Konsole "Ich male ein Bild" und ein Sänger soll "Ich singe einen Song" ausgeben.
        maler1.kunstErstellen();
        saenger1.kunstErstellen();

        // optional 1
        System.out.println();
        new Kuenstler() {
            @Override
            void kunstErstellen() {
                System.out.println("Ich male auch ein Bild");
            }
        }.kunstErstellen();

        new Kuenstler() {
            @Override
            void kunstErstellen() {
                System.out.println("Ich singe auch einen Song");
            }
        }.kunstErstellen();

        // optional 2
        System.out.println();
        ausgabe(new Kuenstler() {
            @Override
            void kunstErstellen() {
                System.out.println("Ich bin ein Maler und male auch Bilder");
            }
        });

        ausgabe(new Kuenstler() {
            @Override
            void kunstErstellen() {
                System.out.println("Ich bin ein Sänger und singe auch Songs");
            }
        });

        // optional 3: Innere Klasse
        System.out.println();

        Main.Test.zeige();
        new Test() {
            @Override
            public void zeige2() {
                System.out.println("Ich sehe dich: " + text);
            }
        }.zeige2();



    } // Ende main-Methode

    // optional 2
    private static void ausgabe(Kuenstler kuenstler) {
        kuenstler.kunstErstellen();
    }

    //optional 3: Innere Klasse

    private static String text = "Ich bin ein Text";
    public static class Test{
        public static void zeige() {
            System.out.println("Ich zeige eine innere Klasse");
        }

        public void zeige2() {

        }

    }

} // Ende Klasse
