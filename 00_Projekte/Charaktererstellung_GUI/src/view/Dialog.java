package view;

import javax.swing.*;

// 20
public class Dialog extends JDialog {

    public Dialog() {
        init();
    }

    private void init() {
        JOptionPane.showMessageDialog(new JFrame(), "Die Checkbox 'Eingaben korrekt' wurde nicht bestätigt", "Warnung", JOptionPane.WARNING_MESSAGE);
    }

// 20 Ende
}
