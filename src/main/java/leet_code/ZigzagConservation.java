package leet_code;

public class ZigzagConservation {
    public static void main(String[] args) {

        System.out.println(convert("PAYPALISHIRING",4));

    }

//    P     I    N
//    A   L S  I G
//    Y A   H R
//    P     I

    public static String convert(String s, int numRows) {

        StringBuilder sb = new StringBuilder();
        int currentRow = 0;
        boolean goingDown = false;

        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (currentRow == 0 || currentRow == numRows - 1) goingDown = !goingDown;
            if (goingDown)
        }
    }
}
