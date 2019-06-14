package Sudoku;

import javax.swing.*;

class DiagonalMethod extends Tutorial {

    final JPanel diagonalSolvingMethodPanel = new JPanel();

    public int[][] tutorialFieldsValue = {
            {1,2,3,4,5,6,7,8,9},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0},
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
