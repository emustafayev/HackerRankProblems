package problem_solving.HackerRank;

public class JumpsOnTheClouds2 {
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{1, 1, 1, 0, 1, 1, 0, 0,0, 0},3));
    }

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {  // n => number of clouds, k => jump distance
        int e = 100;
        int i = 0;
        while (true){
            int step = (i+k)%c.length;
            e = e - (c[step] == 0 ? 1 : 3);
            i+=k;
            if (step == 0) return e;
        }
    }
}
