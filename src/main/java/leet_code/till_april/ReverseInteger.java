package leet_code.till_april;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(-2_147_483_647));
    }


//    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
//    -2,147,483,647 to 2,147,483,647


    public static int reverse(int x) {

        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            if (Integer.MAX_VALUE / 10 < rev || (Integer.MAX_VALUE / 10 == rev && pop > 7)) return 0;
            if (Integer.MIN_VALUE / 10 > rev || (Integer.MIN_VALUE / 10 == rev && pop < -8)) return 0;
            rev = rev * 10 + pop;
            x /= 10;
        }
        return rev;
    }
}
