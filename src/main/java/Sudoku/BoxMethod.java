package Sudoku;

import javax.swing.*;

/** Klasa sluzy do nauczania gracza rozwiazywania sudoku metoda kwadratow. */
class BoxMethod extends Tutorial {

    /** Panel samouczka. */
    final JPanel boxSolvingMethodPanel = new JPanel();

    /** Konstruktor dodajacy mozliwosc dodawania tekstu z podpowiedziami. */
    BoxMethod(int langID, int themeID){

        boxSolvingMethodPanel.setBackground(actualColor[2]);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(BoxMethod.BoxMethodCom1());
        boxSolvingMethodPanel.add(solvingMethod);
    }


    /** Tekst ktory wyjasnia metode. */
    static String BoxMethodCom1(){
        return "<html><body><br><br><br>" +
                "Metoda - jedyne pole<br>" +
                "na cyfrę w kwadracie <br><br><br>" +
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
