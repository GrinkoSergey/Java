package model;

// 4
public enum Operatoren {
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    SEP("."),
    EQUAL("="),
    DEL("Del"),
    CLR("Clr");

    private String zeichen;

    Operatoren(String zeichen) {
        this.zeichen = zeichen;
    }

    public String getZeichen() {
        return zeichen;
    }

}
// 4 Ende
