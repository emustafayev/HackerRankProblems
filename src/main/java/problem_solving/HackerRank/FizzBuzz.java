package problem_solving.HackerRank;

import java.util.Scanner;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fizzBuzz(15);
    }


    private static void fizzBuzz(int n){
        IntStream.rangeClosed(1,n).mapToObj(i -> {
            if (i%3==0 && i%5==0) return "FizzBuzz";
            else if (i%3==0) return "Fizz";
            else if (i%5==0) return "Buzz";
            else return String.valueOf(i);
        }).forEach(System.out::println);
    }

}

