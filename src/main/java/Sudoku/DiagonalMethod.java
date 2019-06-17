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

    @Override
    void firstStepTutorial(){

        for (int i= 0; i<9; ++i){
            fields[i][7].setBackground(actualColor[1]);
        }
        for (int j= 0; j<9; ++j){
            fields[7][j].setBackground(actualColor[1]);
        }

        fields[6][7].setBackground(actualColor[0]);
        fields[6][7].setEditable(true);
        fields[7][4].setBackground(actualColor[0]);
    }

    @Override
    void nextStep() {
        for (int i = 0; i < 9; ++i) {
            fields[i][7].setBackground(actualColor[5]);
        }
        for (int j = 0; j < 9; ++j) {
            fields[7][j].setBackground(actualColor[5]);
        }

        fields[6][7].setBackground(actualColor[5]);
        fields[6][7].setEditable(false);
        fields[7][4].setBackground(actualColor[5]);

        fields[1][6].setBackground(actualColor[0]);
        fields[1][6].setEditable(true);
    }

    @Override
    void check() {
        int temp;
        String tempS;

        if (fields[1][6].isEditable()&&fields[1][6].getValue()==null){
            fields[1][6].setBackground(actualColor[4]);
        }
        else if(fields[1][6].isEditable()){

            tempS = String.valueOf(fields[1][6].getValue());
            temp = Integer.parseInt(tempS);
            if(temp==3)
            {EndGame wonGame = new EndGame(langID,themeID);
                EndGame.endGame.repaint();
                wonGame.endGame.setVisible(true);
                frameGame.setEnabled(false);}
            else{fields[1][6].setBackground(actualColor[4]);}
        }

        if (fields[6][7].isEditable()&&fields[6][7].getValue()==null)
        {   fields[6][7].setBackground(actualColor[4]);
        }
        else if (fields[6][7].isEditable()){
            tempS = String.valueOf(fields[6][7].getValue());
            temp = Integer.parseInt(tempS);

            if (temp==2) {
                nextStep();}
            else{fields[6][7].setBackground(actualColor[4]);}
        }
    }

    /** Tekst ktcoy wyjasnia metode. */
    @Override
    String methodText(){
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
