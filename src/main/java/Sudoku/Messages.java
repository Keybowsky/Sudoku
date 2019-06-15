package Sudoku;

import javax.swing.*;

import static Sudoku.GUI.actualLang;
import static javax.swing.JOptionPane.showMessageDialog;

/** Klasa sluzy do pokazywania wiadomosci dla uzytkownika. */
class Messages{

    /** Wyswietla wiadomosc o tworcach gry. */
    void creatorsMessage() {
        JOptionPane creators = new JOptionPane();
        showMessageDialog(creators, "Adrian Chabowski\nAleksander Matłok\nFranciszek Przewoźny\n", actualLang[4], JOptionPane.PLAIN_MESSAGE);
    }

    /** Wyswietla wiadomosc o wyjsciu z gry bez zapisania stanu gry. */
    static void gameNotSaved() {
        JOptionPane gameNotSaved = new JOptionPane();
        showMessageDialog(gameNotSaved, actualLang[20], actualLang[5], JOptionPane.PLAIN_MESSAGE);
    }

    /** Wyswietla wiadomosc o zapisaniu stanu gry. */
    void gameSaved() {
        JOptionPane gameSaved = new JOptionPane();
        showMessageDialog(gameSaved, actualLang[21], actualLang[5], JOptionPane.PLAIN_MESSAGE);
    }

    /** Wyswietla wiadomosc o bledzie wczytywania gry. */
    static void loadError(){
        JOptionPane loadError = new JOptionPane();
        showMessageDialog(loadError, actualLang[22], actualLang[6], JOptionPane.PLAIN_MESSAGE);
    }

    /** Wyswietla wiadomosc o bledzie zapisu gry. */
    void saveError() {

        JOptionPane gameNotSaved = new JOptionPane();
        showMessageDialog(gameNotSaved, actualLang[28], actualLang[6], JOptionPane.PLAIN_MESSAGE);
    }

}