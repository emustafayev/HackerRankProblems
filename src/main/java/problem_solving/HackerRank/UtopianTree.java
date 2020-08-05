package problem_solving.HackerRank;

import java.util.stream.IntStream;


public class UtopianTree {
    public static void main(String[] args) {
        System.out.println(utopianTree(5));
    }

    static int utopianTree(int n) {
        int[] height = {0};
        IntStream.rangeClosed(0,n).forEach(i->{
            height[0]= i%2==0?height[0]+1:height[0]*2;
        });
        return height[0];
    }

}
