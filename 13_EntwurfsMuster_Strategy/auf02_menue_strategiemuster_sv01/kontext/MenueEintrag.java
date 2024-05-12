package aufgaben.auf02_menue_strategiemuster_sv01.kontext;

import aufgaben.auf02_menue_strategiemuster_sv01.strategie.MenueStrategie;

public class MenueEintrag {
    private MenueStrategie menueStrategie = null;

    public void setMenueStrategie(MenueStrategie menueStrategie) {
        this.menueStrategie = menueStrategie;
    }

    public void beimKlicken() {
        if (menueStrategie != null) {
            menueStrategie.ausfuehren();
        } else {
            System.out.println("Fehlermeldung: \"Die Strategie wurde nicht ausgesucht!\"");
        }
    }

}
