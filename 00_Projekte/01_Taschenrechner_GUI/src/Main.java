import view.TR_Oberflaeche;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TR_Oberflaeche();
            }
        });
    }
}
