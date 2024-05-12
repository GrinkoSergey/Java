package aufgaben.auf00_entwurfsmuster_sv01;

public class Multiplikation implements Strategie {
    @Override
    public double rechne(double a, double b) {
        return a * b;
    }
}
