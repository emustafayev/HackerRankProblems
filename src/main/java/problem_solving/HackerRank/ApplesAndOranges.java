package problem_solving.HackerRank;

import java.util.Arrays;

public class ApplesAndOranges {
    public static void main(String[] args) {
        int[] apples = {-2,2,3,5,4,1};
        int[] oranges = {5,-6,-7,-8,-9};
        countApplesAndOranges(7,11,5,15,apples,oranges);
    }

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        System.out.println(Arrays.stream(apples).boxed()
                .mapToInt(apple ->check(s,t,apple,a))
                .sum());

        System.out.println(Arrays.stream(oranges).boxed()
                .mapToInt(orange -> check(s, t, orange, b))
                .sum());
    }

    private static int check(int s,int t,int locFallenFruit, int fruit){
        return (fruit + locFallenFruit) >= s && (fruit + locFallenFruit) <= t ? 1 : 0;
    }
}
