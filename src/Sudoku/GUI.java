package Sudoku;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.text.ParseException;


import static javax.swing.JOptionPane.showMessageDialog;


class GUI {

    protected static JFrame frameMenu;
    private static JFrame frameGame;
    private static JFrame newGameOptionFrame;
    private final Action newGameAction = new newGameAction();
    private final Action loadGameAction = new loadGameAction();
    private final Action settingsAction = new settingsAction();
    private final Action exitGameAction = new exitGameAction();
    private final Action menuItemBackMainAction = new menuItemBackMainAction();
    private final Action checkGame = new checkGame();
    private final Action easyNewGame = new easyNewGame();
    private final Action mediumNewGame = new mediumNewGame();
    private final Action hardNewGame = new hardNewGame();
    private final Action tutorialAction = new tutorialAction();

    private Generator generator = new Generator();


    GUI() {

        menuItSelf();

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
    private JFrame newGameOption(){
        newGameOptionFrame = new JFrame("Wybór trybu gry");
        newGameOptionFrame.setMaximumSize(new Dimension(450, 200));
        newGameOptionFrame.setMinimumSize(new Dimension(450, 200));
        newGameOptionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newGameOptionFrame.setLocationRelativeTo(null);
        newGameOptionFrame.setVisible(true);
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelTop = new JLabel("Wybór poziomu trudności dla gry wolnej:");
       labelTop.setHorizontalAlignment(SwingConstants.CENTER);
        labelTop.setVerticalAlignment(SwingConstants.CENTER);

        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
       // gbc.ipady = 20;
        //gbc.ipadx = 3;
        rootPanel.add(labelTop, gbc);

        JButton easyGame = new JButton();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 5;
        gbc.ipady = 10;
        rootPanel.add(easyGame, gbc);


        JButton mediumGame = new JButton();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridy = 1;
        gbc.ipadx = 5;
        gbc.ipady = 10;
        rootPanel.add(mediumGame, gbc);


        JButton hardGame = new JButton();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = 2;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.gridy = 1;
        gbc.ipadx = 5;
        gbc.ipady = 10;
        rootPanel.add(hardGame, gbc);

        JLabel labelBottom = new JLabel("Inne opcje:");
        labelBottom.setHorizontalAlignment(SwingConstants.CENTER);
        labelBottom.setVerticalAlignment(SwingConstants.CENTER);
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
       // gbc.ipady = 20;

        //gbc.ipadx = 3;
        rootPanel.add(labelBottom, gbc);

        JButton tutorial = new JButton();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 1;
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridy = 3;
        gbc.ipadx = 5;
        gbc.ipady = 10;
        rootPanel.add(tutorial, gbc);


        newGameOptionFrame.add(rootPanel);



        easyGame.addActionListener(e -> {
        });
        easyGame.setAction(easyNewGame);

        mediumGame.addActionListener(e -> {
        });
        mediumGame.setAction(mediumNewGame);

        hardGame.addActionListener(e -> {
        });
        hardGame.setAction(hardNewGame);
        tutorial.addActionListener(e -> {
        });
        tutorial.setAction(tutorialAction);


        easyGame.setText("Łatwy");
        mediumGame.setText("Średni");
        hardGame.setText("Trudny");
        tutorial.setText("Samouczek");


        return newGameOptionFrame;
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
        JMenuItem menuItemCreators, menuItemBackMain;
        JRadioButtonMenuItem  radioButtonGameNormal, radioButtonGameTutorial;

        menuBar = new JMenuBar();
        menu = new JMenu("Gra");
        menuBar.add(menu);

        menuItemBackMain = new JMenuItem();

        menuItemBackMain.addActionListener(e -> {
        });
        menuItemBackMain.setAction(menuItemBackMainAction);

        menu.add(menuItemBackMain);

        ///

        //a group of radio button menu items
        menu.addSeparator();

        /*
        submenuGameType = new JMenu("Typ gry");

        submenuGameType.setMnemonic(KeyEvent.VK_S);
        ButtonGroup gameTypeGroup = new ButtonGroup();
        radioButtonGameNormal = new JRadioButtonMenuItem("Normalna gra");
        radioButtonGameNormal.setSelected(true);
        radioButtonGameNormal.setMnemonic(KeyEvent.VK_R);
        gameTypeGroup.add(radioButtonGameNormal);
        submenuGameType.add(radioButtonGameNormal);

        radioButtonGameTutorial = new JRadioButtonMenuItem("Samouczek");
        radioButtonGameTutorial.setMnemonic(KeyEvent.VK_O);
        gameTypeGroup.add(radioButtonGameTutorial);
        submenuGameType.add(radioButtonGameTutorial);


        menu.add(submenuGameType);


        radioButtonGameTutorial.addActionListener(e -> {
        });
        radioButtonGameTutorial.setAction(tutorialAction);

        radioButtonGameNormal.addActionListener(e -> {
            System.out.print("Cos");
        });
        //   radioButtonGameNormal.setAction();


         */

        //TODO-Franek Wypełnianie w zależności od wybranej trudności(z menubar)

        menu = new JMenu("Info");


        menuBar.add(menu);

        menuItemCreators = new JMenuItem("Twórcy gry");
        menuItemCreators.addActionListener(e -> creatorsMessage());


        menuItemBackMain.setText("Powrót do Menu Głównego");
      //  radioButtonGameTutorial.setText("Samouczek");
      //  radioButtonGameNormal.setText("Normalna gra");
        menu.add(menuItemCreators);

        return menuBar;
    }
    //deklaracja, inicjalizacja menu glownego razem z przyciskami (etykieta i pasek gorny jest dodawany zzewnatrz)

    private void checkGame(){

        //tutaj sprawdzanie uruchomione przyciskiem z wewnątrz gry (może osobny messageDialog ?)

    }

    private void menuItSelf() {

        frameMenu = new JFrame("SUDOKU");
        frameMenu.setMaximumSize(new Dimension(630, 630));
        frameMenu.setMinimumSize(new Dimension(630, 630));
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


        newGame.addActionListener(e -> {
        });
        newGame.setAction(newGameAction);

        exitGame.addActionListener(e -> {
        });
        exitGame.setAction(exitGameAction);

        loadGame.addActionListener(e -> {
        });
        loadGame.setAction(loadGameAction);

        settings.addActionListener(e -> {
        });
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
    private void gameItSelf(int difficultyLevel) {

        frameGame = new JFrame("SUDOKU");
        frameGame.setMaximumSize(new Dimension(630, 630));
        frameGame.setMinimumSize(new Dimension(630, 630));
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

        JButton buttonCheck = new JButton();
        buttonCheck.addActionListener(e -> {
        });
        buttonCheck.setAction(checkGame);
        buttonCheck.setText("Sprawdź");

        JFormattedTextField[][] fields = new JFormattedTextField[Solver.SIZE][Solver.SIZE];

        for (int i = 0; i < Solver.SIZE; i++) {
            for (int j = 0; j < Solver.SIZE; j++) {
                fields[i][j] = new JFormattedTextField(formatter);
                fields[i][j].setPreferredSize(new Dimension(fieldBoxSize, fieldBoxSize));
                fields[i][j].setHorizontalAlignment(JTextField.CENTER);
            }
        }

        JPanel[] buttonPanel = new JPanel[Solver.SIZE];

        for (int i = 0; i < Solver.SIZE; i++) {
            buttonPanel[i] = new JPanel();
            buttonPanel[i].setSize(buttonPanelSize, buttonPanelSize);
            buttonPanel[i].setLayout(new GridLayout(3, 3));
        }

        for (int i = 0; i < Solver.SIZE; i++) {
            for (int j = 0; j < Solver.SIZE; j++) {
                if (i < 3) {
                    if (j < 3)
                        buttonPanel[0].add(fields[i][j]);
                    if (3 <= j && j < 6)
                        buttonPanel[1].add(fields[i][j]);
                    if (6 <= j)
                        buttonPanel[2].add(fields[i][j]);
                }

                if (3 <= i && i < 6) {
                    if (j < 3)
                        buttonPanel[3].add(fields[i][j]);
                    if (3 <= j && j < 6)
                        buttonPanel[4].add(fields[i][j]);
                    if (6 <= j)
                        buttonPanel[5].add(fields[i][j]);
                }

                if (6 <= i) {
                    if (j < 3)
                        buttonPanel[6].add(fields[i][j]);
                    if (3 <= j && j < 6)
                        buttonPanel[7].add(fields[i][j]);
                    if (6 <= j)
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


        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(buttonCheck, gbc);


        rootPanel.add(fieldsPanel, BorderLayout.CENTER);
        rootPanel.add(gameName(), BorderLayout.NORTH);

        frameGame.setContentPane(rootPanel);
        frameGame.setJMenuBar(createMenuBar());


        //TODO-Everyone Uzupełnianie planszy według poziomu trudności
        generator.boardGeneration(difficultyLevel);

        int[][] tempBoard = generator.getGeneratedBoard();

        for (int i = 0; i < Solver.SIZE; i++) {
            System.out.println();
            for (int j = 0; j < Solver.SIZE; j++) {
                System.out.print(tempBoard[i][j] + " / ");
            }
        }

        for (int i = 0; i < Solver.SIZE; i++) {
            for (int j = 0; j < Solver.SIZE; j++) {
                fields[i][j].setValue(tempBoard[i][j]);
                if (tempBoard[i][j] != 0) {     //pętla if else robi tak: jeśli liczba jest inna niż zero (czyli dana z góry) to blokuje edycje, jeśli jest zero (brak danej - do wpisu) to wstawia puste zamiast zera
                    fields[i][j].setEditable(false);
                }
                else
                    fields[i][j].setValue("");
            }
        }
    }


    private class newGameAction extends AbstractAction {
        public void actionPerformed(ActionEvent e) {
            newGameOption();
            GUI.frameMenu.setVisible(false);

           // GUI.frameGame.setVisible(true);
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
            GUI.frameGame.dispose();
            GUI.frameGame.setVisible(false);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameMenu.setVisible(true);
        }
    }

    private class checkGame extends AbstractAction {
        checkGame() {
        }

        public void actionPerformed(ActionEvent e) {
        }
    }

    private class easyNewGame extends AbstractAction {
        easyNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            //gameItSelf(generator.difficultyLevel(1));
            gameItSelf(1);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class mediumNewGame extends AbstractAction {
        mediumNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            gameItSelf(2);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class hardNewGame extends AbstractAction {
        hardNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            gameItSelf(3);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class tutorialAction extends AbstractAction {
        tutorialAction() {
        }

        public void actionPerformed(ActionEvent e) {


        }
    }


}

