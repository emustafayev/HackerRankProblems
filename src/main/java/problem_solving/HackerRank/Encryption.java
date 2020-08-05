package problem_solving.HackerRank;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Encryption {
    public static void main(String[] args) {
        encryption("have a nice day");
    }

    private static String encryption(String s){
        final String s0 = s.replace(" ","");
        int len = s0.length();
        double l = Math.sqrt(len);
        int l1 = (int) Math.floor(l);
        int l2 = (int) Math.ceil(l);
        int cols = l2;
        int rows = l1==l2?l1 : l1*l2 < len ? l2 : l1;

        return IntStream.range(0,cols).boxed().flatMap(c ->
                IntStream.range(0,rows).boxed().map(r -> {
                    //index original string
                    int idx = r*cols+c;
                    //char
                    String ch = idx<len?String.valueOf(s.charAt(idx)):"";
                    //last row
                    return (r == (rows-1)) ? ch + " ":ch;

                })).collect(Collectors.joining());
    }
}
