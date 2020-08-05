package problem_solving.HackerRank;

public class Kangaroo {
    public static void main(String[] args) {
        System.out.println(kangaroo(0,3,4,2));
        System.out.println(-3%3);
    }


    static String kangaroo(int x1, int v1, int x2, int v2) {
        int remainder = (x1 - x2) % (v2 - v1);
        return v1<=v2 ? "NO" : remainder==0 ? "YES":"NO";
    }

}
