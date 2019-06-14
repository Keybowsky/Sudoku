package Sudoku;

import javax.swing.*;
import java.awt.*;
import static Sudoku.GUI.actualColor;

/** Klasa służy do ustawienia nazwy gry. */

class GameName {

    /** Kostruktor który zwraca panel z nazwą gry.
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