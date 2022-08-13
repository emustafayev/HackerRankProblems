package algorithms.backtracking;

public class KNightTour {
    static int N = 8;


    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
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

    static boolean solveKT(int startPoint_x, int startPoint_y) {
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = -1;

        /* xMove[] and yMove[] define next move of Knight.
           xMove[] is for next value of x coordinate
           yMove[] is for next value of y coordinate */
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2}; // read as couple. Knight
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};


        // Since the Knight is initially at the first block
        board[startPoint_x][startPoint_y] = 0;

        /* Start from 0,0 and explore all tours using
           solveKTUtil() */

        if (!solveKTUtil(startPoint_x, startPoint_y, 1, board, xMove, yMove))
            return false;
        else printSolution(board);

        return true;
    }


    /* A recursive utility function to solve Knight
       Tour problem */
    private static boolean solveKTUtil(int x, int y, int moveIndex, int[][] board, int[] xMove, int[] yMove) {
        if (moveIndex == N * N)
            return true;

        int nextX, nextY;

        for (int k = 0; k < 8; k++) {
            nextX = x + xMove[k];
            nextY = y + yMove[k];

            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveIndex;
                if (solveKTUtil(nextX,nextY, moveIndex + 1, board, xMove, yMove)){
                    return true;
                }else
                    board[nextX][nextY] = -1; // backtrack if solveKTUtil returns false
                    //return false;

            } //else return false;
        }
        return false;
    }

    public static void main(String[] args) {
        solveKT(5,7);
    }

}
