package Sudoku;

import javax.swing.*;
import java.awt.*;

class BoxMethod extends Tutorial {

    public static Color actualMove = new Color(20,20,250);

    JPanel boxSolvingMethodPanel = new JPanel();

    BoxMethod(int langID, int themeID){
    //wywalić themeID


        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(BoxMethod.BoxMethodCom1());
        boxSolvingMethodPanel.add(solvingMethod);
       // ramka.add(solvingMethod,BorderLayout.CENTER);
    }

    static String BoxMethodCom1(){
        return "Tutaj dajesz tekst który chcesz żeby był wskazówką";
    }

    static int actualMoveFieldX(){
        return 1;
    }
    static int actualMoveFieldY(){
        return 1;
    }


}
