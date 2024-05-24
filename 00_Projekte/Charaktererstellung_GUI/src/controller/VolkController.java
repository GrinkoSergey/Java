package controller;

import model.volk.Voelker;

// 10
public class VolkController {
    public static String[] getVoelker() {
        String[] namen = new String[Voelker.values().length];
        int count = 0;
        for (Voelker v : Voelker.values()) {
            namen[count] = v.toString();
            count ++;
        }
        return namen;
    }
}
