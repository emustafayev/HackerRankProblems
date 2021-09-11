package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SockMerchant {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,3,2};
        System.out.println(sockMerchant(arr.length,arr));
    }

    static int sockMerchant(int n, int[] ar) {
        return Arrays.stream(ar)
                .boxed()
                .collect(Collectors.groupingBy(i -> i))
                .values()
                .stream()
                .mapToInt(List::size)
                .boxed()
                .mapToInt(socks->socks/2)
                .sum();
    }
}
