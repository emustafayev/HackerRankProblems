package problem_solving.HackerRank;

import java.util.stream.IntStream;

public class AppendAndDelete {
    public static void main(String[] args) {
        System.out.println(appendAndDelete("y","yu",2));
    }

    // Complete the appendAndDelete function below.            // hackerhappy  11
    static String appendAndDelete(String s, String t, int k) { // hackerrank   10   // 6 common
        int sLength = s.length();
        int tLength = t.length();
        int minL = Math.min(sLength,tLength);
//        int commonLength = commonCharLength(minL,s,t);
        int commonLength = commonCharLength_h(minL,s,t); // for hacker rank: cant use java 9 features;

        return (sLength - commonLength) + (tLength - commonLength) <= k ? "Yes" : "No";
    }

    private static int commonCharLength_h(int minL, String s, String t) {
        int common = 0;
        for (int i = 0; i < minL; i++) {
            if (s.charAt(i) != t.charAt(i)) break;
            common++;
        }
        return common;
    }

    private static int commonCharLength(int minL, String s, String t) {
        return (int)IntStream.range(0, minL)
                .takeWhile(i -> (s.charAt(i) == t.charAt(i)))
                .count();
    }
}
