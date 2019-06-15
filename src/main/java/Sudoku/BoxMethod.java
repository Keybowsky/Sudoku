package Sudoku;

import javax.swing.*;

class BoxMethod extends Tutorial {


    final JPanel boxSolvingMethodPanel = new JPanel();

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

    BoxMethod(int langID, int themeID){
    //wywalić themeID


        boxSolvingMethodPanel.setBackground(actualColor[2]);
        //boxSolvingMethodPanel.setPreferredSize(tutorialPanelSize);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(BoxMethod.BoxMethodCom1());
        boxSolvingMethodPanel.add(solvingMethod);


    }


    static String BoxMethodCom1(){
        return "<html><body><br><br><br><br><br>Metoda - jedyne pole<br>" +
                "na cyfrę w kwadracie <br><br>" +
                "Analizujemy planszę <br>" +
                "badając cyfra po cyfrze <br>" +
                "w obrębie kwadratu,<br>" +
                "sprawdzając czy cyfra<br>" +
                " może wystąpić tylko <br>" +
                "w jednym polu kwadratu. " +
                "<br><br><br><br><br><br>" +
                "Wpisz prawidłową cyfrę<br>" +
                "w zaznaczone pole<br>" +
                "i naciśnij przycisk sprawdź<br><br>" +
                "Krok 1: W zaznaczonym polu<br> " +
                "możemy wpisać 1<br>" +
                "Krok 2: Sam spróbuj znaleźć <br>" +
                "liczbę pasującą do pola<br><br></body></html>";

    }



}
