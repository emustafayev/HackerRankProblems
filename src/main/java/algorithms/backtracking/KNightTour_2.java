package algorithms.backtracking;

public class KNightTour_2 {


    /**
     * Given a N*N board with the Knight placed on the first block of an empty board.
     * Moving according to the rules of chess knight must visit each square exactly once.
     * Print the order of each cell in which they are visited.
     */

    private static int N = 8;


    public static void main(String[] args) {

        solveKT(0,0);
    }

    /**
     * Check if next move safe
     *
     * @param x     X coordinate
     * @param y     Y coordinate
     * @param board Board
     */
    private static boolean isSafe(int x, int y, int[][] board) {
        return x >= 0 && x < N && y >= 0 && y < N
                && board[x][y] == -1;
    }

    /* A utility function to print solution
      matrix sol[N][N] */
    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    static void solveKT(int startPoint_x, int startPoint_y) {

        int[][] board = new int[N][N];

        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2}; // read as couple. Knight
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

        int moveIndex = 1;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = -1;


        board[startPoint_x][startPoint_y] = 0;

        if (solveKTUtil(board, startPoint_x, startPoint_y, moveIndex, xMove, yMove)) {
            System.out.println("Solution: ");
            printSolution(board);
        } else
            System.out.println("No solution exists");

    }

    private static boolean solveKTUtil(int[][] board, int x, int y, int moveIndex, int[] xMove, int[] yMove) {

        //success case
        if (moveIndex == N * N) return true;

        int nextX, nextY;

        for (int k = 0; k < xMove.length; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];
            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveIndex;
                if (solveKTUtil(board, nextX, nextY, moveIndex + 1, xMove, yMove))
                    return true; // success case for current level
                else board[nextX][nextY] = -1; // backtrack - invalidate recursion
            }
        }

        return false;
    }
}
