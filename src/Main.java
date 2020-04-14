/**
 * Sudoku text solver.
 * Methods needed:
 *      -Main
 *      -Backtracking Solver
 *      -Stochastic Search Solver
 *      -Print board
 *      -Validation Method (used for testing)
 */

public class Main {

    static int NUM = 9;

    public static boolean isValid( int[][] matrix, int row, int col, int val ) {

        for( int i = 0; i < NUM; i++ ) {
            if( ( ( i != col ) && (matrix[row][i] == val) ) ||
                    ( ( i != row ) && (matrix[i][col] == val ) ) ) {
                return false;
            }
        }
        return true;
    }

    public static void backtrack( int[][] matrix, int row, int col ) {

        for( int i = 1; i <= 9; i++ ) {
            if( isValid(matrix, row, col, i ) ) {
                matrix[row][col] = i;
            }
        }

    }

    public static int[][] backtrackSolver( int[][] matrix ) {

        for( int i = 0; i < NUM; i++ ) {
            for( int j = 0; j < NUM; j++ ) {
                if( matrix[i][j] == 0 ) {
                    backtrack(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    public static void printer( int[][] matrix ) {

        for( int i = 0; i < NUM; i++ ) {
            for( int j = 0; j < NUM; j++ ) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {

        int[][] board = {   {0, 0, 0, 2, 6, 0, 7, 0, 1},
                            {6, 8, 0, 0, 7, 0, 0, 9, 0},
                            {1, 9, 0, 0, 0, 4, 5, 0, 0},
                            {8, 2, 0, 1, 0, 0, 0, 4, 0},
                            {0, 0, 4, 6, 0, 2, 9, 0, 0},
                            {0, 5, 0, 0, 0, 3, 0, 2, 8},
                            {0, 0, 9, 3, 0, 0, 0, 7, 4},
                            {0, 4, 0, 0, 5, 0, 0, 3, 6},
                            {7, 0, 3, 0, 1, 8, 0, 0, 0} };
        int[][] solved;

        System.out.println("Original (incomplete) board:");
        printer(board);
        solved = backtrackSolver( board );
        System.out.println("\nSolved board:");
        printer(solved);


    }

}
