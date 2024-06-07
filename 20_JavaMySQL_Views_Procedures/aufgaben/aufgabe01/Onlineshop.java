package aufgaben.aufgabe01;



public class Onlineshop {
    public static void main(String[] args) {

        // insertKunde
        int kundenNummer = Service.insertKunde("Kunde007");
        System.out.println("Die neue Kundennummer: " + kundenNummer);

        // updateKunde
        if(Service.updateKunde(kundenNummer, "Kunde008") > 0)
            System.out.println("Alles hat geklappt");
    }
}
