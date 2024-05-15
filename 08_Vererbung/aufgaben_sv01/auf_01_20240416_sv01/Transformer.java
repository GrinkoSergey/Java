package aufgaben_sv01.auf_01_20240416_sv01;
/*
 * Subklasse Transformer, erbt von Robot
 *  - Attribute: faction
 */
class Transformer extends Robot {

    private String faction;

    public Transformer(String name, boolean isHostile, String faction) {
        super(name, isHostile);
        this.faction = faction;
    }

    public String getFaction() {
        return faction;
    }

}
