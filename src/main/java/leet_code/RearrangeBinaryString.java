package leet_code;

public class RearrangeBinaryString {
    /**
     * You are given a binary string s. In one second, all occurrences of "01" are
     * simultaneously replaced with "10". This process repeats until no occurrences of "01" exist.
     *
     * Return the number of seconds needed to complete this process.
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(secondsToRemoveOccurrences2("0110101"));
        System.out.println(secondsToRemoveOccurrences2("11100"));

    }

    //0110101
    //1011010
    public static int secondsToRemoveOccurrences(String s) {
        return _secondsToRemoveOccurrences(s,0);
    }

    private static int _secondsToRemoveOccurrences(String s, int step){
        if (s.contains("01")){
            s = s.replace("01","10");
        }else return step;
        step++;
        return _secondsToRemoveOccurrences(s, step);
    }


    public static int secondsToRemoveOccurrences2(String s) {
        int ans = 0;
        while(s.contains("01")){
            s = s.replaceAll("01","10");
            ans += 1;
        }
        return ans;
    }



}
