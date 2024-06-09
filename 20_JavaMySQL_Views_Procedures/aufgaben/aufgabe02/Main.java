package aufgaben.aufgabe02;

public class Main {
    public static void main(String[] args) {
        System.out.println(Service.kursbelegungView());

        System.out.println(Service.insertKursbelegung(4576, "Wiw330", "ZYX", 5.5));
        System.out.println(Service.updateKursbelegung(4576, "Wiw330", 1.1));
    }
}
