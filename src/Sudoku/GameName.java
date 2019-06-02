package Sudoku;


import javax.swing.*;
import java.awt.*;
import static Sudoku.GUI.actualColor;

public class GameName {
    JLabel gameName() {

        Icon ikonka = new ImageIcon("giff.gif");

        JLabel name = new JLabel("Tutaj kiedyś będzie logo");
        name.setIcon(ikonka);
        name.setFont(new Font("Arial", Font.BOLD, 30));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setForeground(actualColor[4]);
        return name;

    }
}