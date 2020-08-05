package problem_solving.HackerRank;

import java.util.*;
import java.util.stream.Collectors;

public class PickingNumbers {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(4, 2, 3, 4, 4, 9, 98, 98, 3, 3, 3, 4, 2, 98, 1, 98, 98, 1, 1, 4, 98, 2, 98, 3, 9, 9, 3, 1, 4, 1, 98, 9, 9, 2, 9, 4, 2, 2, 9, 98, 4, 98, 1, 3, 4, 9, 1, 98, 98, 4, 2, 3, 98, 98, 1, 99, 9, 98, 98, 3, 98, 98, 4, 98, 2, 98, 4, 2, 1, 1, 9, 2, 4);
        System.out.println(pickingNumbers(a));
    }

    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, List<Integer>> map = a.stream().collect(Collectors.groupingBy(i -> i));
        System.out.println(map.toString());

        List<Integer> collect = new HashSet<>(a).stream().sorted()
                .map(i -> neighboursCount(i, map)).collect(Collectors.toList());
        System.out.println(collect.toString());

        return collect.stream().max(Comparator.comparingInt(i -> i))
                .orElseThrow(RuntimeException::new);
    }

    private static int neighboursCount(Integer i, Map<Integer, List<Integer>> map) {
        int withPrevious = getMapElement(i, map)+getMapElement(i-1,map);
        int withNext = getMapElement(i,map)+getMapElement(i+1,map);
        return  Math.max(withNext,withPrevious);
    }

    private static int getMapElement(Integer i, Map<Integer, List<Integer>> map) {
        try{
            return map.get(i).size();
        }catch (NullPointerException e){
            return 0;
        }
    }
}
