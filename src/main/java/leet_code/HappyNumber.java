package leet_code;

import java.util.ArrayList;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappy2(19));
    }

    public static boolean isHappy(int n) {

        var seen = new ArrayList<Integer>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = calculateHappy(n);
            System.out.println(n);
        }
        return n == 1;
    }

    private static int calculateHappy(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }


    public static boolean isHappy2(int n) {
        if ((n == 1) || (n == 7)) {
            return true;
        } else if (n < 10) {
            return false;
        }
        return isHappy2(calculateHappy(n));
    }
}
