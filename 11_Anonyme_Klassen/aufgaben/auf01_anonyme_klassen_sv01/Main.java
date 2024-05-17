package aufgaben.auf01_anonyme_klassen_sv01;

public class Main {
    public static void main(String[] args) {

        int a = 5;
        int b = 3;

        // erstellen Sie vier anonyme Klassen, die das Interface implementieren und 'execute' mit den vier Grundrechenarten überschreiben.
        Operation addition = new Operation() {
            @Override
            public double execute(int a, int b) {
                return a + b;
            }
        };

        Operation subtraktion = new Operation() {
            @Override
            public double execute(int a, int b) {
                return a - b;
            }
        };

        Operation multiplikation = new Operation() {
            @Override
            public double execute(int a, int b) {
                return a * b;
            }
        };

        Operation division = new Operation() {
            @Override
            public double execute(int a, int b) {
                return (double) a / b;
            }
        };

        // Die Instanzen der vier anonymen Klassen übergeben sie dann an die `calculate`-Methode der Calculator-Klasse
        System.out.println(Calculator.calculate(a, b, addition));
        System.out.println(Calculator.calculate(a, b, subtraktion));
        System.out.println(Calculator.calculate(a, b, multiplikation));
        System.out.println(Calculator.calculate(a, b, division));

    }
}
