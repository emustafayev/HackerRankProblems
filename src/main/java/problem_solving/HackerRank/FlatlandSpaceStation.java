package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FlatlandSpaceStation {


    public static void main(String[] args) {

        System.out.println(flatlandSpaceStations(20,new int[]{13, 1, 11, 10, 6}));

    }


    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {

//        City         : 0,1,2,3,4,5,6,7,8
//        SpaceStation : .,.,2,.,.,.,7,.

        int[] sortedC = Arrays.stream(c).sorted().toArray();

        int maxDist = sortedC[0]; // from beginning;
        // 1,6,10,11,13
        for (int i = 1; i < c.length; i++) {
            int dist = (sortedC[i] - sortedC[i-1])/2;
            if (maxDist < dist) {
                maxDist = dist;
            }
        }

        int lsd = n-1 - sortedC[sortedC.length-1];
        if( lsd > maxDist)
        {
            maxDist = lsd;
        }

        return maxDist;
    }

}
