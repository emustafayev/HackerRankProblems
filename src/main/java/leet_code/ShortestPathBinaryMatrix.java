package leet_code;

import java.util.ArrayDeque;

public class ShortestPathBinaryMatrix {

    /**
     * Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
     * <p>
     * A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
     * <p>
     * All the visited cells of the path are 0.
     * All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
     * The length of a clear path is the number of visited cells of this path.
     */


    public static void main(String[] args) {

        //[0,0,0],[1,1,0],[1,1,1]


//        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}}));
//
//        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
//        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}}));

        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));

    }


    public static int shortestPathBinaryMatrix(int[][] grid) {

            if (grid[0][0] == 1) return -1;

            var moves = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

            var n = grid.length;
            var seen = new boolean[n][n];
            var queue = new ArrayDeque<int[]>();
            queue.offer(new int[]{0, 0});

            for (var cnt = 1; !queue.isEmpty(); cnt++) {
                for (var i = queue.size(); i > 0; i--) {
                    var cell = queue.poll();

                    if (cell[0] == n - 1 && cell[1] == n - 1)
                        return cnt;

                    for (var move : moves) {
                        var x = cell[0] + move[0];
                        var y = cell[1] + move[1];

                        if (x >= 0 && x < n && y >= 0 && y < n && !seen[x][y] && grid[x][y] == 0) {
                            seen[x][y] = true;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
            return -1;
        }


    }
