package leet_code.till_april;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {


    public static List<Integer> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row, pre = null;

        for (int i = 0; i <=numRows; i++) {

            row = new ArrayList<>();

            for (int j = 0; j <= i; j++)
                if (j == 0 || j == i) row.add(1); // first and last col is 1
                else row.add(pre.get(j-1) + pre.get(j)); // for others, get previous rows elements above them and sum
            pre = row;
            res.add(row);
        }
        return res.get(res.size());
    }
}
