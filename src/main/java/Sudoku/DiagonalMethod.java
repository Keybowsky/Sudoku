package Sudoku;

import javax.swing.*;

class DiagonalMethod extends Tutorial {

    final JPanel diagonalSolvingMethodPanel = new JPanel();



    DiagonalMethod(int langID, int themeID){

        diagonalSolvingMethodPanel.setBackground(actualColor[2]);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(DiagonalMethod.DiagonalMethodCom1());
        diagonalSolvingMethodPanel.add(solvingMethod);


    }

    static String DiagonalMethodCom1(){
        return "<html><body><br><br><br>" +
                "Metoda - jedyne pole <br>" +
                "na cyfrę w linii <br><br><br>" +
                "Analizujemy planszę<br>" +
                "badając cyfra po cyfrze<br>" +
                "w każdej linii<br>" +
                "(poziomej i pionowej),<br>" +
                "sprawdzając czy cyfra<br>" +
                "może wystąpić tylko<br>" +
                "w jednym polu w linii.<br> "+
                "<br><br><br><br><br><br>" +
                "Wpisz prawidłową cyfrę<br>" +
                "w zaznaczone pole<br>" +
                "i naciśnij przycisk sprawdź<br><br>" +
                "Krok 1: W zaznaczonym polu<br> " +
                "możemy wpisać 2<br>" +
                "Krok 2: Sam spróbuj znaleźć <br>" +
                "liczbę pasującą do pola<br><br></body></html>";
    }
}
