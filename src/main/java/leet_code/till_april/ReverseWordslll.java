package leet_code.till_april;

public class ReverseWordslll {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }


    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (String word :
                words) {
            sb.append(" ").append(reverseString(word));
        }
        return sb.toString().trim();
    }


    public static char[] reverseString(String str) {
        char[] s = str.toCharArray();
        int left = 0, right = s.length - 1;
        swap(s,left,right);
        return s;
    }

    private static void swap(char[] s, int left, int right) {
        if (left >= right) return;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        swap(s, left+1, right-1);
    }
}
