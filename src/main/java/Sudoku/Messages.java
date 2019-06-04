package Sudoku;

import javax.swing.*;

import static Sudoku.GUI.actualLang;
import static javax.swing.JOptionPane.showMessageDialog;

class Messages{
    //Wiadomosc Tworcy ktora pojawia sie poprzez uruchomienie odpowiedniego podmenu z panelu game
    void creatorsMessage() {
        JOptionPane creators = new JOptionPane();
        showMessageDialog(creators, "Adrian Chabowski\nAleksander Matłok\nFranciszek Przewoźny\n", actualLang[4], JOptionPane.PLAIN_MESSAGE);
    }
    //Wiadomosc ktora pojawia sie po powrocie do menu z menu gry
    void gameNotSaved() {

        JOptionPane gameNotSaved = new JOptionPane();
        showMessageDialog(gameNotSaved, actualLang[20], actualLang[5], JOptionPane.PLAIN_MESSAGE);
    }

    void gameSaved() {

        JOptionPane gameSaved = new JOptionPane();
        showMessageDialog(gameSaved, actualLang[21], actualLang[5], JOptionPane.PLAIN_MESSAGE);
    }

    static void loadError(){
        JOptionPane loadError = new JOptionPane();
        showMessageDialog(loadError, actualLang[22], actualLang[6], JOptionPane.PLAIN_MESSAGE);

    }
}