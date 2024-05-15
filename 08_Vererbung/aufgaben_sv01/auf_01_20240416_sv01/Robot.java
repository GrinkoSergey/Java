package aufgaben_sv01.auf_01_20240416_sv01;

/* Basisklasse Robot
 *  - Attribute: name, isHostile
 */

class Robot {
    private String name;
    private boolean isHostile;

    public Robot(String name, boolean isHostile) {
        this.name = name;
        this.isHostile = isHostile;
    }

    public String getName() {
        return name;
    }

    public boolean isHostile() {
        return isHostile;
    }

}
