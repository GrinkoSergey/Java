package view;

import controller.Berechnung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TR_Oberflaeche extends JFrame implements ActionListener {

    // 2.1
    private JTextField ausgabeFeld;
    private final Font MYFONT = new Font("Arial", Font.BOLD, 30);
    // 2.1 Ende
    // 3.1
    JButton[] zahlenButton = new JButton[10];
    JButton[] operationButton = new JButton[8];
    // 3.1 Ende

    // 1
    public TR_Oberflaeche() {
        erstelleOberflaeche();
    }

    private void erstelleOberflaeche() {
        setTitle("Tachenrechner");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 550);
        getContentPane().setBackground(new Color(104, 139, 173));
        setLayout(null);
        setLocationRelativeTo(null);


        // 2.2
        ausgabeFeld = new JTextField();
        ausgabeFeld.setBounds(50, 25, 300, 50);
        ausgabeFeld.setFont(MYFONT);
        setBackground(new Color(194, 199, 204));
        ausgabeFeld.setHorizontalAlignment(JTextField.RIGHT);
        ausgabeFeld.setEditable(false);
        ausgabeFeld.setCaretColor(new Color(194, 199, 204));
        // 2.2 Ende

        // 3.2
        for (int i = 0; i < 10; i++) {
            zahlenButton[i] = new JButton(String.valueOf(i));
            zahlenButton[i].addActionListener(this);

            zahlenButton[i].setFont(MYFONT);
            zahlenButton[i].setFocusable(false);
        }
        // 3.2 Ende
        // 5.2
        for (int i = 0; i < 8; i++) {
            operationButton[i] = new JButton(Berechnung.getOperatorenArray()[i].getZeichen());
            operationButton[i].addActionListener(this);
            operationButton[i].setFont(MYFONT);
            operationButton[i].setFocusable(false);
        }
        // 5.2 Ende

        // 6.1
        JPanel zahlenPanel = new JPanel();
        zahlenPanel.setLayout(new GridLayout(4, 4, 10, 10));
        zahlenPanel.setBounds(50, 100, 300, 300);
        zahlenPanel.setBackground(new Color(87, 118, 148));


        // erste Reihe
        zahlenPanel.add(zahlenButton[7]);
        zahlenPanel.add(zahlenButton[8]);
        zahlenPanel.add(zahlenButton[9]);
        zahlenPanel.add(operationButton[3]);

        // zweite Reihe
        zahlenPanel.add(zahlenButton[4]);
        zahlenPanel.add(zahlenButton[5]);
        zahlenPanel.add(zahlenButton[6]);
        zahlenPanel.add(operationButton[2]);

        // dritte Reihe
        zahlenPanel.add(zahlenButton[1]);
        zahlenPanel.add(zahlenButton[2]);
        zahlenPanel.add(zahlenButton[3]);
        zahlenPanel.add(operationButton[1]);

        // vierte Reihe
        zahlenPanel.add(operationButton[4]);
        zahlenPanel.add(zahlenButton[0]);
        zahlenPanel.add(operationButton[5]);
        zahlenPanel.add(operationButton[0]);
        // 6.1 Ende

        // 7.1
        operationButton[6].setBounds(50, 430, 145, 50);
        operationButton[7].setBounds(205, 430, 145, 50);
        // 7.1 Ende

        // 8 ist in Berechnung

        // 6.2
        add(zahlenPanel);
        // 6.2 Ende
        // 7.2
        add(operationButton[6]);
        add(operationButton[7]);
        // 7.2 Ende
        // 2.3
        add(ausgabeFeld);
        // 2.3 Ende
        setResizable(false);
        setVisible(true);

    }

    // 1.2
    @Override
    public void actionPerformed(ActionEvent e) {
        // 9
        Berechnung.berechneErgebnis(e, zahlenButton, operationButton, ausgabeFeld);
        // 9 Ende
    }
    // 1.2 Ende
    // 1 Ende

}
