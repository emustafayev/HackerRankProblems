package problem_solving.HackerRank;


public class QueensAttackII {

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int[][] directionValues = new int[1][n];

        int l = r_q;
        int l_t = r_q;
        int l_b = r_q;

        int outOfRadarCount = 0;

        for (int i = 0; i < obstacles.length; i++) {
            int r_o = obstacles[i][0];
            int c_o = obstacles[i][1];
            boolean obstInDiagonalRadar = Math.abs(r_o - r_q) == Math.abs(c_o - c_q);
            boolean obstInVHRadar = (r_o == r_q || c_o == c_q);

            if (obstInVHRadar) {
                outOfRadarCount += Math.max(Math.abs(r_o - r_q), Math.abs(c_o - c_q)) - 1;
                System.out.println("Obstacle is in queen's radar " + r_o + " " + c_o);
            }
        }


        throw new IllegalArgumentException("Not finished yet");

    }

    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        int r_q = 4;
        int c_q = 3;
        int[][] obstacles = {{2, 3}, {3, 2}, {3, 5}};
        System.out.println(queensAttack(n, k, r_q, c_q, obstacles));
    }
}
