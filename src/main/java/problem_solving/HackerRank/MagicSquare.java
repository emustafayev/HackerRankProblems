package problem_solving.HackerRank;

public class MagicSquare {
    public static void main(String[] args) {
        int[][] s = new int[][]{{5, 3, 4},
                {1, 5, 8},
                {6, 4, 2}
        };
        System.out.println(formingMagicSquare(s));
    }

    static int formingMagicSquare(int[][] s) {
        int res = 0;
        for (int i = 0; i < s.length; i++) {
            res += Math.abs(15 - (s[i][0]+s[i][1]+s[i][2]));
        }
        return res;
    }
}
