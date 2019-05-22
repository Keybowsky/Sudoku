package Sudoku;

import javax.swing.*;
import java.awt.*;

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
        return name;
    }
}

class messages{
    //Wiadomosc Tworcy ktora pojawia sie poprzez uruchomienie odpowiedniego podmenu z panelu game
     void creatorsMessage() {

        JOptionPane creators = new JOptionPane();
        showMessageDialog(creators, "Adrian Chabowski\nAleksander Matłok\nFranciszek Przewoźny\n", "Twórcy", JOptionPane.PLAIN_MESSAGE);
    }
    //Wiadomosc ktora pojawia sie po powrocie do menu z menu gry
     void gameNotSaved() {

        JOptionPane gameNotSaved = new JOptionPane();
        showMessageDialog(gameNotSaved, "Gra nie została zapisana. Powrót do menu głównego", "Informacja", JOptionPane.PLAIN_MESSAGE);
    }

     void gameSaved() {

        JOptionPane gameSaved = new JOptionPane();
        showMessageDialog(gameSaved, "Gra została zapisana. Powrót do menu głównego", "Informacja", JOptionPane.PLAIN_MESSAGE);
    }

     void loadError(){
        JOptionPane loadError = new JOptionPane();
        showMessageDialog(loadError, "Błąd wczytywania gry. Plik nie istnieje", "Błąd", JOptionPane.PLAIN_MESSAGE);

    }
}

