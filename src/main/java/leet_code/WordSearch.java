package leet_code;

import java.util.Arrays;

public class WordSearch {

    public static void main(String[] args) {
//        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCB"));
//        System.out.println(exist(new char[][]{{'a'}},"a"));
    }


    public static boolean  exist(char[][] board, String word) {

        int runner = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean res = backtracking(board, visited, word, runner, i, j);
                if (res) return true;
            }
        }
        return false;
    }

    private static int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static boolean backtracking(char[][] board, boolean[][] visited, String word, int runner, int i, int j) {
        if (runner == word.length()) return true;
        if (word.charAt(runner) != board[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        System.out.println(Arrays.deepToString(visited));
        runner++;
        for (int[] direction : directions) {
            if (moveAble(board, direction, i, j)) {
                if (backtracking(board, visited, word, runner,
                        i + direction[0], j + direction[1])) {
                    return true;
                }
            }
        }
        visited[i][j]=false;
        return false;
    }

    private static boolean moveAble(char[][] board, int[] direction, int i, int j) {
        return i + direction[0] >= 0 && i + direction[0] < board.length &&
                j + direction[1] >= 0 && j + direction[1] < board[0].length;
    }

}
