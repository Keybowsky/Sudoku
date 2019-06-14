package Sudoku;

import javax.swing.*;

import java.awt.*;

import static Sudoku.GUI.actualLang;
import static javax.swing.JOptionPane.showMessageDialog;

/** Klasa służy do pokazywania wiadomości dla użytkownika. */
class Messages{

    /** Wyświetla wiadomość o twórcach gry. */
    void creatorsMessage() {
        JOptionPane creators = new JOptionPane();
        showMessageDialog(creators, "Adrian Chabowski\nAleksander Matłok\nFranciszek Przewoźny\n", actualLang[4], JOptionPane.PLAIN_MESSAGE);
    }

    /** Wyświetla wiadomość o wyjściu z gry bez zapisania stanu gry. */
    static void gameNotSaved() {
        JOptionPane gameNotSaved = new JOptionPane();
        showMessageDialog(gameNotSaved, actualLang[20], actualLang[5], JOptionPane.PLAIN_MESSAGE);
    }

    /** Wyświetla wiadomość o zapisaniu stanu gry. */
    void gameSaved() {
        JOptionPane gameSaved = new JOptionPane();
        showMessageDialog(gameSaved, actualLang[21], actualLang[5], JOptionPane.PLAIN_MESSAGE);
    }

    /** Wyświetla wiadomość o błędzie wczytywania gry. */
    static void loadError(){
        JOptionPane loadError = new JOptionPane();
        showMessageDialog(loadError, actualLang[22], actualLang[6], JOptionPane.PLAIN_MESSAGE);
    }

    /** Wyświetla wiadomość o błędzie zapisu gry. */
    void saveError() {

        JOptionPane gameNotSaved = new JOptionPane();
        showMessageDialog(gameNotSaved, actualLang[28], actualLang[6], JOptionPane.PLAIN_MESSAGE);
    }

}