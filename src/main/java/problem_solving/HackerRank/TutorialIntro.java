package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class TutorialIntro {

    public static void main(String[] args) {
        System.out.println(introTutorial(4, Arrays.asList(1, 4, 5, 7, 9, 12) ));
    }


    public static int introTutorial(int V, List<Integer> arr) {
        // Write your code here

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == V){
                return i;
            }
        }
        throw new IllegalArgumentException("Should Never Rich here");
    }
}
