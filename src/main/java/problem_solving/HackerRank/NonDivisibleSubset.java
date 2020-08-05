package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NonDivisibleSubset {
    public static void main(String[] args) { // 278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436
        System.out.println(nonDivisibleSubset(4, Arrays.asList(19,10,12,10,24,25,22)));
    }


    static class Pair{
        public final int a;
        public final int b;
        public final int sum;

        Pair(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    ", sum=" + sum +
                    '}';
        }
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here
        List<Pair> pairs = IntStream.range(0, s.size()).boxed().flatMap(i ->
                IntStream.range(i + 1, s.size())
                        .mapToObj(j -> new Pair(s.get(i), s.get(j), s.get(i) + s.get(j))))
                .collect(Collectors.toList());

        System.out.println(pairs.toString());
        return (int)pairs.stream()
                .flatMap(p-> (p.a%k + p.b%k) != k ? Stream.of(p.a,p.b) : Stream.of(-1)).filter(a->a != -1)
                .distinct()
                .count();
    }
}
