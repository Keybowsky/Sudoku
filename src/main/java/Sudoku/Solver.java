package Sudoku;


/**
 * Obiekt klasy Solver rozwiązuje zadaną mu tablice i zwraca rozwiązanie.
 */

class Solver {

    /** Tablica do rozwiązania. */
    private int [][] boardToSolve;

    /** Standardowa ilość elementów w rzędzie lub kolumnie. */
    static final int SIZE = 9;

    /** Standardowa ilość elementów w jednej sekcji. */
    private static final int SECTION_SIZE = 3;

    /** Standardowa wartość nierozwiązanej komórki. */
    private static final int EMPTY_CELL = 0;


    /** Konstruktor tworzący nową tabele boardToSolve i przypisujący jej odpowiednie wartości.
     *
     * @param boardToSolve Tablica do rozwiązania.
     *
     * */

    Solver(int[][] boardToSolve) {
        this.boardToSolve = new int[SIZE][SIZE];
            this.boardToSolve = boardToSolve;
    }

    /** Zwraca aktualną tablicę BoardToSolve. */
    int[][] getBoardToSolve() {
        return boardToSolve;
    }

    /** Sprawdza czy zadana liczba w danym rzędzie, kolumnie i odpowiadającej im sekcji się nie powtarza.
     *
     * @param row Numer sprawdzanego rzędu.
     * @param column Numer sprawdzanej kolumny.
     * @param checkedNumber Sprawdzana liczba.
     * @return true jeżeli numer nie powtarza się w rzędzie, kolumnie i sekcji.
     *
     * */
    private boolean check(int row, int column, int checkedNumber){

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

    /**
     * Rozwiązuje zadaną tablice metodą rekurencyjną.
     *
     * Dwie pierwsze pętle for odpowiadają za iteracje po wszystkich komórkach, następnie sprawdzane jest
     * czy dana komórka nie posiada przypisanej wartości różnej od 0. Jeżeli posiada zwracany jest false,
     * i wykonane jest przejście do następnej komórki.
     *
     * Jeżeli wartość komórki wynosi EMPTY_CELL następuje iteracja po numerach od 1 do 9.
     * Po każdej iteracji sprawdzane jest czy dany numer może się znajdować w tej komórce (nie powtarza się
     * w danym rzędzie, kolumnie i sekcji) za pomocą metody check. Jeżeli liczba się powtarza wartość komórki
     * ustawiana jest na EMPTY_CELL. Jeżeli wartość się nie powtarza komórce przypisana zostaje wartość
     * number i wywoływana rekurencyjnie zostaje następna metoda solve. Dopiero gdy wszystkie wywołane metody solve
     * zwrócą wartość true tablica jest uznana za rozwiązaną.
     *
     * @return true jeżeli tablica została rozwiązana.
     *
     * */
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

    /**
     * Funkcja wywołująca funkcję solve. Rozwiązuje i zwraca rozwiązaną tablicę.
     *
     * @param boardToSolve Tablica do rozwiązania.
     * @return Rozwiązana tablica.
     *
     * */
    static int[][] solveTheBoard(int[][] boardToSolve){
       Solver boardSolver = new Solver(boardToSolve);
       boardSolver.solve();
       int[][] solvedBoard;
       solvedBoard = boardSolver.getBoardToSolve();
       return solvedBoard;
    }
}

