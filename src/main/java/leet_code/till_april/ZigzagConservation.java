package leet_code.till_april;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConservation {

    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING",4));

    }

//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();


        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean goDown = false;

        for (char c : s.toCharArray()) {
            rows.get(currRow).append(c);
            if (currRow == 0 || currRow == numRows - 1) goDown = !goDown;
            currRow+= goDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder r :
                rows) {
            result.append(r);
        }

        return result.toString();
    }
}
