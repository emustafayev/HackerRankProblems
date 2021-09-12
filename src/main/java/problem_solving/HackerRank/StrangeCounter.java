package problem_solving.HackerRank;

import java.util.Scanner;

public class StrangeCounter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        System.out.println("Answer: ");
        System.out.println(strangeCounter(t));
    }

    public static long strangeCounter(long t) {
        long n = 2;
        int initialValue = 3;
        while (initialValue * (n - 1) < t) {
            System.out.println("Cycle last: "+ (initialValue * (n - 1)));
            System.out.println(n);
            n = 2 * n;
        }

        System.out.println("Founded cycle last: "+ (initialValue * (n - 1)));

        return (3 * (n - 1) - t + 1);
    }
}
