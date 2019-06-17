package Sudoku;

import javax.swing.*;

/** Klasa sluzy do nauczania gracza rozwiazywania sudoku metoda kwadratow. */
class BoxMethod extends Tutorial {

    /** Panel samouczka. */
    final JPanel boxSolvingMethodPanel = new JPanel();

    /** Konstruktor dodajacy mozliwosc dodawania tekstu z podpowiedziami. */
    BoxMethod(int langID, int themeID){
        changeVisuals(langID);
        changeVisuals(themeID);
        boxSolvingMethodPanel.setBackground(actualColor[2]);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(BoxMethod.BoxMethodCom1());
        boxSolvingMethodPanel.add(solvingMethod);
    }

    @Override
    void firstStepTutorial(){

        for (int j=0; j<9; ++j){
            fields[8][j].setBackground(actualColor[1]);
        }
        for (int i= 0; i<9; ++i){
            fields[i][1].setBackground(actualColor[1]);
        }
        fields[7][2].setBackground(actualColor[0]);
        fields[7][2].setEditable(true);
        fields[8][7].setBackground(actualColor[0]);
        fields[1][1].setBackground(actualColor[0]);
    }

    @Override
    void nextStep() {

        for (int j = 0; j < 9; ++j) {
            fields[8][j].setBackground(actualColor[5]);
        }
        for (int i = 0; i < 9; ++i) {
            fields[i][1].setBackground(actualColor[5]);
        }
        fields[7][2].setBackground(actualColor[5]);
        fields[7][2].setEditable(false);
        fields[8][7].setBackground(actualColor[5]);
        fields[1][1].setBackground(actualColor[5]);


        fields[7][8].setBackground(actualColor[0]);
        fields[7][8].setEditable(true);
    }

    @Override
    void check() {

        int temp;
        String tempS;

        if (fields[7][8].isEditable()&&fields[7][8].getValue()==null){
            fields[7][8].setBackground(actualColor[4]);
        }
        else if(fields[7][8].isEditable()){

            tempS = String.valueOf(fields[7][8].getValue());
            temp = Integer.parseInt(tempS);
            if(temp==3)
            {EndGame wonGame = new EndGame(langID,themeID);
                EndGame.endGame.repaint();
                wonGame.endGame.setVisible(true);
                frameGame.setEnabled(false);}
            else{fields[7][8].setBackground(actualColor[4]);}
        }

        if (fields[7][2].isEditable()&&fields[7][2].getValue()==null)
        {   fields[7][2].setBackground(actualColor[4]);
        }
        else if (fields[7][2].isEditable()){
            tempS = String.valueOf(fields[7][2].getValue());
            temp = Integer.parseInt(tempS);

            if (temp==1) {
                nextStep();}
            else{fields[7][2].setBackground(actualColor[4]);}
        }
    }

    /** Tekst ktory wyjasnia metode. */
    @Override
    String methodText(){
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
