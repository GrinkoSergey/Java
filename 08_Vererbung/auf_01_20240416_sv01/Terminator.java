package aufgaben_sv01.auf_01_20240416_sv01;
/*
 * Subklasse Terminator, erbt von Robot
 *  - Attribute: targetName
 */
class Terminator extends Robot {

    private String targetName;

    public Terminator(String name, boolean isHostile, String targetName) {
        super(name, isHostile);
        this.targetName = targetName;
    }

    public String getTargetName() {
        return targetName;
    }

}
