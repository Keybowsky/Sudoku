package Sudoku;

import javax.swing.*;

class RandomMethod extends Tutorial{

    final JPanel randomSolvingMethodPanel = new JPanel();

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


    RandomMethod(int langID, int themeID){

        randomSolvingMethodPanel.setBackground(actualColor[2]);
        //boxSolvingMethodPanel.setPreferredSize(tutorialPanelSize);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(RandomMethod.RandomMethodCom1());
        randomSolvingMethodPanel.add(solvingMethod);

    }

    static String RandomMethodCom1(){
        return "Tutaj dajesz tekst który chcesz żeby był wskazówką";
    }
}
