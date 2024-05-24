package model.klasse;
// 9
public enum Klassen {
    AUSWAHL("Wähle Klasse"),
    PALADIN("Paladin"),
    RITTER("Ritter"),
    MAGIER("Magier"),
    WALKÜRE("Walküre");

    private String name;

    Klassen(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

// 9 Ende
}
