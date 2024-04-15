package leet_code.till_april;

import java.util.Arrays;

public class SuccessfulPairsSpellsPotions {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs2(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(successfulPairs2(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
        System.out.println(Arrays.toString(successfulPairs3(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));
        System.out.println(Arrays.toString(successfulPairs3(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
    }


    public static int[] successfulPairs(int[] spells, int[] potions, long success) { // Time Limit exception

        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            for (int potion : potions) {
                if ((long) spells[i] * potion >= success) {
                    res[i] += 1;
                }
            }
        }

        return res;
    }

    //  new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7
    public static int[] successfulPairs2(int[] spells, int[] potions, long success) { // Time Limit exception again

        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {

            // 5 * x = 7 or more
            // 7 / 5 = 2 or more
            long leastPotion = (long) Math.ceil((double) success / spells[i]);

            for (int j = 0; j < potions.length; j++) {
                if (potions[j] >= leastPotion) res[i] += 1;
            }

        }

        return res;
    }

    //  new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7
    //Binary search
    public static int[] successfulPairs3(int[] spells, int[] potions, long success) { // Time Limit exception again
        int n = spells.length;
        int m = potions.length;

        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            int spell = spells[i];
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) potions[mid] * spell >= success) right = mid - 1;
                else left = mid + 1;
                res[i] = m - left;
            }
        }
        return res;
    }
}
