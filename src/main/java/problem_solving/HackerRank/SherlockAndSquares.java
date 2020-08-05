package problem_solving.HackerRank;

public class SherlockAndSquares {
    public static void main(String[] args) {
        System.out.println(squares(24,49));
    }

    // Complete the squares function below.
    static int squares(int a, int b) {
        int ceil = (int) Math.ceil(Math.sqrt(a));
        int floor = (int) Math.floor(Math.sqrt(b));
        return floor-ceil+1;
    }
}
