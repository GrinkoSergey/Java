package aufgaben.auf01_temperatur_adapter_pattern_sv01;

public class Adapter implements TemperaturSensorCelsius {
    TemperaturSensor temperaturSensor = new TemperaturSensor();
    public double tempCelsius;
    private double konvertiereInCelsius() {
        return temperaturSensor.getTemperatur() - 273.15;
    }

    @Override
    public void ausgabeInCelsius() {
        for (int i = 0; i < 10; i++) {
            tempCelsius = konvertiereInCelsius();
            System.out.printf("%d. Temperaturmessung: %6.2f Grad Celsius\n", i+1, tempCelsius);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
