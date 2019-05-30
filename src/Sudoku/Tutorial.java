package Sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Tutorial extends GUI {
    private final Action DiagonalMethodAction = new DiagonalMethodAction();
    private final Action RandomMethodAction = new RandomMethodAction();
    private final Action BoxMethodAction = new BoxMethodAction();
    private JFrame tutorialFrame;

    Tutorial() {
        tutorialFrame = new JFrame("Wybór samouczka");
        tutorialFrame.setMaximumSize(new Dimension(450, 200));
        tutorialFrame.setMinimumSize(new Dimension(450, 200));
        tutorialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tutorialFrame.setLocationRelativeTo(null);
        tutorialFrame.setVisible(true);
        newGameOptionFrame.setVisible(false);
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel labelTop = new JLabel("Wybierz sposób rozwiązywania, który chcesz się nauczyć:");
        labelTop.setHorizontalAlignment(SwingConstants.CENTER);
        labelTop.setVerticalAlignment(SwingConstants.CENTER);

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        // gbc.ipady = 20;
        //gbc.ipadx = 3;


        rootPanel.add(labelTop, gbc);


        JButton boxMethodBTN = new JButton();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 5;
        gbc.ipady = 10;


        rootPanel.add(boxMethodBTN, gbc);


        JButton diagonalMethodBTN = new JButton();

        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridy = 1;
        gbc.ipadx = 5;
        gbc.ipady = 10;


        rootPanel.add(diagonalMethodBTN, gbc);


        JButton randomMethodBTN = new JButton();

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

        boxMethodBTN.addActionListener(e -> {
        });

        boxMethodBTN.setAction(BoxMethodAction);

        diagonalMethodBTN.addActionListener(e -> {
        });
        diagonalMethodBTN.setAction(DiagonalMethodAction);

        randomMethodBTN.addActionListener(e -> {
        });
        randomMethodBTN.setAction(RandomMethodAction);


        boxMethodBTN.setText("boxMethodBTN");
        diagonalMethodBTN.setText("diagonalMethodBTN");
        randomMethodBTN.setText("randomMethodBTN");

    }

    private class BoxMethodAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
         new BoxMethod();
         tutorialFrame.setVisible(false);
        }
    }
    private class DiagonalMethodAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
        new DiagonalMethod();
        tutorialFrame.setVisible(false);
        }
    }
    private class RandomMethodAction extends AbstractAction{
        @Override
        public void actionPerformed(ActionEvent e) {
        new RandomMethod();
        tutorialFrame.setVisible(false);
        }
    }


}
