package aufgaben.auf01_factory_pattern_sv01.Fabrik;

import aufgaben.auf01_factory_pattern_sv01.Main;
import aufgaben.auf01_factory_pattern_sv01.Pizza.MarsSalamiPizza;
import aufgaben.auf01_factory_pattern_sv01.Pizza.MarsSchinkenPizza;
import aufgaben.auf01_factory_pattern_sv01.Pizza.Pizza;

public class MarsFabrik extends Fabrik {
    @Override
    public Pizza erstellePizza(String sorte) {
        switch (sorte.toLowerCase()) {
            case "salami":
                return new MarsSalamiPizza();
            case "schinken":
                return new MarsSchinkenPizza();
            default:
                System.out.println("Falsche Eingabe");
                return null;
        }
    }
}
