package leet_code.till_april;

import java.util.Arrays;

public class DijkstrasAlgorithm {


    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
    }


    void dijkstra(int graph[][], int src) {

        int[] stpSet = new int[4];
        Arrays.fill(stpSet, Integer.MAX_VALUE);
        stpSet[src] = 0;
        boolean []visited = new boolean[stpSet.length];
        Arrays.fill(visited,false);




    }


}
