package problem_solving.HackerRank;

import java.util.Arrays;

public class ElectronicsBook {
    public static void main(String[] args) {
        System.out.println(getMoneySpent(new int[]{3,1},new int[]{5,2,8},3));
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        return Arrays.stream(keyboards).flatMap(keyboard->
                    Arrays.stream(drives).map(drive -> keyboard + drive))
                        .filter(p->p<=b)
                        .max().orElse(-1);
    }
}
