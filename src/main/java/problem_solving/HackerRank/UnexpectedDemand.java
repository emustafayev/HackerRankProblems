package problem_solving.HackerRank;

import java.util.List;

public class UnexpectedDemand {
    public static void main(String[] args) {

    }

    public static int filledOrders(List<Integer> order, int k) {
        // Write your code here
        int[] widgets = {k};
        return (int)order.stream().sorted().filter(ord -> {
            if ((widgets[0] - ord) > 0) {
                widgets[0] = widgets[0]-ord;
                return true;
            }
            return false;
        }).count();
    }

}

