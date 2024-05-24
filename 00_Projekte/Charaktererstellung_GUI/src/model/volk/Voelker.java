package model.volk;
// 8
public enum Voelker {
    AUSWAHL("Wähle Volk"),
    MENSCH("Mensch"),
    ELF("Elf"),
    HOBBIT("Hobbit"),
    ZWERG("Zwerg"),
    ORK("Ork");

    private String name;

    Voelker(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //8 Ende
}
