package leet_code;

public class LongestPalindromicSubstring {


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        String lps = "";

        for (int i = 0; i < s.length(); i++) {
            String odd = expandPalindrome(s,i,i);
            String even = expandPalindrome(s, i, i + 1);
            if (lps.length()  < odd.length()){
                lps = odd;
            }

            if (lps.length() < even.length()){
                lps = even;
            }

        }
        return lps;
    }
    // 1 <> 4

    private static String expandPalindrome(String s, int L, int R){
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
            System.out.println(L + " " + R);
        }
        return s.substring(L+1, R);
    }
}
