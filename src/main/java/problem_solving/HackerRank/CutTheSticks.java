package problem_solving.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutTheSticks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(cutTheSticks(new int[]{5, 4, 4, 2, 2, 8})));
    }

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        List<Integer> result = new ArrayList<>();
        while (true){
            if (arr.length==0) break;
            int min = findMin(arr);
            result.add(arr.length);
            arr = Arrays.stream(arr).map(i->i-min).filter(el->el>0).toArray();   // complexity: O(n^2)
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private static int findMin(int[] arr) {
        return Arrays.stream(arr).min().orElseThrow(RuntimeException::new);
    }


}
