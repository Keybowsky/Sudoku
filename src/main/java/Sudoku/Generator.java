package Sudoku;

import java.util.Random;

/**
 * Klasa sluzy do generowania tablic do rozwiazania dla uzytkownika.
 * */

class Generator {

    /** Pusta tablica z ktorej generujemy. */
    private int[][] generationBoard;

    /** Wygenerowana tablica. */
    private int[][] generatedBoard;

    /** Losowa liczba. */
    private final Random rand = new Random();

    /** Zwraca wygenerowana tablice.
     *
     * @return Wygenerowana tablica.
     *
     * */
    int[][] getGeneratedBoard() {
        return generatedBoard;
    }

    /** Zwraca tablice wypelliona zerami. */
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

    /** Sprawdza czy w ramach jednej sekcji zadana liczba sie nie powtarza.
     *
     * @param row Rzad sekcji ktora chcemy sprawdzic.
     * @param column Kolumna sekcji ktora chcemy sprawdzic.
     * @param checkedNumber Sprawdzana liczba.
     * @return true jezeli liczba sie nie powtarza.
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

    /** Zapelnia losowymi liczbami w zakresie od 1 do 9 sekcje znajdujace sie na glownej przekatnej. */
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

    /** Usuwa pola w ilosci zaleznej od wybranego poziomu trudnosci.
     *
     * @param difficultyLevel Wybrany przez uzytkownika poziom trudnosci.
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

    /** Generuje tablice do rozwiazania przez uzytkownika.
     *
     * @param difficultyLevelFromGUI Wybrany przez uzytkownika poziom trudnosci.
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
