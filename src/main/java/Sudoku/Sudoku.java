package Sudoku;
import java.awt.*;


/** Klasa służy do przechowania funkcji main. */
public class Sudoku {

    /** Służy do uruchomienia programu. */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GUI GUI = new GUI();
                GUI.frameMenu.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}



