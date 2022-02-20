package leet_code;

public class IntegerToRoman {

    public static void main(String[] args) {
        int num = 347;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        while (num > 0) {


            int last = num % 10;

            System.out.println(last);

            num = num / 10;
        }

        return null;
    }
}
