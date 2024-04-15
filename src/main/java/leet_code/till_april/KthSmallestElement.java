package leet_code.till_april;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Object> objects = new PriorityQueue<>();

        var array = new int[matrix.length * matrix.length];
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i * n + j] = matrix[i][j];
            }
        }

        Arrays.sort(array);
        System.out.println(array);


        return array[k];
    }
}
