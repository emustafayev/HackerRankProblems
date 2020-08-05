package problem_solving.HackerRank;

import java.math.BigInteger;

public class ExtraLongFactorials {
    public static void main(String[] args) {
        extraLongFactorial(30);
    }

    static void extraLongFactorial(int n){
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println(result);
    }
}
