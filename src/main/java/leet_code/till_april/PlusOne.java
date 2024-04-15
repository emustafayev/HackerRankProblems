package leet_code.till_april;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{
                9, 9
        })));
    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + 1 == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] newRes = new int[digits.length + 1];
                    newRes[0] = 1;
                    return newRes;
                }
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }

        return digits;
    }
}
