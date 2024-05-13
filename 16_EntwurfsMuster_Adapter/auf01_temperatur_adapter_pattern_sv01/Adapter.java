package aufgaben.auf01_temperatur_adapter_pattern_sv01;

public class Adapter implements TemperaturSensorCelsius {
    TemperaturSensor temperaturSensor = new TemperaturSensor();
    public double tempCelsius;
    public double konvertiereInCelsius() {
        return temperaturSensor.getTemperatur() - 273.15;
    }

    @Override
    public void ausgabeInCelsius() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            tempCelsius = konvertiereInCelsius();
            System.out.printf("%6.2f Grad Celsius\n", tempCelsius);
        }
    }
}
