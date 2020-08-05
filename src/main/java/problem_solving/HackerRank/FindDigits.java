package problem_solving.HackerRank;

import java.util.ArrayList;
import java.util.List;

public class FindDigits {
    public static void main(String[] args) {
        System.out.println(findDigits(1012));
    }

    static int findDigits(int n) {
        List<Integer> digits = new ArrayList<>();
        int temp = n;
        while(temp>0){
            digits.add(temp%10);
            temp/=10;
        }
        return (int)digits.stream().filter(d-> d!=0 && n%d==0).count();
    }
}
