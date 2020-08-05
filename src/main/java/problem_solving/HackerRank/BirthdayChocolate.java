package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class BirthdayChocolate {
    public static void main(String[] args) {
        int d = 4;
        int m = 1;
        System.out.println(birthday(Arrays.asList(4),d,m));
    }

    private static int birthday(List<Integer> bars, int d, int m) {
        return (int)IntStream.rangeClosed(0,bars.size()-m)
                .mapToObj(index->adjust(bars,index,m))
                .filter(el->el==d)
                .count();
    }

    private static int adjust(List<Integer> bars, int index,int m){
        return IntStream.range(index,index+m)
                .boxed()
                .mapToInt(bars::get)
                .sum();
    }
}
