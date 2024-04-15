package leet_code.till_april;

public class IsSubsequence {

    public static boolean isSubsequence(String t, String s) {
        //  acd  abcde
        int sIndex = 0;
        int wIndex = 0;
        while (sIndex < s.length() && wIndex < t.length()) {
            if (t.charAt(wIndex) == s.charAt(sIndex)) {
                wIndex++;
            }
            sIndex++;
        }
        return wIndex == t.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc","ahbgdc"));
    }
}
