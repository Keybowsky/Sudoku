package Sudoku;

import javax.swing.*;

import java.awt.*;
import static Sudoku.GUI.*;

public class EndGame {
    final static JFrame endGame = new JFrame();

   public EndGame(char langID, int themeID){
       GridBagConstraints gbc = new GridBagConstraints();
       JLabel gameWonLabel = new JLabel();
       JButton gameWonOkButton = new JButton();
       JPanel rootPanel = new JPanel();

       changeVisuals(langID);
       changeVisuals(themeID);
       endGame.repaint();
       endGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       endGame.setBackground(actualColor[2]);
       endGame.setTitle(actualLang[32]);
       endGame.setMinimumSize(GUI.smallMinimumWindow);
       endGame.setMaximumSize(GUI.smallMaximumWindow);
       endGame.setLocationRelativeTo(null);

       gameWonLabel.setText(actualLang[33]);
       gameWonLabel.setFont(new Font("Verdana", Font.BOLD, 20));
       gameWonOkButton.setText(actualLang[17]);
       gameWonOkButton.setBackground(actualColor[4]);
       rootPanel.setLayout(new GridBagLayout());
       gbc.gridx = 0;
       gbc.gridy = 0;
       gbc.weighty = 1;
       rootPanel.add(gameWonLabel,gbc);

       gbc.gridy = 1;
       rootPanel.add(gameWonOkButton,gbc);

       endGame.add(rootPanel);

       gameWonOkButton.addActionListener(e -> {
           endGame.setVisible(false);
           frameGame.setEnabled(true);
           frameGame.setVisible(false);
           frameMenu.setVisible(true);
       });

        gameWonOkButton.setText(actualLang[17]);
    }

}
