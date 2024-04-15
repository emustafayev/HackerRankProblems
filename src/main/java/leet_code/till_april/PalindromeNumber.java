package leet_code.till_april;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(-101));
    }


    public static boolean isPalindrome(int x) {
        String number = String.valueOf(x);
        int length = number.length();
        boolean palindrome = true;
        for (int i = 0; i < length; i++) {
            if (number.charAt(i) != number.charAt(length - i - 1)) {
                palindrome = false;
            }
        }
        return palindrome;
    }

    public static boolean isPalindrome2(int x) {
        long reverse = 0;

        for (int i = x; i > 0; i = i / 10) {
            int ld = i % 10;
            reverse = reverse * 10 + ld;
        }
        return reverse == x;
    }
}
