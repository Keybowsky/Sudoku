package Sudoku;

import java.awt.*;

public class Sudoku {

    //Szybki test

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



