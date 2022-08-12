package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftRotating {

    public static void main(String[] args) {
        System.out.println(rotateLeft(4, Arrays.asList(1, 2, 3, 4, 5)));
    }

//    1 2 3 4 5
//    4
//    5 1 2 3 4

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here

        int size = arr.size();
        int[] rotArr = new int[size];
        for (int i = 0; i < size; i++) {
            rotArr[(i + size - d) % size] = arr.get(i);
        }

        return Arrays.stream(rotArr)
                .boxed()
                .collect(Collectors.toList());
    }
}
