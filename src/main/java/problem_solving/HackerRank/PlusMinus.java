package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PlusMinus {
    public static void main(String[] args) {
        int[] arr = {-4, 3, -9,0, 4, 1};
        plusMinus(arr);
    }



    private static String adjust(int a){
        return a > 0 ? "P" : a < 0 ? "N" : "Z";
    }
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {

        Map<String, Long> pairs = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(PlusMinus::adjust, Collectors.counting()));

        System.out.println(String.format("%.6f",pairs.get("P")!=null?(float)pairs.get("P")/arr.length:0));
        System.out.println(String.format("%.6f",pairs.get("N")!=null?(float)pairs.get("N")/arr.length:0));
        System.out.println(String.format("%.6f",pairs.get("Z")!=null?(float)pairs.get("Z")/arr.length:0));
    }
}
