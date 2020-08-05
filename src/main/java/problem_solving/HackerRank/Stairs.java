package problem_solving.HackerRank;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stairs {
    public static void main(String[] args) {
        buildStairs(6);
    }

    private static void buildStairs(int n){
        System.out.println(IntStream.range(0, n)
                .boxed().flatMap(x ->
                        IntStream.range(0, n ).mapToObj(y -> refactor(x,y,n)))
                .collect(Collectors.joining()));
    }

    private static String refactor(int x,int y, int n){
       return y < (n - x - 1) ? " " : y != n-1 ? "#" : "#\n";
    }
}
