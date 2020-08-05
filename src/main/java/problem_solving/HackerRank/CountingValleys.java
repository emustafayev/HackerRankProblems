package problem_solving.HackerRank;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(12,"UDDDUDUU"));
    }


    static int countingValleys(int n, String s) {
        int[] count = {0};
        int[] level = {0};

        s.chars().forEach(ch->{
            if (ch=='U') level[0]++;
            else if (ch=='D') level[0]--;
            if (ch=='U' && level[0]==0) count[0]++;
        });
        return count[0];
    }
}
