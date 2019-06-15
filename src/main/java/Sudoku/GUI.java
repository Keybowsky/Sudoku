package Sudoku;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

import static Sudoku.LanguageBase.enLang;
import static Sudoku.LanguageBase.plLang;

/** Klasa odpowiedzialna za wyświetlanie i obsługę interfejsu graficznego. */
class GUI{

    /** Ramka głównego menu. */
    static JFrame frameMenu;

    /** Ramka gry. */
    static JFrame frameGame;

    /** Ramka ustawień. */
    private static JFrame frameSettings;

    /** Rozwiązana tablica. */
    private static int[][] solvedBoard;

    /** Wygenerowana tablica. */
    private static int[][] firstGenerationBoard = new int[9][9];

    /** Tablica komórek. */
    private final JFormattedTextField[][] fields = new JFormattedTextField[Solver.SIZE][Solver.SIZE];

    /** Ramka wyboru poziomu trudności nowej gry. */
    static JFrame newGameOptionFrame;

    /** Akcja odpowiedzialna za utworzenie nowej gry. */
    private final Action newGameAction = new newGameAction();

    /** Akcja odpowiedzialna za wczytanie zapisanego stanu gry. */
    private final Action loadGameAction = new loadGameAction();

    /** Akcja odpowiedzialna za zmianę ustawień. */
    private final Action settingsAction = new settingsAction();

    /** Akcja odpowiedzialna za wyjście z gry. */
    private final Action exitGameAction = new exitGameAction();

    /** Akcja odpowiedzialna za powrót do głónego menu. */
    private final Action menuItemBackMainAction = new menuItemBackMainAction();

    /** Akcja odpowiedzialna za sprawdzenie poprawności wpisanych liczb. */
    private final Action checkGameAction = new checkGameAction();

    /** Akcja odpowiedzialna za sprawdzenie poprawności w pojedynczej sekcji. */
    private final Action checkBoxAction = new checkBoxAction();

    /** Akcja odpowiedzialna za ustawienie poziomu trodności na łatwy. */
    private final Action easyNewGame = new easyNewGame();

    /** Akcja odpowiedzialna za ustawienie poziomu trodności na średni. */
    private final Action mediumNewGame = new mediumNewGame();

    /** Akcja odpowiedzialna za ustawienie poziomu trodności na trudny. */
    private final Action hardNewGame = new hardNewGame();

    /** Akcja odpowiedzialna za utworzenie gry będącej samouczkiem. */
    private final Action tutorialAction = new tutorialAction();

    /** Akcja odpowiedzialna za zapisanie stanu gry. */
    private final Action saveGameAction = new saveGameAction();

    /** Akcja odpowiedzialna za zapisanie zmienionych ustawień. */
    private final Action applySettingsAction = new applySettings();

    /** Instancja klasy generator. */
    private final Generator generator = new Generator();

    /** Instancja klasy GameName. */
    private final GameName gN = new GameName();

    /** Instancja klasy Messages. */
    private final Messages mSG = new Messages();
    //final int userID = 1;
    private int goodAnsw = 0;

    /** Wybór koloru. */
    private JComboBox<String> colorSelect;

    /** Wybór motywu. */
    private JComboBox<String> themeSelect;

    /** Błąd kóry pokazuje niepoprawne wczytanie gry. */
    private boolean error=false; //błąd który wyrzuca niepoprawne wczytanie gry


    //zmiennne dla ustawien gry

    /** Miejsce gdzie są przechowywane zapisane stany gry. */
    private final File fileDirectory = new File("./src/main/resources/saveFiles/");

    /** Miejsce gdzie są przechowywane zapisane stany gry. */
    private final String localisation = "./src/main/resources/saveFiles/";

    /** Wielkość dużego okna. */
    private final Dimension largeMaximumWindow = new Dimension(630,630);

    /** Wielkość dużego okna. */
    private final Dimension largeMinimumWindow = new Dimension(630,630);

    /** Wielkość średniego okna. */
    private final Dimension mediumMaximumWindow = new Dimension(400,300);

    /** Wielkość średniego okna. */
    private final Dimension mediumMinimumWindow = new Dimension(400,300);

    /** Wielkość małego okna. */
    static final Dimension smallMaximumWindow = new Dimension(450, 200);

    /** Wielkość małego okna. */
    static final Dimension smallMinimumWindow = new Dimension(450, 200);

    /** Domyślne ustawienie kolorów. */
    int themeID = 0;

    /** Domyślne ustawienie języka. */
    char langID = 'p';

    /** Domyślne ustawienie języka. */
    static String[] actualLang=plLang;

    /** Domyślne ustawienie kolorów. */
    static final Color[] actualColor = new Color[6];


    /** Konstruktor  ustawiający domyślny motyw graficzny jak i
     * domyślny system operacyjny. Uruchamia możliwości interakcji
     * z przyciskami, ustawia domyślne ustawienia i uruchamia okno
     * głównego menu.
     *
     * */
    GUI()  {
        changeVisuals(themeID);
        System.setProperty("os.name", "Windows");
        System.setProperty("os.version", "7");

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        settings();
        menuItSelf(langID,themeID);
    }

    static void changeVisuals(int input){
        if(input==0) {
            actualColor[0] = new Color(60, 195, 131);
            actualColor[1] = new Color(251, 74, 71);
            actualColor[2] = new Color(177, 181, 188);
            actualColor[3] = new Color(100, 100, 100);
            actualColor[4] = new Color(210, 62, 130);
            actualColor[5] = new Color(97,178,249);

        }
        if(input==1){
            actualColor[0] = new Color(60, 195, 131);
            actualColor[1] = new Color(251, 74, 71);
            actualColor[2] = new Color(177, 181, 188);
            actualColor[3] = new Color(100, 100, 100);
            actualColor[4] = new Color(63, 160, 210);
            actualColor[5] = new Color(97,178,249);
        }
    }

    static void changeVisuals(char input){
        if(input=='p'){actualLang=plLang;}
        if(input=='e'){actualLang=enLang;}
    }

    private void newGameOption(){
        newGameOptionFrame = new JFrame(actualLang[7]);
        newGameOptionFrame.setMaximumSize(smallMaximumWindow);
        newGameOptionFrame.setMinimumSize(smallMinimumWindow);
        newGameOptionFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        newGameOptionFrame.addWindowListener(exitListener);
        newGameOptionFrame.setLocationRelativeTo(null);
        newGameOptionFrame.setVisible(true);
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelTop = new JLabel(actualLang[8]);
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

        JLabel labelBottom = new JLabel(actualLang[9]);
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

        addListenerAction(easyGame, easyNewGame);
        addListenerAction(mediumGame, mediumNewGame);
        addListenerAction(hardGame, hardNewGame);
        addListenerAction(tutorial, tutorialAction);

        easyGame.setText(actualLang[10]);
        mediumGame.setText(actualLang[11]);
        hardGame.setText(actualLang[12]);
        tutorial.setText(actualLang[13]);

        rootPanel.setBackground(actualColor[2]);
        easyGame.setBackground(actualColor[4]);
        mediumGame.setBackground(actualColor[4]);
        hardGame.setBackground(actualColor[4]);
        tutorial.setBackground(actualColor[4]);

    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem menuItemCreators, menuItemBackMain,menuItemSaveGame;

        menuBar = new JMenuBar();
        menu = new JMenu(actualLang[14]);
        menuBar.add(menu);

        menuItemBackMain = new JMenuItem();

        menuItemBackMain.addActionListener(e -> {
        });
        menuItemBackMain.setAction(menuItemBackMainAction);

        menu.add(menuItemBackMain);

        menu.addSeparator();

        menuItemSaveGame = new JMenuItem();
        menuItemSaveGame.addActionListener(e -> {});
        menuItemSaveGame.setAction(saveGameAction);
        menu.add(menuItemSaveGame);
        menu = new JMenu(actualLang[15]);


        menuBar.add(menu);

        menuItemCreators = new JMenuItem(actualLang[16]);
        menuItemCreators.addActionListener(e -> mSG.creatorsMessage());


        menuItemBackMain.setText(actualLang[17]);
        menuItemSaveGame.setText(actualLang[18]);
        menu.add(menuItemCreators);

        return menuBar;
    }

    private void settings(){

        frameSettings = new JFrame(actualLang[2]);
        frameSettings.setMaximumSize(mediumMaximumWindow);
        frameSettings.setMinimumSize(mediumMinimumWindow);
        frameSettings.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frameSettings.addWindowListener(exitListener);
        frameSettings.setLocationRelativeTo(null);
        JPanel rootPanel = new JPanel();

        JButton applySettings = new JButton();
        rootPanel.add(applySettings);

        String[] languages = {"Polski", "English"};
        String[] themes = {actualLang[24],actualLang[25]};

        colorSelect = new JComboBox<>();
        colorSelect.addItem(languages[0]);
        colorSelect.addItem(languages[1]);
        //colorSelect.setSelectedIndex(langID);
        rootPanel.add(colorSelect);

        themeSelect = new JComboBox<>();
        themeSelect.addItem(themes[0]);
        themeSelect.addItem(themes[1]);
        themeSelect.setSelectedIndex(themeID);
        rootPanel.add(themeSelect);

        addListenerAction(applySettings, applySettingsAction);
        applySettings.setText(actualLang[23]);
        applySettings.setBackground(actualColor[4]);

        frameSettings.add(rootPanel);
    }

    private void menuItSelf(char langID, int themeID) {

        frameMenu = new JFrame("SUDOKU");
        frameMenu.setMaximumSize(largeMaximumWindow);
        frameMenu.setMinimumSize(largeMinimumWindow);
        frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameMenu.setLocationRelativeTo(null);
        changeVisuals(langID);
        changeVisuals(themeID);

        frameMenu.repaint();

        JPanel rootPanel = new JPanel(new BorderLayout(5, 50));
        JPanel leftSpacer = new JPanel(new BorderLayout());
        JPanel rightSpacer = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        JPanel mainPanel = new JPanel();

        JButton newGame = new JButton();
        JButton loadGame = new JButton();
        JButton settings = new JButton();
        JButton exitGame = new JButton();

        newGame.setBackground(actualColor[4]);
        loadGame.setBackground(actualColor[4]);
        settings.setBackground(actualColor[4]);
        exitGame.setBackground(actualColor[4]);
        rootPanel.setBackground(actualColor[2]);
        mainPanel.setBackground(actualColor[2]);
        buttonPanel.setBackground(actualColor[2]);

        GridBagConstraints gbc = new GridBagConstraints();

        GridLayout gl = new GridLayout();
        gl.setColumns(1);
        gl.setRows(4);

        buttonPanel.setLayout(gl);
        buttonPanel.add(newGame);
        buttonPanel.add(loadGame);
        buttonPanel.add(settings);
        buttonPanel.add(exitGame);

        mainPanel.setLayout(new GridBagLayout());

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

        addListenerAction(newGame, newGameAction);
        addListenerAction(exitGame, exitGameAction);
        addListenerAction(loadGame, loadGameAction);
        addListenerAction(settings, settingsAction);

        newGame.setText(actualLang[0]);
        loadGame.setText(actualLang[1]);
        settings.setText(actualLang[2]);
        exitGame.setText(actualLang[3]);

        rootPanel.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setMinimumSize(new Dimension(630,100));
        rootPanel.add(gN.gameName(), BorderLayout.NORTH);
 //     rootPanel.add(userMenu, BorderLayout.SOUTH);

        frameMenu.setContentPane(rootPanel);


    }

    void gameItSelf(int difficultyLevel, int load){

        frameGame = new JFrame("SUDOKU");
        frameGame.setMaximumSize(largeMaximumWindow);
        frameGame.setMinimumSize(largeMinimumWindow);
        frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGame.setLocationRelativeTo(null);

        MaskFormatter formatter = new MaskFormatter();
        try {
            formatter = new MaskFormatter("#");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        formatter.setValidCharacters("123456789");


        int buttonPanelSize = 100;
        int fieldBoxSize = 30;

        JButton buttonCheck = new JButton();
        addListenerAction(buttonCheck,checkGameAction);

        buttonCheck.setText(actualLang[19]);

        JButton buttonBoxCheck = new JButton();
        addListenerAction(buttonBoxCheck,checkBoxAction);

        buttonBoxCheck.setText(actualLang[19]);



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
                fields[i][j].setCaretPosition(0);

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


        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(buttonCheck, gbc);
        buttonCheck.setBackground(actualColor[4]);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        fieldsPanel.add(buttonBoxCheck, gbc);
        buttonBoxCheck.setBackground(actualColor[4]);
        buttonBoxCheck.setVisible(false);



/*
        JLabel stats = new JLabel();
        stats.setBackground(additionalColor);
        gbc.gridx = 3;
        gbc.gridy = 1;
        fieldsPanel.add(stats,gbc);

        if(goodAnsw>0){
            stats.setText(String.valueOf(goodAnsw));
        }

*/
        rootPanel.add(fieldsPanel, BorderLayout.CENTER);


        //rootPanel.add(gN.gameName(), BorderLayout.NORTH);

        for(int i=0;i<9;i++){
            buttonPanel[i].setBackground(actualColor[2]);
        }
        fieldsPanel.setBackground(actualColor[2]);
        gN.gameName().setBackground(actualColor[2]);


        frameGame.setContentPane(rootPanel);
        frameGame.setJMenuBar(createMenuBar());



        if(load==0) {loadGame();}
        if(load==1){ newGame(difficultyLevel); }

        if(load==2){
            BoxMethod boxMethodPanel = new BoxMethod(langID, themeID);
            JPanel solvingMethodPanel = new JPanel();
            solvingMethodPanel.add(boxMethodPanel.boxSolvingMethodPanel);
            solvingMethodPanel.setPreferredSize(new Dimension(200,630));
            rootPanel.add(solvingMethodPanel,BorderLayout.WEST);
            fillTutorialBoard(load);
            firstStepTutorial(load);
            buttonCheck.setVisible(false);
            buttonBoxCheck.setVisible(true);
        }

        if(load==3){
            DiagonalMethod diagonalMethodPanel = new DiagonalMethod(langID, themeID);
            JPanel solvingMethodPanel = new JPanel();
            solvingMethodPanel.add(diagonalMethodPanel.diagonalSolvingMethodPanel);
            solvingMethodPanel.setPreferredSize(new Dimension(200,630));
            rootPanel.add(solvingMethodPanel,BorderLayout.WEST);
            fillTutorialBoard(load);
        }

        if(load==4){
            RandomMethod randomMethodPanel = new RandomMethod(langID, themeID);
            JPanel solvingMethodPanel = new JPanel();
            solvingMethodPanel.add(randomMethodPanel.randomSolvingMethodPanel);
            solvingMethodPanel.setPreferredSize(new Dimension(200,630));
            rootPanel.add(solvingMethodPanel,BorderLayout.WEST);
            fillTutorialBoard(load);
        }
    }

    private void firstStepTutorial(int load){
        if (load==2){
            for (int j=0; j<9; ++j){
                fields[8][j].setBackground(actualColor[1]);
            }
            for (int i= 0; i<9; ++i){
                fields[i][1].setBackground(actualColor[1]);
                }
            fields[7][2].setBackground(actualColor[0]);
            fields[7][2].setEditable(true);
            fields[8][7].setBackground(actualColor[0]);
            fields[1][1].setBackground(actualColor[0]);}
    }

    private void checkBoxMethod(){
        int temp;
        String tempS;

        if (fields[7][8].isEditable()){
            tempS = String.valueOf(fields[7][8].getValue());
            temp = Integer.parseInt(tempS);
            if(temp==3)
            {EndGame wonGame = new EndGame(langID,themeID);
            EndGame.endGame.repaint();
            wonGame.endGame.setVisible(true);
            frameGame.setEnabled(false);}
            else{fields[7][8].setBackground(actualColor[4]);}
        }

        if (fields[7][2].isEditable())
        {tempS = String.valueOf(fields[7][2].getValue());
        temp = Integer.parseInt(tempS);

        if (temp==1) {
            nextStep(2);
        }else{fields[7][2].setBackground(actualColor[4]);}}

    }

    private void nextStep(int load){
        if (load==2){

            for (int j=0; j<9; ++j){
                fields[8][j].setBackground(actualColor[5]);
            }
            for (int i= 0; i<9; ++i){
                fields[i][1].setBackground(actualColor[5]);
            }
            fields[7][2].setBackground(actualColor[5]);
            fields[7][2].setEditable(false);
            fields[8][7].setBackground(actualColor[5]);
            fields[1][1].setBackground(actualColor[5]);


            fields[7][8].setBackground(actualColor[0]);
            fields[7][8].setEditable(true);

        }
    }

    private void fillTutorialBoard(int load){

        if(load==2) {
            int[][] boxMethodBoard = BoxMethod.tutorialFieldsValue;
            for (int i = 0; i < Solver.SIZE; i++) {
                for (int j = 0; j < Solver.SIZE; j++) {
                    if(boxMethodBoard[i][j]!=0)
                    {fields[i][j].setText(String.valueOf(boxMethodBoard[i][j]));}
                }
            }

            for (int i = 0; i < Solver.SIZE; i++) {
                for (int j = 0; j < Solver.SIZE; j++) {
                    //if(boxMethodBoard[i][j]!=0)
                    {fields[i][j].setEditable(false);}
                    //else fields[i][j].setValue("");
                }
            }


        }
        if(load==3) {
            int[][] diagonalMethodBoard = DiagonalMethod.tutorialFieldsValue;
            for (int i = 0; i < Solver.SIZE; i++) {
                for (int j = 0; j < Solver.SIZE; j++) {
                    if(diagonalMethodBoard[i][j]!=0)
                    fields[i][j].setText(String.valueOf(diagonalMethodBoard[i][j]));
                }
            }
            for (int i = 0; i < Solver.SIZE; i++) {
                for (int j = 0; j < Solver.SIZE; j++) {
                    if(diagonalMethodBoard[i][j]!=0)
                    {fields[i][j].setEditable(false);}
                    else fields[i][j].setValue("");
                }
            }
        }
        if(load==4) {
            int[][] randomMethodBoard = RandomMethod.tutorialFieldsValue;
            for (int i = 0; i < Solver.SIZE; i++) {
                for (int j = 0; j < Solver.SIZE; j++) {
                    if(randomMethodBoard[i][j]!=0)
                    fields[i][j].setText(String.valueOf(randomMethodBoard[i][j]));
                }
            }
            for (int i = 0; i < Solver.SIZE; i++) {
                for (int j = 0; j < Solver.SIZE; j++) {
                    if(randomMethodBoard[i][j]!=0)
                    {fields[i][j].setEditable(false);}
                    else fields[i][j].setValue("");
                }
            }
        }

    }

    private void newGame(int difficultyLevel){
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
                if (tempBoard[i][j] != 0) {
                    fields[i][j].setEditable(false);
                } else
                    fields[i][j].setValue("");
            }
        }
        firstGenerationBoard= tempBoard;
        solveTheBoard(firstGenerationBoard);
    }

    private void saveGame() throws IOException{

        File fileName = new File(localisation+"gameSaveUser"+1+".txt");
        boolean filegeneration=true;

        if(!fileDirectory.exists()){
            fileDirectory.mkdir();
        }
        if(!fileName.exists()){
            try {
                fileName.createNewFile();
            } catch (IOException e) {
                filegeneration=false;
                mSG.saveError();
                e.printStackTrace();
            }
        }


        if(filegeneration) {
            BufferedWriter saver = new BufferedWriter(new FileWriter(fileName));
            System.out.print("\nPlansza aktualna:   ");
            for (int i = 0; i < Solver.SIZE; i++) {
                for (int j = 0; j < Solver.SIZE; j++) {
                    if (fields[i][j].getValue() == "") {

                        saver.write(("0"));
                        System.out.print("0");
                    } else {
                        System.out.print(fields[i][j].getValue());
                        saver.write((fields[i][j].getValue()).toString());
                    }
                    saver.write("\n");
                    saver.write(Integer.toString(firstGenerationBoard[i][j]));
                    saver.write("\n");
                }
            }
            saver.close();
            mSG.gameSaved();
        }
    }

    private void loadGame(){
        int col = 9;
        int row = 9;
        int[][] loadBoard = new int[row][col];



        File file  = new File(localisation+"gameSaveUser"+1+".txt");

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                for(int i=0; i<row;i++) {
                    for (int j = 0; j < col; j++) {
                        loadBoard[i][j] =  Integer.parseInt(reader.nextLine());
                        firstGenerationBoard[i][j] =  Integer.parseInt(reader.nextLine());


                        if(loadBoard[i][j]==0){
                            fields[i][j].setValue("");
                        }
                        else {
                            fields[i][j].setValue(loadBoard[i][j]);
                        }
                        if(loadBoard[i][j]!=0){
                            fields[i][j].setEditable(false);
                        }
                    }
                }
            }
            reader.close();
            solveTheBoard(firstGenerationBoard);
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(actualLang[6]);
            Messages.loadError();
            error=true;
        }
    }

    private void solveTheBoard(int[][] boardToSolve){
       solvedBoard = Solver.solveTheBoard(boardToSolve);
    }

    private void checkGame(){

        int[][] boardToCheck = new int[9][9];
        int temp;
        int wrongAnsw=0;
        String tempS;
        System.out.println("checkGame function");


        for(int i = 0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                if (fields[i][j].getValue() == "") {
                    boardToCheck[i][j] = 0;
                    System.out.print("0");
                } else {
                    tempS = String.valueOf(fields[i][j].getValue());
                    temp = Integer.parseInt(tempS);
                    boardToCheck[i][j] = temp;
                    System.out.print(temp);
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        for(int i = 0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
              System.out.print(solvedBoard[i][j]);
            if(boardToCheck[i][j]==solvedBoard[i][j])
            {
                if(fields[i][j].isEditable()) {
                    fields[i][j].setBackground(actualColor[0]);
                }
            }
            else{
                fields[i][j].setBackground(actualColor[1]);
                wrongAnsw++;
            }
            }
            System.out.println();
        }


        frameGame.repaint();


        EndGame wonGame = new EndGame(langID,themeID);
        if(wrongAnsw==0){
            EndGame.endGame.repaint();
            wonGame.endGame.setVisible(true);
            frameGame.setEnabled(false); //freeze okna

            //tu musi tak byc zeby działało
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
        loadGameAction() { }
        public void actionPerformed(ActionEvent e) {
            GUI.frameMenu.setVisible(false);
            gameItSelf(0,0);
            if(!error){ GUI.frameGame.setVisible(true);}
            else{GUI.frameMenu.setVisible(true);}
            error=false;
        }
    }

    private class settingsAction extends AbstractAction {
        settingsAction() {

        }

        public void actionPerformed(ActionEvent e) {
            GUI.frameMenu.setVisible(false);
            settings();
            GUI.frameSettings.setVisible(true);
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

        @Override
        public void actionPerformed(ActionEvent e) {
            Messages.gameNotSaved();
            GUI.frameGame.setVisible(false);
            GUI.frameGame.dispose();
//            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameMenu.setVisible(true);
        }
    }

    private class checkGameAction extends AbstractAction {
        checkGameAction() {
        }

        public void actionPerformed(ActionEvent e) {
            checkGame();
        }
    }

    private class checkBoxAction extends AbstractAction {
        checkBoxAction() {
        }

        public void actionPerformed(ActionEvent e) {
            checkBoxMethod();
        }
    }


    private class easyNewGame extends AbstractAction {
        easyNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            //gameItSelf(generator.difficultyLevel(1));
            gameItSelf(1,1);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class mediumNewGame extends AbstractAction {
        mediumNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            gameItSelf(2,1);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class hardNewGame extends AbstractAction {
        hardNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            gameItSelf(3,1);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class tutorialAction extends AbstractAction {
        tutorialAction() {
        }

        public void actionPerformed(ActionEvent e) {
            new Tutorial(langID,themeID);

        }
    }

    private class saveGameAction extends AbstractAction {
        saveGameAction() {
        }

        public void actionPerformed(ActionEvent e) {
            try {
                saveGame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //mSG.gameSaved();
            frameGame.dispose();
            frameGame.setVisible(false);
            frameMenu.setVisible(true);
        }
    }

    private class applySettings extends AbstractAction {
        applySettings() {
        }

        public void actionPerformed(ActionEvent e) {

            int temp = colorSelect.getSelectedIndex();
            if(temp==0){langID='p';}
            if(temp==1){langID='e';}

            changeVisuals(themeSelect.getSelectedIndex());
            themeID=themeSelect.getSelectedIndex();
            menuItSelf(langID,themeID);
            GUI.frameMenu.setVisible(true);
            GUI.frameSettings.setVisible(false);

        }
    }

    private final WindowListener exitListener = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            frameMenu.setVisible(true);
        }
    };

    private void addListenerAction(JButton buttonName, Action actionName){

        buttonName.addActionListener(e -> {
        });
        buttonName.setAction(actionName);
    }
}



