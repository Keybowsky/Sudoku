package Sudoku;

import javax.swing.*;
import java.awt.*;

class BoxMethod extends Tutorial {


    final JPanel boxSolvingMethodPanel = new JPanel();

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

    BoxMethod(int langID, int themeID){
    //wywalić themeID

        boxSolvingMethodPanel.setBackground(actualColor[2]);
        boxSolvingMethodPanel.setPreferredSize(tutorialPanelSize);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(BoxMethod.BoxMethodCom1());
        boxSolvingMethodPanel.add(solvingMethod);

    }


    static String BoxMethodCom1(){
        return "Tutaj dajesz tekst który chcesz żeby był wskazówką";
    }



}
