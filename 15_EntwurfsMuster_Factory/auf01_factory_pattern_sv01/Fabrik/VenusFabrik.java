package aufgaben.auf01_factory_pattern_sv01.Fabrik;

import aufgaben.auf01_factory_pattern_sv01.Pizza.MarsSchinkenPizza;
import aufgaben.auf01_factory_pattern_sv01.Pizza.Pizza;
import aufgaben.auf01_factory_pattern_sv01.Pizza.VenusSalamiPizza;

public class VenusFabrik extends Fabrik {
    @Override
    public Pizza erstellePizza(String sorte) {

        switch (sorte.toLowerCase()) {
            case "salami":
                return new VenusSalamiPizza();
            case "schinken":
                return new MarsSchinkenPizza();
            default:
                System.out.println("Falsche Eingabe");
                return null;
        }
    }
}
