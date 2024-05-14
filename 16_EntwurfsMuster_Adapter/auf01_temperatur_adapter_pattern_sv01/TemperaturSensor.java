package aufgaben.auf01_temperatur_adapter_pattern_sv01;

import java.util.Random;

public class TemperaturSensor {
    Random rand = new Random();
    double temp;
    String einheit;

    public double getTemperatur() {
        temp = ((rand.nextInt(100)) + 223) + ((double) (rand.nextInt(100)) / 100);
        return temp;
    }

    public String getEinheit() {
        einheit = "" + temp;
        return einheit + " Kelvin";
    }
}
