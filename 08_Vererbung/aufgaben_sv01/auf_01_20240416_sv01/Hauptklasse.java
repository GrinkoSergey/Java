package aufgaben_sv01.auf_01_20240416_sv01;
/* 
 * Erstellen Sie von jeder Klasse ein Objekt und weisen sie den Attributen über die Konstruktoren beliebige Werte zu.
 * Testen Sie die Attribute durch Konsolenausgaben
 */

public class Hauptklasse {
    public static void main(String[] args) {
        Robot robot1 = new Robot("Robot1", true);
        Terminator terminator1 = new Terminator("Terminator1", false, "Robot1");
        Transformer transformer1 = new Transformer("Transformer1", false, "Autobots");
        Android android1 = new Android("Android1", false, false);

        System.out.println(robot1.getClass().getSimpleName());
        System.out.println(terminator1.getClass().getSimpleName());
        System.out.println(transformer1.getClass().getSimpleName());
        System.out.println(android1.getClass().getSimpleName());

        System.out.println();
        System.out.println(robot1.getName());
        System.out.println(terminator1.getTargetName());
        System.out.println(transformer1.isHostile());
        System.out.println(android1.getName());

    }
}
