package problem_solving.HackerRank;

public class ElectronicShop {

    public static void main(String[] args) {
        System.out.println(getMoneySpent(new int[]{3, 1}, new int[]{5, 2, 8}, 60));
    }


    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int ans = -1;
        for (int keyboard : keyboards) {
            for (int drive : drives) {
                int currentPrice = keyboard + drive;
                if (currentPrice > ans && currentPrice <= b) {
                    ans = currentPrice;
                }
            }
        }
        return ans;
    }
}
