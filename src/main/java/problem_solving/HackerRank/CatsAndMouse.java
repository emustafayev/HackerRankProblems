package problem_solving.HackerRank;

public class CatsAndMouse {
    public static void main(String[] args) {
        System.out.println(catAndMouse(1,3,2));
    }

    static String catAndMouse(int x, int y, int z) {
        return Math.abs(x-z)==Math.abs(y-z)?"Mouse C": Math.abs(x-z)<Math.abs(y-z)? "Cat A":"Cat B";
    }
}
