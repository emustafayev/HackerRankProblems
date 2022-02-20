package leet_code;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> h = new HashMap<>();

        h.put('I', 1);
        h.put('V', 5);
        h.put('X', 10);
        h.put('L', 50);
        h.put('C', 100);
        h.put('D', 500);
        h.put('M', 1000);


        char[] romans = s.toCharArray();

        int sum1 = 0;

        int previousInteger = h.get(romans[romans.length - 1]);
        sum1 += previousInteger;

        for (int i = romans.length - 2; i >= 0; i--) { // LVIII   ==> 58; LIV ==> 54
            int currentInteger = h.get(romans[i]);
            if (currentInteger < previousInteger){
                sum1 -= currentInteger;
            }else {
                sum1 += currentInteger;
            }
            previousInteger = currentInteger;
        }



        // Easy and hardcoded solution
        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");

        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");

        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");

        int sum2 = 0;
        for (char ch : romans) {
            sum2 += h.get(ch);
        }

        return sum1;
    }
}
