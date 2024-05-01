package aufgaben.auf00_funktionales_Interface__lambda_sv01;
// eine Klasse "Sportler" mit der Methode "führeAktionAus", mit void Rückgabetyp, welche als Parameter eine Aktion erwartet und die Aktion dann ausführt
public class Spotler {
    public void fuehreAktionAus(Aktion aktion) {
        if(aktion != null)
            aktion.ausfuehren();
    }
}
