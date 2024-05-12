package aufgaben.auf00_entwurfsmuster_sv01;

public class Subtraktion implements Strategie {
    @Override
    public double rechne(double a, double b) {
        return a - b;
    }
}
