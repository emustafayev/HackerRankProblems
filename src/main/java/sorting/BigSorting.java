package sorting;

import java.util.Arrays;

public class BigSorting {

    public static void main(String[] args) {
        var reg = "^[\\d]{9}[12]$";

        System.out.println("1111111112".matches(reg));

//        String[] arr  = new String[]{"1","100","234567","5"};
//        System.out.println(Arrays.toString(bigSorting(arr)));
    }

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        Arrays.sort(
                unsorted,(o1, o2) ->
                        o1.length() == o2.length() ?
                                compareTwoString(o1,o2) : // o1.compareTo(o1)
                                Integer.compare(o1.length(),o2.length())
        );
        return unsorted;
    }

    private static int compareTwoString(String s1, String s2) {
        throw new IllegalArgumentException("Not im[pl");
    }
}
