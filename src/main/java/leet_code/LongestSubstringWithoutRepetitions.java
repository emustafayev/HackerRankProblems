package leet_code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepetitions {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring("pwwkew"));

    }


    public static int lengthOfLongestSubstring(String s) {

        int l = 0;
        int len = 0;
        ArrayList<Character> set = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            System.out.println(set);
            while (set.contains(s.charAt(i))) {
                set.remove((Character) s.charAt(l));
                l++;
                System.out.println(l);
            }
            set.add(s.charAt(i));
            len = Math.max(len, i - l + 1);
        }

        return len;
    }
}
