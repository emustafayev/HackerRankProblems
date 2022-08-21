package leet_code;

import java.util.Arrays;
import java.util.List;


//HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity.
// If the amount spent by a client on a particular day is greater than or equal to  the client's median spending
// for a trailing number of days, they send the client a notification about potential fraud.
// The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.
//
// Given the number of trailing days  and a client's total daily expenditures for a period of  days,
// determine the number of times the client will receive a notification over all  days.
//

public class FraudulentActivityNotifications {


    public static void main(String[] args) {
        System.out.println(activityNotifications(Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5), 5));
    }


    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here


        int[] arr = expenditure.stream().mapToInt(i -> i).toArray();

        int[] count = new int[201]; // holds count of each element

        // fill the count array with first d elements
        for (int i = 0; i < d; i++) {
            count[arr[i]] += 1;
        }

        int ans = 0;
        for (int i = d; i < arr.length; i++) {
            double median = GetMedian(count, d);
//            System.out.println("median: " + median);
            System.out.println(Arrays.toString(count));
            if (arr[i] >= 2 * median) {
                ans++;
            }

            // add next remove last
            count[arr[i]] += 1;
            count[arr[i - d]] -= 1;
        }

        return ans;
    }

    static double GetMedian(int[] count, int d) {
        // count array has frequencies
        int medianFreq = 0;
        int freqSum = 0;

        if (d % 2 == 1) { // odd
            medianFreq = d / 2 + 1;
            for (int i = 0; i < count.length; i++) {
                freqSum += count[i];
                if (freqSum >= medianFreq)
                    return (double) i;
            }
        } else // even
        {
            medianFreq = d / 2;
            for (int i = 0; i < count.length; i++) {
                freqSum += count[i];

                if (freqSum >= medianFreq) {
                    int first = i;
                    int second = freqSum > medianFreq ? i : i + 1;
                    return ((double) (first + second)) / 2;
                }
            }
        }

        return 0.0;
    }
}
