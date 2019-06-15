package Sudoku;

import javax.swing.*;

/** Klasa służy do nauczania gracza rozwiązywania sudoku metodą losową. */
class RandomMethod extends Tutorial{

    /** Panel samouczka. */
    final JPanel randomSolvingMethodPanel = new JPanel();

    /** Konstruktor dodający możliwość dodawania tekstu z podpowiedziami. */
    RandomMethod(int langID, int themeID){

        randomSolvingMethodPanel.setBackground(actualColor[2]);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(RandomMethod.RandomMethodCom1());
        randomSolvingMethodPanel.add(solvingMethod);

    }

    /** Tekst który wyjaśnia metodę. */
    static String RandomMethodCom1(){
        return  "<html><body><br><br><br>" +
                "Metoda - <br>" +
                "pojedyncza cyfra w polu<br><br><br>"+
                "Analizujemy planszę<br>" +
                "pole po polu,<br>"+
                "sprawdzając czy pole<br>"+
                "może zawierać nie więcej<br>" +
                "niż jedną cyfrę.<br>"+
                "<br><br><br><br><br><br>" +
                "Wpisz prawidłową cyfrę<br>" +
                "w zaznaczone pole<br>" +
                "i naciśnij przycisk sprawdź<br><br>" +
                "Krok 1: W zaznaczonym polu<br> " +
                "możemy wpisać 5<br>" +
                "Krok 2: Sam spróbuj znaleźć <br>" +
                "liczbę pasującą do pola<br><br></body></html>";
    }
}
