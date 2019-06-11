package Sudoku;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import static Sudoku.GUI.actualColor;

class GameName {
    JLabel gameName() {

        //Icon ikonka = new ImageIcon("./src/main/resources/giff.gif");

        JLabel name = new JLabel("SUDOKU");
        //name.setIcon(ikonka);
        name.setFont(new Font("Verdana", Font.BOLD, 100));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setOpaque(false);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setForeground(actualColor[4]);
        Border margin = new EmptyBorder(10,10,10,10);
       // Border border = name.getBorder();
        //comp.setBorder(new CompoundBorder(border, margin));
      //  Border border = LineBorder.createGrayLineBorder();
       // name.setBorder(border);
        //name.setBorder(new LineBorder(Color.red, 3));
        return name;

    }
}