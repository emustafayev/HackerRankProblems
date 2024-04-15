package leet_code.till_april;

import java.util.Arrays;
import java.util.List;

public class MaximumNumberVowelsSubstringGivenLength {

    /**
     * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
     * <p>
     * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s = "abciiidef", k = 3
     * Output: 3
     * Explanation: The substring "iii" contains 3 vowel letters.
     * Example 2:
     * <p>
     * Input: s = "aeiou", k = 2
     * Output: 2
     * Explanation: Any substring of length 2 contains 2 vowels.
     * Example 3:
     * <p>
     * Input: s = "leetcode", k = 3
     * Output: 2
     * Explanation: "lee", "eet" and "ode" contain 2 vowels.
     */

    public static void main(String[] args) {
        System.out.println(maxVowels2("abciiidef"
                , 3));
    }


    public static int maxVowels2(String s, int k) {
        List<Character> vovels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        int vCount = 0;


        for (int i = 0; i < k; i++)
            if (vovels.contains(s.charAt(i))) vCount++;

        int max = vCount;
        int left = 0;
        int right = k;

        while (right < s.length()) {
            if (vovels.contains(s.charAt(left))) vCount--;
            if (vovels.contains(s.charAt(right))) vCount++;
            left++;
            right++;
            max = Math.max(max, vCount);
        }

        return max;
    }

    public static int maxVowels(String s, int k) { // time limit exception
        //abciiidef
        List<Character> vovels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        int maxVovels = -1;
        for (int i = 0; i < s.length() - k + 1; i++) {
            int counter = i;
            int vovelCount = 0;
            while (counter < i + k) {
                if (vovels.contains(s.charAt(counter)))
                    vovelCount++;
                counter++;
            }
            if (maxVovels < vovelCount)
                maxVovels = vovelCount;
        }
        return maxVovels;
    }


}
