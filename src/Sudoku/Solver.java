package Sudoku;

/*
Pierwsza wersja, potem dodam komentarze w javadocu co służy do czego.
 */

class Solver {

    private int [][] boardToSolve;

    private static final int SIZE = 9;
    private static final int SECTION_SIZE = 3;
    private static final int EMPTY_CELL = 0;


    Solver(int[][] boardToSolve) {
        this.boardToSolve = new int[SIZE][SIZE];

        for (int row=0; row<SIZE; row++)
            for (int column=0; column<SIZE; column++)
                this.boardToSolve[row][column] = boardToSolve[row][column];
    }


    int[][] getBoardToSolve() {
        return boardToSolve;
    }


    boolean check(int row, int column, int checkedNumber){

        boolean checkRow = true;
        boolean checkColumn = true;
        boolean checkSection = true;

        for (int i=0; i<SIZE; i++)
            if (boardToSolve[row][i]==checkedNumber)
                checkRow = false;

        for (int i=0; i<SIZE; i++)
            if (boardToSolve[i][column]==checkedNumber)
                checkColumn = false;

        int sectionRow = row - row%SECTION_SIZE;
        int sectionColumn = column - column%SECTION_SIZE;

        for (int i=sectionRow; i<sectionRow+SECTION_SIZE; i++) {
            for (int j = sectionColumn; j < sectionColumn + SECTION_SIZE; j++)
                if (boardToSolve[i][j] == checkedNumber)
                    checkSection = false;
        }

        return checkRow && checkColumn && checkSection;
    }


    boolean solve() {
        for (int row = 0; row < SIZE; row++)
            for (int column = 0; column < SIZE; column++)
                if (boardToSolve[row][column] == EMPTY_CELL) {
                    for (int number = 1; number <= SIZE; number++) {
                        if (check(row, column, number)) {
                            boardToSolve[row][column] = number;
                            if (solve()) {
                                return true;
                            } else {
                                boardToSolve[row][column] = EMPTY_CELL;
                            }
                        }
                    }
                    return false;
                }
        return true;
    }

}

