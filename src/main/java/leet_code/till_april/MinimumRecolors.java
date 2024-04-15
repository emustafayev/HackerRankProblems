package leet_code.till_april;

public class MinimumRecolors {

    /**
     * You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
     * <p>
     * You are also given an integer k, which is the desired number of consecutive black blocks.
     * <p>
     * In one operation, you can recolor a white block such that it becomes a black block.
     * <p>
     * Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
     *
     * @param args
     */

    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(minimumRecolors("WBWBBBW", 2));
    }


    public static int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;

        for (int lo = -1, hi = 0, white = 0; hi < blocks.length(); hi++) {
            white += blocks.charAt(hi) == 'W' ? 1 : 0;
            if (hi - lo >= k) {
                min = Math.min(min, white); // it reaches k block and number of min white to remove

                white -= blocks.charAt(++lo) == 'W' ? 1 : 0; // move the window
            }
        }
        return min;
    }
}
