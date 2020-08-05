package problem_solving.HackerRank;

import java.util.Arrays;

public class BeautifulTriplets {
    public static void main(String[] args) {
        System.out.println(beautifulTriplets(3, new int[]{2, 2,3, 4, 5}));
    }

    /**
     *
     * @return
     */

    static int beautifulTriplets(int d, int[] arr) { // 1 2 4 5 7 8 10
        return (int)Arrays.stream(arr).filter(el->{
            if (contain(el+d,arr) && contain(el+2*d,arr)) return true;
            return false;
        }).count();
    }

    private static boolean contain(int element, int[] arr) {
        return Arrays.stream(arr).filter(el -> el==element).count() > 0;
    }
}
