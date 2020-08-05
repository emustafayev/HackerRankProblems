package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FairRatios {
    public static void main(String[] args) {

    }

    static int fairRations(int[] B) {
        int sum = Arrays.stream(B).sum();
        int [] count = {0};
        if (sum%2 != 0) return -1;
        IntStream.range(0,B.length-1).forEach(i->{
            if (B[i]%2 != 0){
                B[i] = B[i]+1;
                B[i+1] = B[i+1]+1;
                count[0]+=2;
            }
        });
        return count[0];
    }
}
