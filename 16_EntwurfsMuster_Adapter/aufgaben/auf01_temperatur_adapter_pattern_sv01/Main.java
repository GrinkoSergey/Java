package aufgaben.auf01_temperatur_adapter_pattern_sv01;
/* Sie möchten ein Programm zur Verarbeitung der Temperaturdaten eines Temperatursensors schreiben.
 * Der Sensor, den Sie verwenden, kommt mit einer fertigen Klasse "TemperaturSensor". Diese Klasse liefert die Temperatur allerdings nur in Kelvin zurück.
 * Für Ihre Anwendung möchten sie statt Kelvin, Grad Celsius verwenden. Den Code der TemperaturSensor-Klasse können Sie aber nicht verändern, da die Klasse nur kompiliert ausgeliefert wurde. Darum entscheiden Sie sich, das Adapter-Pattern umzusetzen.
 */

public class Main {
    public static void main(String[] args) {
        TemperaturSensorCelsius adapter = new Adapter();
        adapter.ausgabeInCelsius();
    }
}
