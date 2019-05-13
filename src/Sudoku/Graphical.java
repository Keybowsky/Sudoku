package Sudoku;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.text.MaskFormatter;

public class Graphical {

    private static JMenuBar createMenuBar() {
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

    private static Container menuItSelf() {

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
        mainPanel.setLayout(new GridBagLayout());
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

    private static Container gameIsSelf() {




        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("#");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.setValidCharacters("0123456789");

        //paczka 11

        JFormattedTextField field11 = new JFormattedTextField(formatter);
        field11.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field12 = new JFormattedTextField(formatter);
        JFormattedTextField field13 = new JFormattedTextField(formatter);
        JFormattedTextField field21 = new JFormattedTextField(formatter);
        JFormattedTextField field22 = new JFormattedTextField(formatter);
        JFormattedTextField field23 = new JFormattedTextField(formatter);
        JFormattedTextField field31 = new JFormattedTextField(formatter);
        JFormattedTextField field32 = new JFormattedTextField(formatter);
        JFormattedTextField field33 = new JFormattedTextField(formatter);

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setSize(100,100);
        buttonPanel1.setLayout(new GridLayout(3,3));
        buttonPanel1.add(field11);
        buttonPanel1.add(field12);
        buttonPanel1.add(field13);
        buttonPanel1.add(field21);
        buttonPanel1.add(field22);
        buttonPanel1.add(field23);
        buttonPanel1.add(field31);
        buttonPanel1.add(field32);
        buttonPanel1.add(field33);

        //paczka 12

        JFormattedTextField field14 = new JFormattedTextField(formatter);
        field14.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field15 = new JFormattedTextField(formatter);
        JFormattedTextField field16 = new JFormattedTextField(formatter);
        JFormattedTextField field24 = new JFormattedTextField(formatter);
        JFormattedTextField field25 = new JFormattedTextField(formatter);
        JFormattedTextField field26 = new JFormattedTextField(formatter);
        JFormattedTextField field34 = new JFormattedTextField(formatter);
        JFormattedTextField field35 = new JFormattedTextField(formatter);
        JFormattedTextField field36 = new JFormattedTextField(formatter);


        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setSize(100,100);
        buttonPanel2.setLayout(new GridLayout(3,3));
        buttonPanel2.add(field14);
        buttonPanel2.add(field15);
        buttonPanel2.add(field16);
        buttonPanel2.add(field24);
        buttonPanel2.add(field25);
        buttonPanel2.add(field26);
        buttonPanel2.add(field34);
        buttonPanel2.add(field35);
        buttonPanel2.add(field36);

        //paczka 13

        JFormattedTextField field17 = new JFormattedTextField(formatter);
        field14.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field18 = new JFormattedTextField(formatter);
        JFormattedTextField field19 = new JFormattedTextField(formatter);
        JFormattedTextField field27 = new JFormattedTextField(formatter);
        JFormattedTextField field28 = new JFormattedTextField(formatter);
        JFormattedTextField field29 = new JFormattedTextField(formatter);
        JFormattedTextField field37 = new JFormattedTextField(formatter);
        JFormattedTextField field38 = new JFormattedTextField(formatter);
        JFormattedTextField field39 = new JFormattedTextField(formatter);

        JPanel buttonPanel3 = new JPanel();
        buttonPanel3.setSize(100,100);
        buttonPanel3.setLayout(new GridLayout(3,3));
        buttonPanel3.add(field17);
        field17.setPreferredSize(new Dimension(20,20));
        buttonPanel3.add(field18);
        buttonPanel3.add(field19);
        buttonPanel3.add(field27);
        buttonPanel3.add(field28);
        buttonPanel3.add(field29);
        buttonPanel3.add(field37);
        buttonPanel3.add(field38);
        buttonPanel3.add(field39);

        //paczka 21

        JFormattedTextField field41 = new JFormattedTextField(formatter);
        field41.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field42 = new JFormattedTextField(formatter);
        JFormattedTextField field43 = new JFormattedTextField(formatter);
        JFormattedTextField field51 = new JFormattedTextField(formatter);
        JFormattedTextField field52 = new JFormattedTextField(formatter);
        JFormattedTextField field53 = new JFormattedTextField(formatter);
        JFormattedTextField field61 = new JFormattedTextField(formatter);
        JFormattedTextField field62 = new JFormattedTextField(formatter);
        JFormattedTextField field63 = new JFormattedTextField(formatter);

        JPanel buttonPanel4 = new JPanel();
        buttonPanel4.setSize(100,100);
        buttonPanel4.setLayout(new GridLayout(3,3));
        buttonPanel4.add(field41);
        buttonPanel4.add(field42);
        buttonPanel4.add(field43);
        buttonPanel4.add(field51);
        buttonPanel4.add(field52);
        buttonPanel4.add(field53);
        buttonPanel4.add(field61);
        buttonPanel4.add(field62);
        buttonPanel4.add(field63);

        //paczka 22

        JFormattedTextField field44 = new JFormattedTextField(formatter);
        field44.setPreferredSize(new Dimension(20,20));
        JFormattedTextField field45 = new JFormattedTextField(formatter);
        JFormattedTextField field46 = new JFormattedTextField(formatter);
        JFormattedTextField field54 = new JFormattedTextField(formatter);
        JFormattedTextField field55 = new JFormattedTextField(formatter);
        JFormattedTextField field56 = new JFormattedTextField(formatter);
        JFormattedTextField field64 = new JFormattedTextField(formatter);
        JFormattedTextField field65 = new JFormattedTextField(formatter);
        JFormattedTextField field66 = new JFormattedTextField(formatter);

        JPanel buttonPanel5 = new JPanel();
        buttonPanel5.setSize(100,100);
        buttonPanel5.setLayout(new GridLayout(3,3));
        buttonPanel5.add(field44);
        buttonPanel5.add(field45);
        buttonPanel5.add(field46);
        buttonPanel5.add(field54);
        buttonPanel5.add(field55);
        buttonPanel5.add(field56);
        buttonPanel5.add(field64);
        buttonPanel5.add(field65);
        buttonPanel5.add(field66);




        buttonPanel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15 , 15, 15, 15)));
        buttonPanel2.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        buttonPanel3.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        buttonPanel4.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        buttonPanel5.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
/*

        FocusListener f11 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
            System.out.println(field11.getValue());
            }
        };
        FocusListener f12 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                System.out.println(field12.getValue());
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println(field12.getValue());
            }
        };
        FocusListener f13 = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println(field13.getValue());
            }
        };


        field11.addFocusListener(f13);
        field12.addFocusListener(f11);
        field13.addFocusListener(f12);




*/



        JPanel rootPanel = new JPanel();


        rootPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        //  gbc.ipady = 100;
        rootPanel.add(buttonPanel1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        rootPanel.add(buttonPanel2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        rootPanel.add(buttonPanel3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        rootPanel.add(buttonPanel4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        rootPanel.add(buttonPanel5, gbc);
/*
        gbc.gridx = 2;
        gbc.gridy = 1;
        rootPanel.add(buttonPanel6, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        rootPanel.add(buttonPanel7, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        rootPanel.add(buttonPanel8, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        rootPanel.add(buttonPanel9, gbc);



 */



        return rootPanel;
    }


    protected static void menuWindow() {

        JFrame frame = new JFrame("SUDOKU 6000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar insert = new MenuBar();
        frame.setJMenuBar(createMenuBar());
        frame.setContentPane(menuItSelf());

        frame.setMaximumSize(new Dimension(630,630));
        frame.setMinimumSize(new Dimension(630,630));
        frame.setVisible(true);
    }
    protected static void gameWindow(){
        JFrame frame = new JFrame("SUDOKU 6000");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MenuBar insert = new MenuBar();
        frame.setJMenuBar(createMenuBar());
        frame.setContentPane(gameIsSelf());


        frame.setMaximumSize(new Dimension(630,630));
        frame.setMinimumSize(new Dimension(630,630));
        frame.setVisible(true);

    }

}
