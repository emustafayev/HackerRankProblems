package problem_solving.HackerRank;

import java.util.stream.IntStream;

public class MinimumDistances {
    public static void main(String[] args) {
        System.out.println(minimumDistances(new int[]{3,2,1,2,3}));
    }

    static int minimumDistances(int[] a) {
        return IntStream.range(0,a.length).flatMap(i->
                IntStream.range(i+1,a.length).map(j->{
                    if (a[i] == a[j]) return j-i;
                    else return -1;
                })).filter(i->i>0).min().orElse(-1);
    }
}
