package problem_solving.HackerRank;

public class ReducedString {


    public static void main(String[] args) {

//        System.out.println(superReducedString("aaabccddd"));
        System.out.println(superReducedString("baab"));

    }


    /*
     * Complete the 'superReducedString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    //aaabccddd → abccddd → abddd → abd
    //remove adjacent strings

    public static String superReducedString(String s) {
        // Write your code here

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                s = s.substring(0, i - 1) + s.substring(i + 1);
                System.out.println(i + " " + s);
                i = 0;  // new string, start from begining
            }
        }
        if (s.isEmpty()) {
            return "Empty String";
        }
        return s;

    }

}
