package aufgaben.auf01_anonyme_klassen_sv01;
// Klasse 'Calculator', die eine Methode 'calculate' enthält, mit zwei Zahlen und einem Objekt vom Typ 'Operation' als Parameter und das Ergebnis der Operation als Rückgabe
public class Calculator {

    public static double calculate(int a, int b, Operation o) {
        return o.execute(a, b); // hier bleibt die Methode immer noch abstract. durch dieser Schreibweise zeigen wir, dass die Methode execute(a,b) später an einem Objekt von dem Typ 'Operation' aufgerufen wird und da (beim Aufruf) wird implementiert
    }
}
