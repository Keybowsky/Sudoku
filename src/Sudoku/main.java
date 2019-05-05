package Sudoku;

public class main {

    //Szybki test

    public static void main(String[] args) {

        /*

        int tablica [][]={
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9},
        };

        int najtrudniejszeSudokuNaŚwiecie [][]={        //przynajmniej wg google
                {8,0,0,0,0,0,0,0,0},
                {0,0,3,6,0,0,0,0,0},
                {0,7,0,0,9,0,2,0,0},
                {0,5,0,0,0,7,0,0,0},
                {0,0,0,0,4,5,7,0,0},
                {0,0,0,1,0,0,0,3,0},
                {0,0,1,0,0,0,0,6,8},
                {0,0,8,5,0,0,0,1,0},
                {0,9,0,0,0,0,4,0,0},
        };


            System.out.print("tablica:");
            for (int i=0; i<9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(tablica[i][j] + "  ");
                }
                System.out.println();
            }

            Solver solver1 = new Solver(tablica);
            Solver solver2 = new Solver(najtrudniejszeSudokuNaŚwiecie);

            solver1.solve();

            tablica = solver1.getBoardToSolve();

            System.out.println();
            System.out.println();

            System.out.print("tablica rozw?:");
            for (int i=0; i<9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(tablica[i][j] + "  ");
                }
                System.out.println();
            }

            solver2.solve();

            najtrudniejszeSudokuNaŚwiecie = solver2.getBoardToSolve();

            System.out.println();
            System.out.println();
            System.out.print("najtrudniejsze:");
            for (int i=0; i<9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(najtrudniejszeSudokuNaŚwiecie[i][j] + "  ");
                }
                System.out.println();
            }

            System.out.println();


        */
        Generator generator = new Generator();

        generator.boardGeneration();

        int[][] tablicaZKtorejGenerowano = generator.getGenerationBoard();
        int[][] wygenerowanaTabica = generator.getGeneratedBoard();

        Solver solver3 = new Solver(wygenerowanaTabica);

        solver3.solve();

        int[][] rozwiazanie = solver3.getBoardToSolve();


        System.out.print("tablica z ktorej generowano:");
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(tablicaZKtorejGenerowano[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        System.out.print("wygenerowana tablica:");
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(wygenerowanaTabica[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        System.out.print("rozwiazana tablica:");
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(rozwiazanie[i][j] + "  ");
            }
            System.out.println();
        }



    }
}



