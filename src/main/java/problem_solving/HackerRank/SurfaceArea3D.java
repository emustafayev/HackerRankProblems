package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class SurfaceArea3D {

    public static void main(String[] args) {

        List<List<Integer>> cube = Arrays.asList(Arrays.asList(1, 3, 4), Arrays.asList(2, 2, 3), Arrays.asList(1, 2, 4));
        System.out.println(surfaceArea(cube));

    }


    public static int surfaceArea(List<List<Integer>> A) {
        int result = 0;
        for (int row = 0; row < A.size(); row++) {
            for (int col = 0; col < A.get(0).size(); col++) {
//                System.out.print(A.get(row).get(col) + " ");
                result += A.get(row).get(col) * 4 + 2; // not multiply by 6 because we eliminate common surfaces one on another

                if (row + 1 < A.size()){
                    int min = 2 * Math.min(A.get(row).get(col), A.get(row + 1).get(col));
                    System.out.println(min);
                    result -= min; // minus common surfaces
                }
                if (col + 1 < A.get(0).size()){
                    int min = 2 * Math.min(A.get(row).get(col), A.get(row).get(col + 1));
                    System.out.println(min);
                    result -= min; // minus common surfaces
                }
//            1 3 4
//            2 2 3
//            1 2 4

            }
//            System.out.println();
//
        }

        // Write your code here
        return result;
    }
}
