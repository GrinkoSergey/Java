package aufgaben.auf00_entwurfsmuster_sv01;

public class Kontext {
    Strategie strategie;


    public void setStrategie(Strategie strategie) {
        this.strategie = strategie;
    }

    public double berechne(double a, double b) {
        return strategie.rechne(a, b);
    }

}
