package problem_solving.HackerRank;

public class DrawingBook {
    public static void main(String[] args) {
        System.out.println(pageCount(2,6));
    }

    static int pageCount(int n, int p) {
        return Math.min(n / 2,
                p % 2 != 0 ? (p - n ) / 2 : (p - n +1) / 2
        );
    }
}
