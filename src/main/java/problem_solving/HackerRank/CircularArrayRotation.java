package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CircularArrayRotation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(circularArrayRotation(new int[]{1, 2, 3}, 2, new int[]{0, 1, 2})));
    }

    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        int[] rotatedArr = new int[a.length];
        IntStream.range(0,a.length).forEach(i->{
            rotatedArr[(i+k)%a.length] = a[i];
        });
        System.out.println(Arrays.toString(rotatedArr));
        return Arrays.stream(queries).map(q->rotatedArr[q]).toArray();
    }
}
