package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


class Tutorial extends GUI {
    private JFrame tutorialFrame;


    Tutorial(char langID, int themeID) {
        changeVisuals(themeID);
        changeVisuals(langID);

        tutorialFrame = new JFrame("Wybór samouczka");
        tutorialFrame.setMaximumSize(new Dimension(450, 200));
        tutorialFrame.setMinimumSize(new Dimension(450, 200));
        tutorialFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        tutorialFrame.setLocationRelativeTo(null);
        tutorialFrame.setVisible(true);
        newGameOptionFrame.setVisible(false);
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel labelTop = new JLabel(actualLang[27]);
        labelTop.setHorizontalAlignment(SwingConstants.CENTER);
        labelTop.setVerticalAlignment(SwingConstants.CENTER);


        rootPanel.setBackground(actualColor[2]);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        rootPanel.add(labelTop, gbc);


        JButton boxMethodBTN = new JButton();
        boxMethodBTN.setBackground(actualColor[4]);
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 5;
        gbc.ipady = 10;


        rootPanel.add(boxMethodBTN, gbc);


        JButton diagonalMethodBTN = new JButton();
        diagonalMethodBTN.setBackground(actualColor[4]);
        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridy = 1;
        gbc.ipadx = 5;


        rootPanel.add(diagonalMethodBTN, gbc);


        JButton randomMethodBTN = new JButton();
        randomMethodBTN.setBackground(actualColor[4]);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridy = 1;
        gbc.ipadx = 5;
        gbc.ipady = 10;


        rootPanel.add(randomMethodBTN, gbc);

        tutorialFrame.add(rootPanel);


         final Action DiagonalMethodAction = new DiagonalMethodAction();
         final Action RandomMethodAction = new RandomMethodAction();
         final Action BoxMethodAction = new BoxMethodAction();

        boxMethodBTN.addActionListener(e -> {
        });

        boxMethodBTN.setAction(BoxMethodAction);

        diagonalMethodBTN.addActionListener(e -> {
        });
        diagonalMethodBTN.setAction(DiagonalMethodAction);

        randomMethodBTN.addActionListener(e -> {
        });
        randomMethodBTN.setAction(RandomMethodAction);


        boxMethodBTN.setText(actualLang[29]);
        diagonalMethodBTN.setText(actualLang[30]);
        randomMethodBTN.setText(actualLang[31]);

    }

    Tutorial() {
    }

    public static final int[][] tutorialFieldsValue = {
            {0, 9, 4, 0, 3, 0, 1, 5, 0},
            {8, 1, 2, 7, 0, 0, 0, 9, 6},
            {3, 0, 0, 1, 9, 0, 0, 8, 0},
            {0, 3, 0, 9, 0, 4, 6, 7, 0},
            {0, 0, 8, 6, 1, 3, 0, 4, 9},
            {0, 0, 6, 2, 0, 0, 0, 3, 1},
            {4, 0, 3, 5, 0, 0, 0, 0, 8},
            {5, 0, 0, 0, 2, 0, 7, 0, 0},
            {0, 6, 0, 0, 0, 8, 4, 1, 5},
    };


    private class BoxMethodAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
         new BoxMethod(langID,themeID);
            tutorialFrame.setVisible(false);
            gameItSelf(0,2);
            frameGame.setVisible(true);

        }
    }
    private class DiagonalMethodAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
        new DiagonalMethod(langID,themeID);
            tutorialFrame.setVisible(false);
            gameItSelf(0,3);
            frameGame.setVisible(true);
        }
    }
    private class RandomMethodAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
        new RandomMethod(langID,themeID);
            tutorialFrame.setVisible(false);
            gameItSelf(0,4);
            frameGame.setVisible(true);
        }
    }


}
