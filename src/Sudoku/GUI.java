package Sudoku;


import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.text.ParseException;
import java.util.Scanner;


class GUI{

    protected static JFrame frameMenu;
    protected static JFrame frameGame;
    private static JFrame frameLoad;
    private static int[][] solvedBoard;

    private JFormattedTextField[][] fields = new JFormattedTextField[Solver.SIZE][Solver.SIZE];
    private File fileDirectory = new File("./saveFiles/");
    private String localisation = "./saveFiles/";
    //TODO tworzenie folderu saveFiles jeśli już nie istnieje


    private int[][] tempBoard;
    static JFrame newGameOptionFrame;
    private final Action newGameAction = new newGameAction();
    private final Action loadGameAction = new loadGameAction();
    private final Action settingsAction = new settingsAction();
    private final Action exitGameAction = new exitGameAction();
    private final Action menuItemBackMainAction = new menuItemBackMainAction();
    private final Action checkGameAction = new checkGameAction();
    private final Action easyNewGame = new easyNewGame();
    private final Action mediumNewGame = new mediumNewGame();
    private final Action hardNewGame = new hardNewGame();
    private final Action tutorialAction = new tutorialAction();
    private final Action saveGameAction = new saveGameAction();
    private Generator generator = new Generator();
    private gameName gN = new gameName();
    private messages mSG = new messages();
    private int userID = 1;
   // private String[] users = { "Domyślny", "Użytkownik "+userID};


    GUI()  {
        menuItSelf();
    }


    protected void newGameOption(){
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



    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar;
        JMenu menu, submenuGameType, submenuGameDifficulty;
        JMenuItem menuItemCreators, menuItemBackMain,menuItemSaveGame;
        JRadioButtonMenuItem  radioButtonGameNormal, radioButtonGameTutorial;

        menuBar = new JMenuBar();
        menu = new JMenu("Gra");
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
        menuItemCreators.addActionListener(e -> mSG.creatorsMessage());


        menuItemBackMain.setText("Powrót do Menu Głównego");
        menuItemSaveGame.setText("Zapisz grę");
        //  radioButtonGameTutorial.setText("Samouczek");
        //  radioButtonGameNormal.setText("Normalna gra");
        menu.add(menuItemCreators);

        return menuBar;
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



/*
        JComboBox userList = new JComboBox(users);
        JButton user = new JButton("Nowy użytkownik");


 */




        JPanel buttonPanel = new JPanel();
//        JPanel userMenu = new JPanel();

        GridBagConstraints gbc = new GridBagConstraints();


 /*
        userMenu.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        userMenu.add(userList,gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        userMenu.add(user,gbc);

  */


        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(newGame);
        buttonPanel.add(loadGame);
        buttonPanel.add(settings);
        buttonPanel.add(exitGame);


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());


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
        rootPanel.add(gN.gameName(), BorderLayout.NORTH);
 //       rootPanel.add(userMenu, BorderLayout.SOUTH);

        frameMenu.setContentPane(rootPanel);


    }

    //deklaracja i inicjalizacja panelu gry
    protected void gameItSelf(int difficultyLevel, int userID,boolean load){

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
        buttonCheck.setAction(checkGameAction);
        buttonCheck.setText("Sprawdź");



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
        rootPanel.add(gN.gameName(), BorderLayout.NORTH);

        frameGame.setContentPane(rootPanel);
        frameGame.setJMenuBar(createMenuBar());

    if(load==false) {
    newGame(difficultyLevel);
            }
    else{

            loadGame(userID);
    }
    }

    private void newGame(int difficultyLevel){
        //TODO-Everyone Uzupełnianie planszy według poziomu trudności
        generator.boardGeneration(difficultyLevel);

        tempBoard = generator.getGeneratedBoard();

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
                } else
                    fields[i][j].setValue("");
            }
        }
        solveTheBoard(tempBoard);

    }

    private void saveGame() throws IOException{

        File fileName = new File(localisation+"gameSaveUser"+userID+".txt");

        if(!fileDirectory.exists()){
            fileDirectory.mkdir();
        }
        if(!fileName.exists()){
            try {
                fileName.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        BufferedWriter saver = new BufferedWriter(new FileWriter(fileName));

         System.out.print("\nPlansza aktualna:   ");
        for(int i = 0; i<Solver.SIZE; i++){
            for(int j = 0; j<Solver.SIZE; j++){
                if(fields[i][j].getValue()=="") {

                    saver.write(("0"));
                    System.out.print("0");
                }
                else {
                    System.out.print(fields[i][j].getValue());
                    saver.write((fields[i][j].getValue()).toString());
                }
                saver.write("\n");
            }
            //
        }
        saver.close();


    }

    private void loadGame(int userID){
        //TODO-Everyone Tutaj wczytywanie
        int col = 9;
        int row = 9;
        int[][] loadBoard = new int[row][col];


        File file  = new File(localisation+"gameSaveUser"+userID+".txt");

        try {
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                for(int i=0; i<row;i++) {
                    for (int j = 0; j < col; j++) {
                        loadBoard[i][j] =  Integer.parseInt(reader.nextLine());
                    }
                }

            }



            reader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Błąd odczytu");
        }

        tempBoard = loadBoard;

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
                } else
                    fields[i][j].setValue("");
            }
        }
        solveTheBoard(tempBoard);

    }

    private void solveTheBoard(int[][] boardToSolve){
       solvedBoard = Solver.solveTheBoard(boardToSolve);
    }

    private void checkGame(){

        int[][] boardToCheck = new int[9][9];
        int temp;
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
                    fields[i][j].setBackground(Color.green);
                }
            }
            else{
                fields[i][j].setBackground(Color.red);
            }


            }
            System.out.println();
        }


        frameGame.repaint();


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
         //   GUI.frameMenu.setVisible(false);
//            GUI.frameGame.dispose();
            /*
            try {
                loadGame(userID);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

             */
            GUI.frameMenu.setVisible(false);
            gameItSelf(0,userID,true);
            GUI.frameGame.setVisible(true);
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

        @Override
        public void actionPerformed(ActionEvent e) {
            mSG.gameNotSaved();
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

    private class easyNewGame extends AbstractAction {
        easyNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            //gameItSelf(generator.difficultyLevel(1));
            gameItSelf(1,userID,false);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class mediumNewGame extends AbstractAction {
        mediumNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            gameItSelf(2,userID,false);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class hardNewGame extends AbstractAction {
        hardNewGame() {
        }

        public void actionPerformed(ActionEvent e) {
            gameItSelf(3,userID,false);
            GUI.newGameOptionFrame.setVisible(false);
            GUI.frameGame.setVisible(true);
        }
    }

    private class tutorialAction extends AbstractAction {
        tutorialAction() {
        }

        public void actionPerformed(ActionEvent e) {
            new Tutorial();

        }
    }

    class saveGameAction extends AbstractAction {
        saveGameAction() {
        }

        public void actionPerformed(ActionEvent e) {
            try {
                saveGame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            mSG.gameSaved();
            frameGame.dispose();
            frameGame.setVisible(false);
            frameMenu.setVisible(true);
        }
    }

}

