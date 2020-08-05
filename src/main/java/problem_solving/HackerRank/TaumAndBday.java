package problem_solving.HackerRank;

public class TaumAndBday {
    public static void main(String[] args) {
        System.out.println(taumBday(3,6,9,1,1));
        System.out.println(taumBday(7,7,4,2,1));
        System.out.println(taumBday(5,9,2,3,4));
        System.out.println(taumBday(27984,1402,619246,615589,247954));
    }

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */


    //                          black  white black_cos white_cos convert_cost
    public static long taumBday(long b, long w, long bc, long wc, long z) {
        // Write your code here
        // b => 3, w => 6, bc=>9, bw => 1,  z=>1  // ans = 12 (3+6)*1 + 3*1 = 12
        // b => 7, w => 7, bc=>4, bw => 2,  z=>1  // ans = 35  (7+7)*2 + 7*1 = 35
        // b => 5, w => 9, bc=>2, bw => 3,  z=>4  // ans = 37
        long bToW = ((b + w) * wc) + (b * z);
        long wToB = ((b + w) * bc) + (w * z);
        long originalCost = (b * bc) + (w * wc);

//        bc = bc-wc>z? wc+z : bc;          \\
//                                             >>=== >> simpler way >
//        wc = wc-bc>z? bc+z : wc;          //

        return bToW < wToB && bToW < originalCost ? bToW : Math.min(wToB,originalCost);


    }
}
