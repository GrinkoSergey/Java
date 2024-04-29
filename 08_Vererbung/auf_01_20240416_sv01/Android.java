package aufgaben_sv01.auf_01_20240416_sv01;
/*
* Subklasse Android, erbt von Robot
*  - Attribute: isHuman
 */
class Android extends Robot {

    private boolean isHuman;

    public Android(String name, boolean isHostile, boolean isHuman) {
        super(name, isHostile);
        this.isHuman = isHuman;
    }

    public boolean isHuman() {
        return isHuman;
    }
}
