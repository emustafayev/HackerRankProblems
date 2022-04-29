package problem_solving.HackerRank;

public class Pangram {

    public static void main(String[] args) {
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));
    }

    public static String pangrams(String s) {
        // Write your code here

        String el = s.toLowerCase().replace(" ","");

        int[] arr = new int[26];

        for (int i = 0; i < el.length(); i++) {
            arr[el.charAt(i)%26]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==0) return "not pangram";
        }

        return "pangram";
    }
}
