package leet_code.till_april;

public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("00000-42a1234"));
    }

//    Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).
//
//            The algorithm for myAtoi(string s) is as follows:
//
//    Read in and ignore any leading whitespace.
//            Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
//    Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
//    Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
//    If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//    Return the integer as the final result.


    public static int myAtoi(String s) {
        int result = 0;
        boolean positive = true;
        boolean started = false;

        int pop;//check

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);

            if (index == 32 && !started) {
                System.out.println("continue for whitespace");
                continue;
            }

            if ((index == 45 || index == 43) && !started) {
                positive = index != 45;
                started = true;
                System.out.println("continue for negativity");
                continue;
            }

            if (!(index > 47 && index < 58)) {
                System.out.println(index + " ->" + (char)index);
                System.out.println("break for non digit character");
                break;
            }

            pop = s.charAt(i) - '0';

            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && pop > 7
                    || result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && pop < -8) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + pop;
            started = true;
        }
        return positive ? result : result * -1;
    }
}
