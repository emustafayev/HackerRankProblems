package leet_code.till_april;

import java.util.Arrays;

public class BoatsSavePeople {

    public static void main(String[] args) {

        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));

    }


    public static int numRescueBoats(int[] people, int limit) {

        int n = people.length;
        Arrays.sort(people);
        int left = 0;
        int right = n - 1;
        int boat = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
//                System.out.println(people[left] + " : " + people[right]);
                boat += 1;
                // less than limit, place two of them
                left += 1;
                right--;
            } else {
//                System.out.println(people[right]);
                // No place for two of them, just place big one,
                // small one can found match for itself later
                boat++;
                right--;
            }
        }
        return boat;
    }
}
