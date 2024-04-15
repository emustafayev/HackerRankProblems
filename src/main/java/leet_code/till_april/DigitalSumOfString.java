package leet_code.till_april;

public class DigitalSumOfString {

    public static void main(String[] args) {

        String s = "11111222223";
        int k = 3;

        System.out.println(digitSum(s, k));

    }

    public static String digitSum(String s, int k) {

        if (s.length() <= k) return s;

        String newS = "";
        for (int i = 0; i < s.length(); i += k)
            newS = newS.concat(sumDigits(i + k <= s.length() ? s.substring(i, i + k) : s.substring(i)));
        return digitSum(newS, k);
    }

    private static String sumDigits(String s) {
        return String.valueOf(
                s
                        .chars()
                        .map(c -> c - '0')
                        .sum()
        );

    }
}
