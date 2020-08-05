package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManasaAndStones {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(stones(4, 10, 100)));

        Set<Integer> s = new HashSet<>(Arrays.asList(1,2));
        System.out.println(s.stream().flatMap(x->Stream.of(x+1,x+2)).collect(Collectors.toList()).toString());
        System.out.println(Stream.of(1,2,3).collect(Collectors.toList()));
        Stream<Integer> integerStream = s.stream().flatMap(x -> Stream.of(x + 3, x + 4));
    }

    static int[] stones(int n, int a, int b){
       return stonesR(n,a,b,new HashSet<Integer>(){{ add(0); }})
       .stream()
       .sorted()
       .mapToInt(x->x)
       .toArray();
    }

    private static Set<Integer> stonesR(int n, int dif1, int dif2, Set<Integer> curr){
        if (n-1==0) return curr;
        return stonesR(n-1,dif1,dif2,curr.stream()
                .flatMap(x-> Stream.of(x+dif1,x+dif2))
                .collect(Collectors.toSet())
        );
    }
}
