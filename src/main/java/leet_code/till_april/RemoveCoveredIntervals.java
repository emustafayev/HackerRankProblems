package leet_code.till_april;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {

    public static void main(String[] args) {
        System.out.println(removeCoveredIntervals(new int[][]{{1, 4}, {3, 6}, {2, 8}}));
        System.out.println(removeCoveredIntervals(new int[][]{{1, 4}, {2, 3}}));
    }

    public static int removeCoveredIntervals(int[][] intervals) { //intervals = [[34335,39239],[15875,91969],[29673,66453],[53548,69161],[40618,93111]]

        Comparator<int[]> comparator = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]; // if first element same, sort by second element
            }
        };
        Arrays.sort(intervals, comparator);
        int count = 0, cur = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            // Already first number of array greater or equals, check second elements; If second curr element less than next second, it is covered;
            if (cur < interval[1]) {
                cur = interval[1];
                count++;
            }
        }
        return count;
    }


}
