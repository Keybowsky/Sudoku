package Sudoku;

import javax.swing.*;

/** Klasa sluzy do nauczania gracza rozwiazywania sudoku metoda losowa. */
class RandomMethod extends Tutorial{

    /** Panel samouczka. */
    final JPanel randomSolvingMethodPanel = new JPanel();

    /** Konstruktor dodajacy mozliwosc dodawania tekstu z podpowiedziami. */
    RandomMethod(int langID, int themeID){
        changeVisuals(langID);
        changeVisuals(themeID);
        randomSolvingMethodPanel.setBackground(actualColor[2]);
        JLabel solvingMethod = new JLabel();
        solvingMethod.setText(RandomMethod.RandomMethodCom1());
        randomSolvingMethodPanel.add(solvingMethod);

    }

    @Override
    void firstStepTutorial() {

        for (int i= 0; i<9; ++i){
            fields[i][5].setBackground(actualColor[1]);
        }
        for (int j= 0; j<9; ++j){
            fields[1][j].setBackground(actualColor[1]);
        }

        fields[1][5].setBackground(actualColor[0]);
        fields[1][5].setEditable(true);
    }

    @Override
    void nextStep() {
        for (int i= 0; i<9; ++i){
            fields[i][5].setBackground(actualColor[5]);
        }
        for (int j= 0; j<9; ++j){
            fields[1][j].setBackground(actualColor[5]);
        }

        fields[1][5].setBackground(actualColor[5]);
        fields[1][5].setEditable(false);

        fields[8][3].setBackground(actualColor[0]);
        fields[8][3].setEditable(true);
    }

    @Override
    void check() {
        int temp;
        String tempS;

        if (fields[8][3].isEditable()&&fields[8][3].getValue()==null){
            fields[8][3].setBackground(actualColor[4]);
        }
        else if(fields[8][3].isEditable()){

            tempS = String.valueOf(fields[8][3].getValue());
            temp = Integer.parseInt(tempS);
            if(temp==3)
            {EndGame wonGame = new EndGame(langID,themeID);
                EndGame.endGame.repaint();
                wonGame.endGame.setVisible(true);
                frameGame.setEnabled(false);}
            else{fields[8][3].setBackground(actualColor[4]);}
        }

        if (fields[1][5].isEditable()&&fields[1][5].getValue()==null)
        {   fields[1][5].setBackground(actualColor[4]);
        }
        else if (fields[1][5].isEditable()){
            tempS = String.valueOf(fields[1][5].getValue());
            temp = Integer.parseInt(tempS);

            if (temp==5) {
                nextStep();}
            else{fields[1][5].setBackground(actualColor[4]);}
        }
    }

    /** Tekst ktory wyjasnia metode. */
    @Override
    String methodText(){
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
