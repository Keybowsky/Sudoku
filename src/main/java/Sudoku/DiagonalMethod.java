package Sudoku;

import javax.swing.*;

class DiagonalMethod extends Tutorial {

    final JPanel diagonalSolvingMethodPanel = new JPanel();

    public static final int[][] tutorialFieldsValue = {
            {0, 9, 4, 0, 3, 0, 1, 5, 0},
            {8, 1, 2, 7, 0, 0, 0, 9, 6},
            {3, 0, 0, 1, 9, 0, 0, 8, 0},
            {0, 3, 0, 9, 0, 4, 6, 7, 0},
            {0, 0, 8, 6, 1, 3, 0, 4, 9},
            {0, 0, 6, 2, 0, 0, 0, 3, 1},
            {4, 0, 3, 5, 0, 0, 0, 0, 8},
            {5, 0, 0, 0, 2, 0, 7, 0, 0},
            {0, 6, 0, 0, 0, 8, 4, 1, 5},
    };

    public int[][] fieldsToColor = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    DiagonalMethod(int langID, int themeID){

        diagonalSolvingMethodPanel.setBackground(actualColor[2]);
        //boxSolvingMethodPanel.setPreferredSize(tutorialPanelSize);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(DiagonalMethod.DiagonalMethodCom1());
        diagonalSolvingMethodPanel.add(solvingMethod);


    }

    static String DiagonalMethodCom1(){
        return "Tutaj dajesz tekst który chcesz żeby był wskazówką";
    }
}
