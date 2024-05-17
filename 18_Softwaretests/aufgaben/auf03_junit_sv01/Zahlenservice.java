package aufgaben.auf03_junit_sv01;

import template_sv01.personenservice.Person;

import java.util.ArrayList;
import java.util.List;

public class Zahlenservice {
    private List<Integer> zahlen = new ArrayList<>();

    public Zahlenservice(List<Integer> zahlen) {
        this.zahlen = zahlen;
    }

    public List<Integer> findeZahl(int x) {
        List<Integer> ergebnis = new ArrayList<>();
        for(Integer i : zahlen) {
            if(i == x) {
                ergebnis.add(i);
            }
        }
        return ergebnis;
    }
}
