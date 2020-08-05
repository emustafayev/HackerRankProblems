package problem_solving.HackerRank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ModifiedKaprekarNumbers {
    public static void main(String[] args) {
        kaprekarNumbers(1000,10000);
    }

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        List<Long> result = LongStream.rangeClosed(p, q).filter(i -> {
            if (i == 1) return true;
            String number = String.valueOf((long) Math.pow(i, 2));
            return isKaprekar(number, i);
        }).boxed().collect(Collectors.toList());
        if (result.isEmpty()){
            System.out.println("INVALID RANGE");
        }else result.forEach(i-> System.out.printf("%d ",i));
    }

    private static boolean isKaprekar(String number, long originNum) {
        return parse(number.substring(0,number.length()/2)) + parse(number.substring(number.length()/2)) == originNum;
    }

    private static long parse(String s){
        if (s.equals("")) return 0;
        return Long.parseLong(s);
    }
}
