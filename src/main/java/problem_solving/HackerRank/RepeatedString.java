package problem_solving.HackerRank;

import java.util.stream.IntStream;

public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",685118368975L));
    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long numberOfAIn = s.chars().filter(ch -> ch == 'a').count();
        long l = n / s.length(); // number of string occurrences;
        long occurrencesA = l * numberOfAIn;
        int extra = (int)(n % s.length());
        long extraA = IntStream.range(0, extra).filter(i -> s.charAt(i) == 'a').count();
        return occurrencesA + extraA;
    }
}
