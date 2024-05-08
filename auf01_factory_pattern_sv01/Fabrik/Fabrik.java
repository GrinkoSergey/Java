package aufgaben.auf01_factory_pattern_sv01.Fabrik;

import aufgaben.auf01_factory_pattern_sv01.Pizza.Pizza;

public abstract class Fabrik {
    public abstract Pizza erstellePizza(String sorte);
}
