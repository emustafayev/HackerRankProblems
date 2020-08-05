package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class BonApetit {
    public static void main(String[] args) {
        List<Integer> bill = Arrays.asList(3, 10, 2, 9);
        int index=1;
        int charged = 7;
        bonAppetit(bill,index,charged);
    }

    static void bonAppetit(List<Integer> bill, int k, int b) {
        int charged = (bill.stream().reduce(Integer::sum).orElseThrow(RuntimeException::new) - bill.get(k)) / 2;
        System.out.println(charged==b?"Bon Appetit":(b-charged));

    }
}
