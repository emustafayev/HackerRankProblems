package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SequenceEquation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutationEquation(new int[]{4, 3, 5, 1, 2})));
    }

    static int[] permutationEquation(int[] p) {
        return IntStream.rangeClosed(1,p.length)
                .map(i-> findIndex(findIndex(i,p),p))  //Complexity O(n^3)  not good :((
                .toArray();
    }

    private static int findIndex(int i, int[] p) {
        return IntStream.range(0,p.length).filter(j->p[j] == i)
                .findAny()
                .orElseThrow(RuntimeException::new)+1;
    }
}
