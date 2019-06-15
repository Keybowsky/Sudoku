package Sudoku;

import javax.swing.*;
import java.awt.*;
import static Sudoku.GUI.actualColor;

/** Klasa sluzy do ustawienia nazwy gry. */

class GameName {

    /** Kostruktor ktory zwraca panel z nazwa gry.
     *
     * @return name
     *
     * */
    JLabel gameName() {

        JLabel name = new JLabel("SUDOKU");
        name.setFont(new Font("Verdana", Font.BOLD, 100));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setOpaque(false);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setForeground(actualColor[4]);

        return name;
    }
}