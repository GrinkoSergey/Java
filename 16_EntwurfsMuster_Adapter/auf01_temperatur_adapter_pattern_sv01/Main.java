package aufgaben.auf01_temperatur_adapter_pattern_sv01;

public class Main {
    public static void main(String[] args) {
        TemperaturSensorCelsius adapter = new Adapter();
        adapter.ausgabeInCelsius();
    }
}
