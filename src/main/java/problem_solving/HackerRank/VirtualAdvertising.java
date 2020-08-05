package problem_solving.HackerRank;

import java.util.stream.IntStream;

public class VirtualAdvertising {
    public static void main(String[] args) {
        System.out.println(viralAdvertising(5));
    }

    static class Pairs{
        static int shared = 5;
        int liked;

        public Pairs(int liked) {
            this.liked = liked;
        }
    }
    static int viralAdvertising(int n) {
        return IntStream.range(0,n).mapToObj(i->{
            int likes = Pairs.shared/2;
            Pairs.shared=likes*3;
            return new Pairs(likes);
        }).reduce((pairs, pairs2) -> new Pairs(pairs.liked+pairs2.liked))
                .orElseThrow(RuntimeException::new)
                .liked;
    }
}
