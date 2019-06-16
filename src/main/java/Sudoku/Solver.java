package Sudoku;


/**
 * Obiekt klasy Solver rozwiazuje zadana mu tablice i zwraca rozwiazanie.
 */

class Solver {

    /** Tablica do rozwiazania. */
    private int [][] boardToSolve;

    /** Standardowa ilosc elementow w rzedzie lub kolumnie. */
    static final int SIZE = 9;

    /** Standardowa ilosc elementow w jednej sekcji. */
    private static final int SECTION_SIZE = 3;

    /** Standardowa wartosc nierozwiazanej komorki. */
    private static final int EMPTY_CELL = 0;


    /** Konstruktor tworzacy nowa tabele boardToSolve i przypisujacy jej odpowiednie wartosci.
     *
     * @param boardToSolve Tablica do rozwiazania.
     *
     * */

    Solver(int[][] boardToSolve) {
        this.boardToSolve = new int[SIZE][SIZE];
            this.boardToSolve = boardToSolve;
    }

    /** Zwraca aktualna tablice BoardToSolve.
     *
     * @return tablica do rozwiazania.
     *
     * */
    int[][] getBoardToSolve() {
        return boardToSolve;
    }

    /** Sprawdza czy zadana liczba w danym rzedzie, kolumnie i odpowiadajacej im sekcji sie nie powtarza.
     *
     * @param row Numer sprawdzanego rzedu.
     * @param column Numer sprawdzanej kolumny.
     * @param checkedNumber Sprawdzana liczba.
     * @return true jezeli numer nie powtarza sie w rzedzie, kolumnie i sekcji.
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
     * Rozwiazuje zadana tablice metoda rekurencyjna.
     *
     * Dwie pierwsze petle for odpowiadaja za iteracje po wszystkich komorkach, nastepnie sprawdzane jest
     * czy dana komorka nie posiada przypisanej wartosci rcznej od 0. Jezeli posiada zwracany jest false,
     * i wykonane jest przejscie do nastepnej komorki.
     *
     * Jezeli wartosc komorki wynosi EMPTY_CELL nastepuje iteracja po numerach od 1 do 9.
     * Po kazdej iteracji sprawdzane jest czy dany numer moze sie znajdowac w tej komorce (nie powtarza sie
     * w danym rzedzie, kolumnie i sekcji) za pomoca metody check. Jezeli liczba sie powtarza wartosc komorki
     * ustawiana jest na EMPTY_CELL. Jezeli wartosc sie nie powtarza komorce przypisana zostaje wartosc
     * number i wywolywana rekurencyjnie zostaje nastepna metoda solve. Dopiero gdy wszystkie wywolane metody solve
     * zwrcca wartosc true tablica jest uznana za rozwiazana.
     *
     * @return true jezeli tablica zostala rozwiazana.
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
     * Funkcja wywolujaca funkcje solve. Rozwiazuje i zwraca rozwiazana tablice.
     *
     * @param boardToSolve Tablica do rozwiazania.
     * @return Rozwiazana tablica.
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

