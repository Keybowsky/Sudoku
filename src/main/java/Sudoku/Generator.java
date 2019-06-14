package Sudoku;

import java.util.Random;

/**
 * Klasa służy do generowania tablic do rozwiązania dla użytkownika.
 * */

class Generator {

    /** Pusta tablica z której generujemy. */
    private int[][] generationBoard;

    /** Wygenerowana tablica. */
    private int[][] generatedBoard;

    /** Losowa liczba. */
    private final Random rand = new Random();

    /** Zwraca wygenerowaną tablicę.
     *
     * @return Wygenerowana tablica.
     *
     * */
    int[][] getGeneratedBoard() {
        return generatedBoard;
    }

    /** Zwraca tablicę wypełnioną zerami. */
    private int[][] cleanBoard() {
        return new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }

    /** Sprawdza czy w ramach jednej sekcji zadana liczba się nie powtarza.
     *
     * @param row Rząd sekcji którą chcemy sprawdzić.
     * @param column Kolumna sekcji którą chcemy sprawdzić.
     * @param checkedNumber Sprawdzana liczba.
     * @return true jeżeli liczba się nie powtarza.
     *
     * */
    private boolean diagonalSectionCheck(int row, int column, int checkedNumber) {

        int sectionRow = row - row % 3;
        int sectionColumn = column - column % 3;

        for (int i = sectionRow; i < sectionRow + 3; i++) {
            for (int j = sectionColumn; j < sectionColumn + 3; j++) {
                if (generationBoard[i][j] == checkedNumber)
                    return false;
            }
        }
        return true;
    }

    /** Zapełnia losowymi liczbami w zakresie od 1 do 9 sekcje znajdujące się na głównej przekątnej. * */
    private void diagonalSectionGeneration() {
        for (int section = 0; section < 7; section = section + 3) {
            for (int row = section; row < section + 3; row++) {
                for (int column = section; column < section + 3; column++) {
                    int randNumber = rand.nextInt(9) + 1;
                    if (diagonalSectionCheck(row, column, randNumber))
                        generationBoard[row][column] = randNumber;
                    else
                        column--;
                }
            }
        }
    }
/*
    int difficultyLevel(int difficultyLevel) {

        if (difficultyLevel == 1)
            numberOfFieldsToBeDeleted = rand.nextInt((8) + 1) + 41; //Łatwy
        if (difficultyLevel == 2)
            numberOfFieldsToBeDeleted = rand.nextInt((7) + 1) + 49; //Średni
        if (difficultyLevel == 3)
            numberOfFieldsToBeDeleted = rand.nextInt((5) + 1) + 59; //Trudny
        System.out.print(numberOfFieldsToBeDeleted);
        return numberOfFieldsToBeDeleted;
        //return difficultyLevel;
    }

 */

    /** Usuwa pola w ilości zależnej od wybranego poziomu trudności.
     *
     * @param difficultyLevel Wybrany przez użytkownika poziom trudności.
     *
     * */
    private void fieldDeletion(int difficultyLevel) {

            for(int row=0; row!=9; ++row) {
                for (int i = 0; i <= difficultyLevel; ++i) {
                    int randColumn = rand.nextInt(9);
                    if (generatedBoard[row][randColumn] != 0) {
                        //System.out.print(randColumn+" ");
                        generatedBoard[row][randColumn] = 0;
                    }
                }
            }
    }

    /** Generuje tablicę do rozwiązania przez użytkownika.
     *
     * @param difficultyLevelFromGUI Wybrany przez użytkownika poziom trudności.
     *
     * */
    void boardGeneration(int difficultyLevelFromGUI) {
        generationBoard = cleanBoard();
        diagonalSectionGeneration();
        Solver generator = new Solver(generationBoard);
        generator.solve();
        generatedBoard = generator.getBoardToSolve();


        if(difficultyLevelFromGUI==1)
            fieldDeletion(5);
        if(difficultyLevelFromGUI==2)
            fieldDeletion(6);
        if(difficultyLevelFromGUI==3)
            fieldDeletion(7);

    }
}
