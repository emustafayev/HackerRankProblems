package leet_code;

public class MaximumMatrixSum {


//    You are given an n x n integer matrix. You can do the following operation any number of times:
//
//    Choose any two adjacent elements of matrix and multiply each of them by -1.
//    Two elements are considered adjacent if and only if they share a border.
//
//    Your goal is to maximize the summation of the matrix's elements.
//    Return the maximum sum of the matrix's elements using the operation mentioned above.
//


    public static void main(String[] args) {

        System.out.println(maxMatrixSum(new int[][]{{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}}));
    }

    public static long maxMatrixSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        int countNeg = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(matrix[i][j]);
                if (Math.abs(matrix[i][j]) < min) min = Math.abs(matrix[i][j]); // find min

                if (matrix[i][j] < 0) countNeg++;
            }
        }
        if (countNeg % 2 == 0) return sum;
        return sum - 2L * min; // because we already sum the min value we minus 2 times
    }
}
