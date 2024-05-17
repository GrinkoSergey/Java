package aufgaben.auf02_junit_sv01;

public class Division {
    public double dividiereZahlen(double x, double y) {

        if (y == 0) {
            throw new IllegalArgumentException("Teilen durch 0 ist nicht möglich");
        } else {
            return x / y;
        }
    }
}
