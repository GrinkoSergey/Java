package controller;

import model.Operatoren;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class Berechnung {
    static double num1 = 0.0, num2 = 0.0, result = 0.0;
    static String operator;

    // 5.1
    public static Operatoren[] getOperatorenArray() {
        return Operatoren.values();
    }
    // 5.1 Ende

    // 8
    public static JTextField berechneErgebnis(ActionEvent e, JButton[] zahlen, JButton[] operationen, JTextField ausgabeFeld) {
        String s = null;

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == zahlen[i]) {
                ausgabeFeld.setText(ausgabeFeld.getText().concat(String.valueOf(i)));
            }
        }


        if (e.getSource() == operationen[4]) {
            if (ausgabeFeld.getText().contains(Operatoren.SEP.getZeichen())) {

            } else {
                ausgabeFeld.setText(ausgabeFeld.getText().concat(Operatoren.SEP.getZeichen()));
            }
        }

        if (e.getSource() == operationen[0]) {
            num1 = Double.parseDouble(ausgabeFeld.getText());
            ausgabeFeld.setText("");
            operator = Operatoren.ADD.getZeichen();
        }

        if (e.getSource() == operationen[1]) {
            if (ausgabeFeld.getText().isEmpty()) {
                ausgabeFeld.setText(ausgabeFeld.getText().concat(Operatoren.SUB.getZeichen()));
            } else {
                num1 = Double.parseDouble(ausgabeFeld.getText());
                ausgabeFeld.setText("");
                operator = Operatoren.SUB.getZeichen();
            }
        }

        if (e.getSource() == operationen[2]) {
            num1 = Double.parseDouble(ausgabeFeld.getText());
            ausgabeFeld.setText("");
            operator = Operatoren.MUL.getZeichen();
        }

        if (e.getSource() == operationen[3]) {
            num1 = Double.parseDouble(ausgabeFeld.getText());
            ausgabeFeld.setText("");
            operator = Operatoren.DIV.getZeichen();
        }

        if (e.getSource() == operationen[5]) {
            num2 = Double.parseDouble(ausgabeFeld.getText());

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            ausgabeFeld.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == operationen[6]) {
            s = ausgabeFeld.getText();
            ausgabeFeld.setText("");
            for (int i = 0; i < s.length() - 1; i++) {
                ausgabeFeld.setText(ausgabeFeld.getText() + s.charAt(i));
            }
        }

        if (e.getSource() == operationen[7]) {
            ausgabeFeld.setText("");
        }

        return ausgabeFeld;
    }
    // 8 Ende

}

