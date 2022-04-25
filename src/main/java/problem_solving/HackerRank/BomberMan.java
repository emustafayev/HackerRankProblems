package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class BomberMan {
    public static void main(String[] args) {

        bomberMan(3, Arrays.asList(".......", "...O...", "....O..",
         ".......", "OO.....", "OO....."));

    }

    public static List<String> bomberMan(int n, List<String> grid) {
        // Write your code here

        int[][] arrGrid = getArr(grid);


        if (n == 1) {
            printArrGrid(arrGrid);
            return null;
        } else if (n % 2 == 0) {
            // plant bombs
            for (int i = 0; i < arrGrid.length; i++) {
                for (int j = 0; j < arrGrid[0].length; j++) {
                    System.out.println("0");
                }
                System.out.println();
            }
            return null;
        }


        // n == 3 case
        for (int i = 0; i < arrGrid.length; i++) {
            for (int j = 0; j < arrGrid[0].length; j++) {
                if (arrGrid[i][j] == 1) {
                    arrGrid[i][j] = arrGrid[i + 1][j] = arrGrid[i][j + 1] = arrGrid[i - 1][j] = arrGrid[i][j - 1] = 0;
                }
                if (arrGrid[i][j] == 3) {
                    arrGrid[i][j] = 2;
                }
            }
        }

        if (n % 4 == 3) {  //if (N % 4 == 3)
            for (int i = 0; i < arrGrid.length; i++) {
                for (int j = 0; j < arrGrid[0].length; j++) {
                    if (arrGrid[i][j] == 1) {
                        arrGrid[i][j] = arrGrid[i + 1][j] = arrGrid[i][j + 1] = arrGrid[i - 1][j] = arrGrid[i][j - 1] = 0;
                    }
                    if (arrGrid[i][j] == 3) {
                        arrGrid[i][j] = 2;
                    }
                }
            }
        }

        printArrGrid(arrGrid);

        throw new IllegalArgumentException("Not impl yet");

    }

    private static void printArrGrid(int[][] arrGrid) {
        for (int i = 0; i < arrGrid.length; i++) {
            for (int j = 0; j < arrGrid[0].length; j++) {
                if (arrGrid[i][j] != 0) {
                    System.out.print(".");
                } else System.out.print("O");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] getArr(List<String> grid) {
        int[][] arrGrid = new int[grid.size()][grid.get(0).length()];

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(0).length(); j++) {
                if ((int) grid.get(i).charAt(j) == 79) {
                    arrGrid[i][j] = 3;
                } else arrGrid[i][j] = 0;
            }
        }
        return arrGrid;
    }

}
