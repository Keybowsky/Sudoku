package Sudoku;

import java.util.Random;

class Generator {

    private int[][] generationBoard = {
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

    private int[][] generatedBoard;
    private Random rand = new Random();

    int[][] getGenerationBoard() {
        return generationBoard;
    }

    int[][] getGeneratedBoard() {
        return generatedBoard;
    }


    private boolean diagonalSectionCheck(int row, int column, int checkedNumber) {

        int sectionRow = row - row % 3;
        int sectionColumn = column - column % 3;

        for (int i = sectionRow; i < sectionRow + 3; i++) {
            for (int j = sectionColumn; j < sectionColumn + 3; j++) {
                if (generationBoard[i][j] == checkedNumber)
                    return false;
            }
        }
        // petle do sprawdzania powtórzeń w kolumnach i rzędach
        /*for (int i = 0; i < 9; i++) {
            if (generationBoard[row][i] == checkedNumber)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (generationBoard[i][column] == checkedNumber)
                return false;
        }*/
        return true;
    }



    private void diagonalSectionGeneration() {
        for (int section=0; section<7; section = section+3) {
            for (int row = section; row < section+3; row++) {
                for (int column = section; column < section+3; column++) {
                    int randNumber = rand.nextInt(9) + 1;
                    if (diagonalSectionCheck(row, column, randNumber))
                        generationBoard[row][column] = randNumber;
                    else
                        column--;
                }

            }
        }
    }
    /* wersja generatora z generowaniem całej planszy
    private void diagonalSectionGeneration() {
        for (int sectionX=0; sectionX<7; sectionX = sectionX+3) {
            for (int sectionY=0; sectionY<7; sectionY=sectionY+3) {
                for (int row = sectionX; row < sectionX+3; row++) {
                    for (int column = sectionY; column < sectionY+3; column++) {
                        int randNumber = rand.nextInt(9) + 1;
                        if (diagonalSectionCheck(row, column, randNumber))
                            generationBoard[row][column] = randNumber;
                        else
                            column--;
                    }
                }

            }
        }
    }*/


    void boardGeneration() {

        int randNumber = rand.nextInt(14) + 51;
        diagonalSectionGeneration();
        Solver generator = new Solver(generationBoard);
        generator.solve();
        generatedBoard = generator.getBoardToSolve();

        for (int i = 0; i < randNumber; i++) {

            int randRow = rand.nextInt(9);
            int randColumn = rand.nextInt(9);

            if (generatedBoard[randRow][randColumn] != 0)
                generatedBoard[randRow][randColumn] = 0;
            else
                i--;
        }
    }
}
