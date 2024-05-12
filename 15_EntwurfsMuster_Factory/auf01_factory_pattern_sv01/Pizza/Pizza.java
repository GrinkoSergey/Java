package aufgaben.auf01_factory_pattern_sv01.Pizza;

public abstract class Pizza {
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
