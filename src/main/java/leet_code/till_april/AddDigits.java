package leet_code.till_april;

public class AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }

    public static int addDigits(int num) {
        while (num / 10 > 0) {
            num = sumDigits(num);
        }
        return num;
    }

    private static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int addDigits2(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9; // math solution: for obtain 1 number digit, minus 1 divide by 9 (there will be mod of 0 to 8) and plus 1
    }
}
