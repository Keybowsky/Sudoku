package Sudoku;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuLayout {

    public static JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenuGameType, submenuGameDifficulty;
        JMenuItem menuItemEasy,menuItemMedium ,menuItemHard;

        menuBar = new JMenuBar();
        menu = new JMenu("Gra");
        menuBar.add(menu);

        submenuGameType = new JMenu("Typ gry");
        submenuGameType.setMnemonic(KeyEvent.VK_S);


        menu.add(submenuGameType);

        menu.addSeparator();
        submenuGameDifficulty = new JMenu("Poziom trudności");
        submenuGameDifficulty.setMnemonic(KeyEvent.VK_S);

        menuItemEasy = new JMenuItem("Łatwy");
        submenuGameDifficulty.add(menuItemEasy);
        menuItemEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });


        menuItemMedium = new JMenuItem("Średni");
        submenuGameDifficulty.add(menuItemMedium);
        menuItemMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        menuItemHard =new JMenuItem("Trudny");
        submenuGameDifficulty.add(menuItemHard);
        menuItemHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        menu.add(submenuGameDifficulty);

        menu = new JMenu("Info");
        menuBar.add(menu);

        return menuBar;
    }

    public static Container menuItSelf() {

        JLabel name;
        JButton newGame, loadGame, settings, exitGame;


        JPanel rootPanel = new JPanel(new BorderLayout(5,50));
        JPanel leftSpacer = new JPanel(new BorderLayout());
        JPanel rightSpacer = new JPanel(new BorderLayout());

        name = new JLabel("SUDOKU 6000");
        name.setFont(new Font("Arial", Font.BOLD, 70));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);
        newGame = new JButton("Nowa gra");
        loadGame = new JButton("Wczytaj grę");
        settings = new JButton("Ustawienia");
        exitGame = new JButton("Wyjdź z gry");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(newGame);
        buttonPanel.add(loadGame);
        buttonPanel.add(settings);
        buttonPanel.add(exitGame);

        JPanel mainPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        mainPanel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 100;
        mainPanel.add(name, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(leftSpacer,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(buttonPanel,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        mainPanel.add(rightSpacer,gbc);

        rootPanel.add(mainPanel,BorderLayout.CENTER);
        Dimension buttonSize = new Dimension(200,50);
        newGame.setMinimumSize(buttonSize);
        newGame.setPreferredSize(buttonSize);
        loadGame.setMinimumSize(buttonSize);
        loadGame.setPreferredSize(buttonSize);
        settings.setMinimumSize(buttonSize);
        settings.setPreferredSize(buttonSize);
        exitGame.setMinimumSize(buttonSize);
        exitGame.setPreferredSize(buttonSize);

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return rootPanel;
    }


    public static void menuWindow() {

        JFrame frame = new JFrame("SUDOKU 6000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar insert = new MenuBar();
        frame.setJMenuBar(createMenuBar());
        frame.setContentPane(menuItSelf());

        frame.setMaximumSize(new Dimension(630,630));
        frame.setMinimumSize(new Dimension(630,630));
        frame.setVisible(true);
    }
    public static void gameWindow(){
        JFrame frame = new JFrame("SUDOKU 6000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar insert = new MenuBar();
        frame.setJMenuBar(createMenuBar());
        frame.setContentPane(GameLayout.gameIsSelf());


        frame.setMaximumSize(new Dimension(630,630));
        frame.setMinimumSize(new Dimension(630,630));
        frame.setVisible(true);

    }

}
