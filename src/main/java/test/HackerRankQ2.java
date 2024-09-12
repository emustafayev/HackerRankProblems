package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HackerRankQ2 {
    public static void main(String[] args) {

//        System.out.println(getMaxImpactedServers(new ArrayList<>(Arrays.asList(5, 21, 10, 20, 11, 12, 20)), 1));
        System.out.println(getMaxImpactedServers(new ArrayList<>(Arrays.asList(5, 6, 5, 2, 1, 7, 9, 1)), 2));
//        System.out.println(getMaxImpactedServers(new ArrayList<>(Arrays.asList(8,3,5,6)), 2));
//        System.out.println(getMaxImpactedServers(new ArrayList<>(Arrays.asList(2,8,3,5)),6));
    }

    public static int getMaxImpactedServers(List<Integer> priority, int k) {
        // Sort the list to make comparison easier
        Collections.sort(priority);

        System.out.println(priority);

        int i = 1;
        int count  = 0;

        while (i < priority.size()) {
            int prev = priority.get(i-1);
            int current = priority.get(i);

            System.out.println(current + " " + prev);
            if (current - prev <= k) {
                System.out.println(prev);
                priority.remove(i-1);
                System.out.println(priority);
                count++;
                if (i-1 > 0 && priority.get(i-1) == current) {
                    i--;
                }
                i--;
            }

            i++;


        }

        return count;
    }

}
