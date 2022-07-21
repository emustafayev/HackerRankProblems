package leet_code;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class MatchingSubsequences {

    public static void main(String[] args) {
        String s = "dsahjpjauf";
//        var words = new String[]{"a", "bb", "acd", "ace"};
        var words = new String[]{"ahjpjau", "ahjpjau", "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax", "tnmlanowax", "tnmlanowax"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {

        return Arrays
                .stream(words)
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet()
                .stream()
                .map((m) -> check(s, m.getKey()) ? m.getValue() : 0)
                .reduce(Long::sum)
                .get()
                .intValue();
    }

    private static boolean check(String s, String word) {
        //  acd  abcde
        int sIndex = 0;
        int wIndex = 0;
        while (sIndex < s.length() && wIndex < word.length()) {
            if (word.charAt(wIndex) == s.charAt(sIndex)) {
                wIndex++;
            }
            sIndex++;
        }
        return wIndex == word.length();
    }
}
