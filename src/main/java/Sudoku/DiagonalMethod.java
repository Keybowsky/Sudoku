package Sudoku;

import javax.swing.*;

/** Klasa sluzy do nauczania gracza rozwiazywania sudoku metoda diagonalna. */
class DiagonalMethod extends Tutorial {

    /** Panel samouczka. */
    final JPanel diagonalSolvingMethodPanel = new JPanel();

    /** Konstruktor dodajacy mozliwosc dodawania tekstu z podpowiedziami. */
    DiagonalMethod(int langID, int themeID){
        changeVisuals(langID);
        changeVisuals(themeID);
        diagonalSolvingMethodPanel.setBackground(actualColor[2]);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(DiagonalMethod.DiagonalMethodCom1());
        diagonalSolvingMethodPanel.add(solvingMethod);
    }


    /** Tekst ktcoy wyjasnia metode. */
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
