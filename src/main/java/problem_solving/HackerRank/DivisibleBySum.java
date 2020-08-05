package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DivisibleBySum {
    public static void main(String[] args) {
        int[] arr = {78, 93, 28, 4, 96, 99, 85, 30, 25, 30, 53, 81, 90, 63, 58, 99, 69, 20, 53, 33, 46, 31, 18, 58, 38, 29, 43, 30, 89, 57, 98, 11, 39, 38, 35, 23, 88, 64, 100, 44, 44, 23, 95, 21, 7, 96, 27, 79, 41, 40, 36, 49, 95, 44, 8 ,44,30, 34, 61, 34, 20, 92, 5, 24, 42, 49, 54, 89, 39 ,64, 44, 4 ,45, 74, 81, 20, 24, 97, 100, 84, 43, 88, 20, 83, 65, 64, 80, 16, 92, 56, 75, 13, 15, 68, 91, 4 ,89, 85, 25, 97};
        int k = 76;
        divisibleSumPairs(arr.length,k,arr);
    }

    static class Pairs{
        int i;
        int j;

        public Pairs(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "["+i+" "+j+"]";
        }
    }

    static void divisibleSumPairs(int n, int k, int[] ar) {
         IntStream.range(0,ar.length).boxed().flatMap(i->
                Arrays.stream(ar).mapToObj(item -> new Pairs(ar[i], item)))
                .filter(p->(p.i<p.j && (p.i+p.j)%k==0)).forEach(System.out::println);
    }
}
