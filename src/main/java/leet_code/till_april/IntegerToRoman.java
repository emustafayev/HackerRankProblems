package leet_code.till_april;

public class IntegerToRoman {

    public static void main(String[] args) {
        int num = 347;
        System.out.println(intToRoman(num));
    }


    public static String intToRoman(int num) {

        String s = "";

        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < nums.length; i++) {  //347   // CCCXLVII
            // Go until we can divide;
            while (num / nums[i] > 0) { // 1. 347 / 100 ; while help to optimize, so we can use if too
                // How many times that digit can be divided?
                int romanDigit = num / nums[i];
                // Add repititions
                for (int j = 0; j < romanDigit; j++) {
                    s = s.concat(romans[i]);
                }
                // Pass to next number
                num = num % nums[i];
            }
        }
        return s;
    }
}
