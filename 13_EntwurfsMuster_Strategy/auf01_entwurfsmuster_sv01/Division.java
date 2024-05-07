package aufgaben.auf01_entwurfsmuster_sv01;

public class Division implements Strategie {
    @Override
    public double rechne(double a, double b) {
        return a / b;
    }
}
