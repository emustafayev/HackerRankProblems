package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MigrationBirds {
    public static void main(String[] args) {
        int[] birds = {1,1,3,3,3,2,2,2,1,4,5};
        System.out.println(findBird(birds));
    }

    private static int findBird(int[] birds) {
        return Arrays.stream(birds).boxed().collect(Collectors.groupingBy(i -> i))
                .entrySet().stream()
                .sorted((e1,e2)->e2.getValue().size()-e1.getValue().size())
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(RuntimeException::new);
    }
}
