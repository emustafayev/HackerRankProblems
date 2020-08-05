package problem_solving.HackerRank;

public class ChocolateFeast {
    public static void main(String[] args) {
        System.out.println(chocolateFeast(12,4,4));
    }

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        int boughtChocolates = n/c;
        int bars = boughtChocolates;
        int extraChocolates = 0;
        while (bars >= m){                               // 1. bars = 5
//            System.out.println(extraChocolates);         // 2. extraC = 2, bars = 1 + 2
            extraChocolates = bars/m;                    // 3. extraC = 1, bars = 1 + 1
            bars = extraChocolates + bars%m;             // 4. extraC = 1, bars = 1 + 0
            boughtChocolates += extraChocolates;
        }
        return boughtChocolates;
    }
}
