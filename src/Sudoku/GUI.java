package Sudoku;


import javax.swing.*;
import javax.swing.border.Border;
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

    private Generator generator = new Generator();


    GUI(){
        menuItSelf();
        gameItSelf();
    }

    //To jest etykieta ktora pojawia sie w panelach menu i game
    private JLabel gameName() {
        JLabel name = new JLabel("SUDOKU 6000");
        name.setFont(new Font("Arial", Font.BOLD, 70));
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.CENTER);


        return name;
    }

    //Wiadomosc Tworcy ktora pojawia sie poprzez uruchomienie odpowiedniego podmenu z panelu game
    private void creatorsMessage() {

        JOptionPane creators = new JOptionPane();
        showMessageDialog(creators, "Adrian Chabowski\nAleksander Matłok\nFranciszek Przewoźny\n", "Twórcy", JOptionPane.PLAIN_MESSAGE);
    }

    //Wiadomosc ktora wymaga wybrania poziomu trudnosci, pojawia sie po uruchomieniu opcji nowa gra z menu
    private void newGameSelectDifficultyMessage(){

        JOptionPane newGameSelectDifficultyMessage = new JOptionPane();
        Object[] options = {"Trudny","Średni","Łatwy"};
        int n = JOptionPane.showOptionDialog(newGameSelectDifficultyMessage, "Wybierz poziom trudności:", "Nowa Gra", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if(n == JOptionPane.YES_OPTION){
            generator.difficultyLevel(1);
        }
        if(n == JOptionPane.NO_OPTION){
            generator.difficultyLevel(2);
        }
        if(n == JOptionPane.CANCEL_OPTION){
            generator.difficultyLevel(3);
        }
    }

    //Wiadomosc ktora pojawia sie po powrocie do menu z menu gry
    private void gameNotSaved() {

        JOptionPane gameNotSaved = new JOptionPane();
        showMessageDialog(gameNotSaved, "Gra nie została zapisana. Powrót do menu głównego", "Informacja", JOptionPane.PLAIN_MESSAGE);
    }

    //Utworzenie paska (tego na gorze ekranu)
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
    //deklaracja, inicjalizacja menu glownego razem z przyciskami (etykieta i pasek gorny jest dodawany zzewnatrz)


    private void menuItSelf() {

        frameMenu = new JFrame("SUDOKU");
        frameMenu.setMaximumSize(new Dimension(630,630));
        frameMenu.setMinimumSize(new Dimension(630,630));
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setLocationRelativeTo(null);

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



    //deklaracja i inicjalizacja panelu gry
    private void gameItSelf() {

        frameGame = new JFrame("SUDOKU");
        frameGame.setMaximumSize(new Dimension(630,630));
        frameGame.setMinimumSize(new Dimension(630,630));
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setLocationRelativeTo(null);

        MaskFormatter formatter = new MaskFormatter();  //Zmiana z null żeby nie wywalało NullPointerException
        try {
            formatter = new MaskFormatter("#");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.setValidCharacters("123456789");


        int buttonPanelSize = 100;
        int fieldBoxSize = 30;

        JButton buttonCheck = new JButton("Sprawdź");

        JFormattedTextField [][] fields = new JFormattedTextField[Solver.SIZE][Solver.SIZE];

        for (int i=0; i<Solver.SIZE; i++){
            for (int j=0; j<Solver.SIZE; j++){
                fields[i][j] = new JFormattedTextField(formatter);
                fields[i][j].setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
                fields[i][j].setHorizontalAlignment(JTextField.CENTER);
            }
        }

        JPanel[] buttonPanel = new JPanel[Solver.SIZE];

        for (int i=0; i<Solver.SIZE; i++) {
            buttonPanel[i] = new JPanel();
            buttonPanel[i].setSize(buttonPanelSize, buttonPanelSize);
            buttonPanel[i].setLayout(new GridLayout(3, 3));
        }

        for (int i=0; i<Solver.SIZE; i++) {
            for (int j=0; j < Solver.SIZE; j++) {

                if (i<3) {
                    if (j<3)
                        buttonPanel[0].add(fields[i][j]);
                    if (3<=j && j<6)
                        buttonPanel[1].add(fields[i][j]);
                    if (6<=j)
                        buttonPanel[2].add(fields[i][j]);
                }

                if (3<=i && i<6){
                    if (j<3)
                        buttonPanel[3].add(fields[i][j]);
                    if (3<=j && j<6)
                        buttonPanel[4].add(fields[i][j]);
                    if (6<=j)
                        buttonPanel[5].add(fields[i][j]);
                }

                if (6<=i){
                    if (j<3)
                        buttonPanel[6].add(fields[i][j]);
                    if (3<=j && j<6)
                        buttonPanel[7].add(fields[i][j]);
                    if (6<=j)
                        buttonPanel[8].add(fields[i][j]);
                }
            }
        }

        buttonPanel[0].setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK));
        buttonPanel[1].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.BLACK));
        buttonPanel[2].setBorder(BorderFactory.createMatteBorder(0, 1, 1, 0, Color.BLACK));

        buttonPanel[3].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.BLACK));
        buttonPanel[4].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        buttonPanel[5].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));

        buttonPanel[6].setBorder(BorderFactory.createMatteBorder(1, 0, 0, 1, Color.BLACK));
        buttonPanel[7].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK));
        buttonPanel[8].setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0, Color.BLACK));





/*
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



 */
        JPanel rootPanel = new JPanel();
        JPanel fieldsPanel = new JPanel();
        rootPanel.setLayout(new BorderLayout());
        fieldsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        fieldsPanel.add(buttonPanel[0], gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        fieldsPanel.add(buttonPanel[1], gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        fieldsPanel.add(buttonPanel[2], gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        fieldsPanel.add(buttonPanel[3], gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        fieldsPanel.add(buttonPanel[4], gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        fieldsPanel.add(buttonPanel[5], gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        fieldsPanel.add(buttonPanel[6], gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        fieldsPanel.add(buttonPanel[7], gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        fieldsPanel.add(buttonPanel[8], gbc);

        /*
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(buttonCheck, gbc);
        */

        //przyklad zapisu liczby do komorki i wylaczenia jej edycji (wprowadzanie liczb poczatkowych)
        /*
        field11.setText("4");
        field11.setEditable(false);
         */


        rootPanel.add(fieldsPanel, BorderLayout.CENTER);
        rootPanel.add(gameName(), BorderLayout.NORTH);

        frameGame.setContentPane(rootPanel);
        frameGame.setJMenuBar(createMenuBar());


        //TODO-Everyone Uzupełnianie planszy według poziomu trudności

        generator.boardGeneration();

        int [][] tempBoard = generator.getGeneratedBoard();

        for (int i=0; i<Solver.SIZE; i++) {
            for (int j = 0; j < Solver.SIZE; j++) {
                fields[i][j].setValue(tempBoard[i][j]);
            }
        }
    }



    private class newGameAction extends AbstractAction {
        //newGameAction() {}
        public void actionPerformed(ActionEvent e) {
            newGameSelectDifficultyMessage();
            GUI.frameMenu.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class loadGameAction extends AbstractAction {
        //loadGameAction() { }
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

