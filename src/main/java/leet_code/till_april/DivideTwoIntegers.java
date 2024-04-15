package leet_code.till_april;

public class DivideTwoIntegers {

    public static void main(String[] args) {

    }

//    Given two integers dividend and divisor, divide two integers without
//    using multiplication, division, and mod operator.
//
//    The integer division should truncate toward zero, which means losing its fractional part.
//    For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
//
//    Return the quotient after dividing dividend by divisor.
//
//    Note: Assume we are dealing with an environment that
//    could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem,
//    if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly
//    less than -231, then return -231.
//


    public int divide(int A, int B) {

        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x;

        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;


    }
}
