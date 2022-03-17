package problem_solving.HackerRank;

public class CatsAndMouse2 {

    public static void main(String[] args) {

        System.out.println(catAndMouse(2,5,4));

    }


    static String catAndMouse(int x, int y, int z) {

        return Math.abs(x - z) == Math.abs(y - z) ? "Mouse C" : Math.abs(x - z) < Math.abs(y - z) ? "Cat A" : "Cat B";
    }


}
