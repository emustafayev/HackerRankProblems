package leet_code;

import java.util.Arrays;

public class TwoStringsAreClose {

    public static void main(String[] args) {
        System.out.println(closeStrings(
                "abc",
                "bca"
        ));
    }


//    Input: word1 = "abc", word2 = "bca"
//    Output: true
//    Explanation: You can attain word2 from word1 in 2 operations.
//    Apply Operation 1: "abc" -> "acb"
//    Apply Operation 1: "acb" -> "bca"

    public static boolean closeStrings(String word1, String word2) {

        int[] freq1 = new int[26]; // and occurrences should be same amount
        int[] freq2 = new int[26];
        int []visited1 = new int[26]; // if one have a letter that another one don't, return false
        int []visited2 = new int[26];

        for(char ch : word1.toCharArray()){
            freq1[ch-'a']++;
            visited1[ch-'a'] = 1;
        }

        for(char ch : word2.toCharArray()){
            freq2[ch-'a']++;
            visited2[ch-'a'] = 1;
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(visited1, visited2) && Arrays.equals(freq1, freq2);
    }
}
