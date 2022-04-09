package problem_solving.HackerRank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManasaAndStones2 {


    public static void main(String[] args) {
        System.out.println(stones(4, 10, 100));
    }


    private static List<Integer> stones(int n, int a, int b) {
        return stonesR(n,a,b,new HashSet<>(){{add(0);}})
                .stream()
                .sorted()
                .mapToInt(x -> x)
                .boxed()
                .collect(Collectors.toList());
    }

    static Set<Integer> stonesR(int n, int diff1, int diff2, Set<Integer> res){
        if (n == 1) return res;
        return stonesR(n - 1, diff1, diff2, res.stream()
                .flatMap(x -> Stream.of(x + diff1, x + diff2))
                .collect(Collectors.toSet()));
    }
}
