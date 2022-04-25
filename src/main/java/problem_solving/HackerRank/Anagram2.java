package problem_solving.HackerRank;

import java.util.Arrays;

public class Anagram2 {

    public static void main(String[] args) {

        System.out.println(anagram("aaabbb"));

    }


    public static int anagram(String s) {
        // Write your code here
        int len = s.length();
        if (len % 2 != 0) return -1;
        String s1 = s.substring(0,len/2).toLowerCase();
        String s2 = s.substring(len/2).toLowerCase();
        int[] arr = new int[26];

        for (int i = 0; i < len/2; i++) {
            arr[s1.charAt(i)%26]++;
            arr[s2.charAt(i)%26]--;
        }
        int sum = Arrays.stream(arr).filter(i -> i > 0).sum();
        return sum;

    }

}
