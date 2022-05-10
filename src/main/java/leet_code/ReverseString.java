package leet_code;

public class ReverseString {
    public static void main(String[] args) {

//        char[] chars = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] chars = new char[]{'H','a','n','n','a','h'};
        reverseString(chars);
        System.out.println(chars);

    }


    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        swap(s,left,right);
    }

    private static void swap(char[] s, int left, int right) {
        if (left >= right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        swap(s, left+1, right-1);
    }

}
