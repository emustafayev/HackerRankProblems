package problem_solving.HackerRank;

import java.util.stream.IntStream;

public class KabrekarNumbers {
    public static void main(String[] args) {
        kaprekarNumbers(100,1);
    }

    static void kaprekarNumbers(int p, int q){

        IntStream.range(0,p).filter(i->{
            String result = String.valueOf(i*i);
            System.out.println(i);
                    if (result.length()>1){
                        System.out.println(result);
                        int firstPart = Integer.parseInt(result.substring(0,q));
                        int secondPart = Integer.parseInt(result.substring(q));
                        System.out.println(firstPart+" "+secondPart);
                        if ((firstPart+secondPart)==i)return true;
                        return false;
                    }else {
                        return i*i==p;
                    }
                }).forEach(System.out::println);
        }
}


