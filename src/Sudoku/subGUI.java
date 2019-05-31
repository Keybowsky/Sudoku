package Sudoku;

import javax.swing.*;
import java.awt.*;

import static Sudoku.GUI.*;
import static javax.swing.JOptionPane.showMessageDialog;
import Sudoku.GUI.*;


public class subGUI extends GUI{
    subGUI(){}
}

class gameName {
    //To jest etykieta ktora pojawia sie w panelach menu i game
    JLabel gameName() {
        JLabel name = new JLabel("SUDOKU 6000");
        name.setFont(new Font("Arial", Font.BOLD, 70));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        name.setForeground(buttonColor);
        return name;
    }
}

class messages{
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

     void loadError(){
        JOptionPane loadError = new JOptionPane();
        showMessageDialog(loadError, actualLang[22], actualLang[6], JOptionPane.PLAIN_MESSAGE);

    }
}

