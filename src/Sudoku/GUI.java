package Sudoku;


import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import static javax.swing.JOptionPane.showMessageDialog;


class GUI {

    static JFrame frameMenu;
    private static JFrame frameGame;
    private final Action newGameAction = new newGameAction();
    private final Action loadGameAction = new loadGameAction();
    private final Action settingsAction = new settingsAction();
    private final Action exitGameAction = new exitGameAction();
    private final Action menuItemBackMainAction = new menuItemBackMainAction();

    GUI() {

        menuItSelf();
        gameIsSelf();
    }



    private JLabel gameName() {
        JLabel name = new JLabel("SUDOKU 6000");
        name.setFont(new Font("Arial", Font.BOLD, 70));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);


        return name;
    }

    private void creatorsMessage() {

        JOptionPane creators = new JOptionPane();
        showMessageDialog(creators, "Adrian Chabowski\n Aleksander Matłok\n Franciszek Przewoźny\n", "Twórcy", JOptionPane.PLAIN_MESSAGE);
    }

    private void newGameSelectDifficultyMessage(){

        JOptionPane newGameSelectDifficultyMessage = new JOptionPane();
        Object[] options = {"Trudny","Średni","Łatwy"};
        int n = JOptionPane.showOptionDialog(newGameSelectDifficultyMessage, "Wybierz poziom trudności:", "Nowa Gra", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        //TODO-Franek Wypełnianie w zależności od wybranej trudności
        if(n==JOptionPane.YES_OPTION){

        }
        if(n==JOptionPane.NO_OPTION){

        }
        if(n==JOptionPane.CANCEL_OPTION){

        }
    }

    private void gameNotSaved() {

        JOptionPane gameNotSaved = new JOptionPane();
        showMessageDialog(gameNotSaved, "Gra nie została zapisana. Powrót do menu głównego", "Informacja", JOptionPane.PLAIN_MESSAGE);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenuGameType, submenuGameDifficulty;
        JMenuItem menuItemEasy, menuItemMedium, menuItemHard, menuItemTutorial, menuItemNormal, menuItemCreators, menuItemBackMain;

        menuBar = new JMenuBar();
        menu = new JMenu("Gra");
        menuBar.add(menu);

        menuItemBackMain = new JMenuItem();

        menuItemBackMain.addActionListener(e -> { });
        menuItemBackMain.setAction(menuItemBackMainAction);

        menu.add(menuItemBackMain);

        menu.addSeparator();

        submenuGameType = new JMenu("Typ gry");
        submenuGameType.setMnemonic(KeyEvent.VK_S);

        menuItemTutorial = new JMenuItem("Samouczek");
        submenuGameType.add(menuItemTutorial);

        menuItemNormal = new JMenuItem("Normalna gra");
        submenuGameType.add(menuItemNormal);


        menu.add(submenuGameType);

        //TODO-Franek Wypełnianie w zależności od wybranej trudności(z menubar)

        menu.addSeparator();
        submenuGameDifficulty = new JMenu("Poziom trudności");
        submenuGameDifficulty.setMnemonic(KeyEvent.VK_S);

        menuItemEasy = new JMenuItem("Łatwy");
        submenuGameDifficulty.add(menuItemEasy);
        menuItemEasy.addActionListener(e -> { });


        menuItemMedium = new JMenuItem("Średni");
        submenuGameDifficulty.add(menuItemMedium);
        menuItemMedium.addActionListener(e -> { });

        menuItemHard = new JMenuItem("Trudny");
        submenuGameDifficulty.add(menuItemHard);
        menuItemHard.addActionListener(e -> { });

        menu.add(submenuGameDifficulty);

        menu = new JMenu("Info");


        menuBar.add(menu);

        menuItemCreators = new JMenuItem("Twórcy gry");
        menuItemCreators.addActionListener(e -> creatorsMessage());

        menuItemBackMain.setText("Powrót do Menu Głównego");

        menu.add(menuItemCreators);

        return menuBar;
    }

    private void menuItSelf() {

        frameMenu = new JFrame("SUDOKU");
        frameMenu.setMaximumSize(new Dimension(630,630));
        frameMenu.setMinimumSize(new Dimension(630,630));
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel rootPanel = new JPanel(new BorderLayout(5, 50));
        JPanel leftSpacer = new JPanel(new BorderLayout());
        JPanel rightSpacer = new JPanel(new BorderLayout());

        JButton newGame = new JButton("Nowa gra");
        JButton loadGame = new JButton("Wczytaj grę");
        JButton settings = new JButton("Ustawienia");
        JButton exitGame = new JButton("Wyjdź z gry");



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
        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(leftSpacer, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        mainPanel.add(buttonPanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        mainPanel.add(rightSpacer, gbc);


        Dimension buttonSize = new Dimension(200, 50);
        newGame.setMinimumSize(buttonSize);
        newGame.setPreferredSize(buttonSize);
        loadGame.setMinimumSize(buttonSize);
        loadGame.setPreferredSize(buttonSize);
        settings.setMinimumSize(buttonSize);
        settings.setPreferredSize(buttonSize);
        exitGame.setMinimumSize(buttonSize);
        exitGame.setPreferredSize(buttonSize);



        newGame.addActionListener(e -> { });
        newGame.setAction(newGameAction);

        exitGame.addActionListener(e -> { });
        exitGame.setAction(exitGameAction);

        loadGame.addActionListener(e -> { });
        loadGame.setAction(loadGameAction);

        settings.addActionListener(e -> { });
        settings.setAction(settingsAction);


        newGame.setText("Nowa gra");
        loadGame.setText("Wczytaj gre");
        settings.setText("Ustawienia");
        exitGame.setText("Wyjdź z gry");

        rootPanel.add(mainPanel, BorderLayout.CENTER);
        rootPanel.add(gameName(), BorderLayout.NORTH);
        frameMenu.setContentPane(rootPanel);


    }

    private void gameIsSelf() {

        frameGame = new JFrame("SUDOKU");
        frameGame.setMaximumSize(new Dimension(630,630));
        frameGame.setMinimumSize(new Dimension(630,630));
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("#");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.setValidCharacters("0123456789");

        int buttonPanelSize = 100;
        int fieldBoxSize = 30;

        JButton buttonCheck = new JButton("Sprawdź");


        //paczka 11

        JFormattedTextField field11 = new JFormattedTextField(formatter);
        field11.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field12 = new JFormattedTextField(formatter);
        JFormattedTextField field13 = new JFormattedTextField(formatter);
        JFormattedTextField field21 = new JFormattedTextField(formatter);
        JFormattedTextField field22 = new JFormattedTextField(formatter);
        JFormattedTextField field23 = new JFormattedTextField(formatter);
        JFormattedTextField field31 = new JFormattedTextField(formatter);
        JFormattedTextField field32 = new JFormattedTextField(formatter);
        JFormattedTextField field33 = new JFormattedTextField(formatter);

        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel1.setLayout(new GridLayout(3, 3));
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
        field14.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field15 = new JFormattedTextField(formatter);
        JFormattedTextField field16 = new JFormattedTextField(formatter);
        JFormattedTextField field24 = new JFormattedTextField(formatter);
        JFormattedTextField field25 = new JFormattedTextField(formatter);
        JFormattedTextField field26 = new JFormattedTextField(formatter);
        JFormattedTextField field34 = new JFormattedTextField(formatter);
        JFormattedTextField field35 = new JFormattedTextField(formatter);
        JFormattedTextField field36 = new JFormattedTextField(formatter);


        JPanel buttonPanel2 = new JPanel();
        buttonPanel2.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel2.setLayout(new GridLayout(3, 3));
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
        field17.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field18 = new JFormattedTextField(formatter);
        JFormattedTextField field19 = new JFormattedTextField(formatter);
        JFormattedTextField field27 = new JFormattedTextField(formatter);
        JFormattedTextField field28 = new JFormattedTextField(formatter);
        JFormattedTextField field29 = new JFormattedTextField(formatter);
        JFormattedTextField field37 = new JFormattedTextField(formatter);
        JFormattedTextField field38 = new JFormattedTextField(formatter);
        JFormattedTextField field39 = new JFormattedTextField(formatter);

        JPanel buttonPanel3 = new JPanel();
        buttonPanel3.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel3.setLayout(new GridLayout(3, 3));
        buttonPanel3.add(field17);
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
        field41.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field42 = new JFormattedTextField(formatter);
        JFormattedTextField field43 = new JFormattedTextField(formatter);
        JFormattedTextField field51 = new JFormattedTextField(formatter);
        JFormattedTextField field52 = new JFormattedTextField(formatter);
        JFormattedTextField field53 = new JFormattedTextField(formatter);
        JFormattedTextField field61 = new JFormattedTextField(formatter);
        JFormattedTextField field62 = new JFormattedTextField(formatter);
        JFormattedTextField field63 = new JFormattedTextField(formatter);

        JPanel buttonPanel4 = new JPanel();
        buttonPanel4.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel4.setLayout(new GridLayout(3, 3));
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
        field44.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field45 = new JFormattedTextField(formatter);
        JFormattedTextField field46 = new JFormattedTextField(formatter);
        JFormattedTextField field54 = new JFormattedTextField(formatter);
        JFormattedTextField field55 = new JFormattedTextField(formatter);
        JFormattedTextField field56 = new JFormattedTextField(formatter);
        JFormattedTextField field64 = new JFormattedTextField(formatter);
        JFormattedTextField field65 = new JFormattedTextField(formatter);
        JFormattedTextField field66 = new JFormattedTextField(formatter);

        JPanel buttonPanel5 = new JPanel();
        buttonPanel5.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel5.setLayout(new GridLayout(3, 3));
        buttonPanel5.add(field44);
        buttonPanel5.add(field45);
        buttonPanel5.add(field46);
        buttonPanel5.add(field54);
        buttonPanel5.add(field55);
        buttonPanel5.add(field56);
        buttonPanel5.add(field64);
        buttonPanel5.add(field65);
        buttonPanel5.add(field66);

        //paczka 23

        JFormattedTextField field47 = new JFormattedTextField(formatter);
        field47.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field48 = new JFormattedTextField(formatter);
        JFormattedTextField field49 = new JFormattedTextField(formatter);
        JFormattedTextField field57 = new JFormattedTextField(formatter);
        JFormattedTextField field58 = new JFormattedTextField(formatter);
        JFormattedTextField field59 = new JFormattedTextField(formatter);
        JFormattedTextField field67 = new JFormattedTextField(formatter);
        JFormattedTextField field68 = new JFormattedTextField(formatter);
        JFormattedTextField field69 = new JFormattedTextField(formatter);

        JPanel buttonPanel6 = new JPanel();
        buttonPanel6.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel6.setLayout(new GridLayout(3, 3));
        buttonPanel6.add(field47);
        buttonPanel6.add(field48);
        buttonPanel6.add(field49);
        buttonPanel6.add(field57);
        buttonPanel6.add(field58);
        buttonPanel6.add(field59);
        buttonPanel6.add(field67);
        buttonPanel6.add(field68);
        buttonPanel6.add(field69);

        //paczka 31


        JFormattedTextField field71 = new JFormattedTextField(formatter);
        field71.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field72 = new JFormattedTextField(formatter);
        JFormattedTextField field73 = new JFormattedTextField(formatter);
        JFormattedTextField field81 = new JFormattedTextField(formatter);
        JFormattedTextField field82 = new JFormattedTextField(formatter);
        JFormattedTextField field83 = new JFormattedTextField(formatter);
        JFormattedTextField field91 = new JFormattedTextField(formatter);
        JFormattedTextField field92 = new JFormattedTextField(formatter);
        JFormattedTextField field93 = new JFormattedTextField(formatter);

        JPanel buttonPanel7 = new JPanel();
        buttonPanel7.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel7.setLayout(new GridLayout(3, 3));
        buttonPanel7.add(field71);
        buttonPanel7.add(field72);
        buttonPanel7.add(field73);
        buttonPanel7.add(field81);
        buttonPanel7.add(field82);
        buttonPanel7.add(field83);
        buttonPanel7.add(field91);
        buttonPanel7.add(field92);
        buttonPanel7.add(field93);


        //paczka 32


        JFormattedTextField field74 = new JFormattedTextField(formatter);
        field74.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field75 = new JFormattedTextField(formatter);
        JFormattedTextField field76 = new JFormattedTextField(formatter);
        JFormattedTextField field84 = new JFormattedTextField(formatter);
        JFormattedTextField field85 = new JFormattedTextField(formatter);
        JFormattedTextField field86 = new JFormattedTextField(formatter);
        JFormattedTextField field94 = new JFormattedTextField(formatter);
        JFormattedTextField field95 = new JFormattedTextField(formatter);
        JFormattedTextField field96 = new JFormattedTextField(formatter);

        JPanel buttonPanel8 = new JPanel();
        buttonPanel8.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel8.setLayout(new GridLayout(3, 3));
        buttonPanel8.add(field74);
        buttonPanel8.add(field75);
        buttonPanel8.add(field76);
        buttonPanel8.add(field84);
        buttonPanel8.add(field85);
        buttonPanel8.add(field86);
        buttonPanel8.add(field94);
        buttonPanel8.add(field95);
        buttonPanel8.add(field96);
        //paczka 33


        JFormattedTextField field77 = new JFormattedTextField(formatter);
        field77.setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
        JFormattedTextField field78 = new JFormattedTextField(formatter);
        JFormattedTextField field79 = new JFormattedTextField(formatter);
        JFormattedTextField field87 = new JFormattedTextField(formatter);
        JFormattedTextField field88 = new JFormattedTextField(formatter);
        JFormattedTextField field89 = new JFormattedTextField(formatter);
        JFormattedTextField field97 = new JFormattedTextField(formatter);
        JFormattedTextField field98 = new JFormattedTextField(formatter);
        JFormattedTextField field99 = new JFormattedTextField(formatter);

        JPanel buttonPanel9 = new JPanel();
        buttonPanel9.setSize(buttonPanelSize, buttonPanelSize);
        buttonPanel9.setLayout(new GridLayout(3, 3));
        buttonPanel9.add(field77);
        buttonPanel9.add(field78);
        buttonPanel9.add(field79);
        buttonPanel9.add(field87);
        buttonPanel9.add(field88);
        buttonPanel9.add(field89);
        buttonPanel9.add(field97);
        buttonPanel9.add(field98);
        buttonPanel9.add(field99);


        buttonPanel1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
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
        buttonPanel6.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        buttonPanel7.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));

        buttonPanel8.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
        buttonPanel9.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEtchedBorder(
                        Color.gray,
                        new Color(156, 156, 158)),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));


        JPanel rootPanel = new JPanel();
        JPanel fieldsPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        fieldsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        fieldsPanel.add(buttonPanel1, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        fieldsPanel.add(buttonPanel2, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        fieldsPanel.add(buttonPanel3, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        fieldsPanel.add(buttonPanel4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        fieldsPanel.add(buttonPanel5, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        fieldsPanel.add(buttonPanel6, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        fieldsPanel.add(buttonPanel7, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        fieldsPanel.add(buttonPanel8, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        fieldsPanel.add(buttonPanel9, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.ipadx = 3;
        fieldsPanel.add(buttonCheck, gbc);


        rootPanel.add(fieldsPanel, BorderLayout.CENTER);
        rootPanel.add(gameName(), BorderLayout.NORTH);

        frameGame.setContentPane(rootPanel);
        frameGame.setJMenuBar(createMenuBar());

    }

    ////////////

    private class newGameAction extends AbstractAction {
        newGameAction() {

        }
        public void actionPerformed(ActionEvent e) {
            newGameSelectDifficultyMessage();
            GUI.frameMenu.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class loadGameAction extends AbstractAction {
        loadGameAction() {

        }
        public void actionPerformed(ActionEvent e) {
            //GUI.frameMenu.setVisible(false);
        }
    }

    private class settingsAction extends AbstractAction {
        settingsAction() {

        }
        public void actionPerformed(ActionEvent e) {
            GUI.frameMenu.setVisible(false);
            //GUI.frameSettings.setVisible(true);
        }
    }

    private class exitGameAction extends AbstractAction {
        exitGameAction() {

        }
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class menuItemBackMainAction extends AbstractAction {
        menuItemBackMainAction() {

        }
        public void actionPerformed(ActionEvent e) {
            gameNotSaved();
            GUI.frameGame.setVisible(false);
            GUI.frameMenu.setVisible(true);
        }
    }

}
