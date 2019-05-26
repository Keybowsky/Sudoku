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
    private int numberOfFieldsToBeDeleted;

    int[][] getGenerationBoard() {
        return generationBoard;
    }

    int[][] getGeneratedBoard() {
        return generatedBoard;
    }

    private int[][] cleanBoard() {
        int[][] cleanGenerationBoard = {
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
        return cleanGenerationBoard;
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
        return true;
    }

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


    protected void fieldDeletion(int difficultyLevel) {

            for(int row=0; row!=9; ++row) {
                for (int i = 0; i <= difficultyLevel; ++i) {
                    int randColumn = rand.nextInt(9);
                    if (generatedBoard[row][randColumn] != 0) {
                        //System.out.print(randColumn+" ");
                        generatedBoard[row][randColumn] = 0;
                        numberOfFieldsToBeDeleted--;
                    } else
                        numberOfFieldsToBeDeleted++;
                }
            }
    }


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
