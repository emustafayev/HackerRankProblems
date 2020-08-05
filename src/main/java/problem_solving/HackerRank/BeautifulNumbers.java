package problem_solving.HackerRank;

import java.util.stream.IntStream;

public class BeautifulNumbers {
    public static void main(String[] args) {
        System.out.println(beautifulDays(20,23,6));
    }

    static int beautifulDays(int i, int j, int k) {
        return (int)IntStream.rangeClosed(i,j)
                .filter(d-> Math.abs(d-reverseDay(d))%k==0)
                .count();
    }

    private static int reverseDay(int d) {
        int reverse = 0;
        while (d>0){
            reverse=reverse*10+d%10;
            d/=10;
        }
        return reverse;
    }
}
