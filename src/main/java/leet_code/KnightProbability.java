package leet_code;

public class KnightProbability {

    private static final int[][] dir = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

    public static double knightProbability(int N, int K, int r, int c) {
        return find(N, K, r, c);
    }

    public static double find(int N, int K, int r, int c) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;
        if (K == 0) return 1;
        double rate = 0;
        for (int i = 0; i < dir.length; i++) {
            rate += 0.125 * find(N, K - 1, r + dir[i][0], c + dir[i][1]);
        }
        return rate;
    }


    public static void main(String[] args) {
        System.out.println(knightProbability2(3, 2, 0, 0));
    }


    //   ---------------------------------------------------------     //


    private static double[][][] dp;

    public static double knightProbability2(int n, int k, int row, int column) {
        dp = new double[n][n][k + 1];
        return find2(n, k, row, column);
    }

    public static double find2(int N, int K, int r, int c) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;

        if (K == 0) return 1;  //  remains on the board after it has stopped moving.  // probability 1 so it nailed to survive;

        if(dp[r][c][K] != 0) return dp[r][c][K];  // if previously calculated


        double rate = 0;
        for(int i = 0;i < dir.length;i++)  // Her bir istiqametde sag qalma ehtimali K qeder hereket etdikden sonra
            rate += 0.125 * find2(N,K - 1,r + dir[i][0],c + dir[i][1]);
        dp[r][c][K] = rate;


        return rate;
    }
}
