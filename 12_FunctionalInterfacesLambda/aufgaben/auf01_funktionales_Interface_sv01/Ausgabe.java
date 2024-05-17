package aufgaben.auf01_funktionales_Interface_sv01;

// das funktionale Interface "Ausgabe" mit der void "ausgeben(String[] daten)"-Methode
@FunctionalInterface
public interface Ausgabe {
    void ausgeben(String[] daten);
}
