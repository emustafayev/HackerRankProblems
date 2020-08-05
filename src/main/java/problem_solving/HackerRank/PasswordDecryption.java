package problem_solving.HackerRank;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordDecryption {
    public static void main(String[] args) {
        System.out.println(decryptPassword("51Pa*0Lp*0eE*"));
    }


    static class DecodeElements{
        public static final Character ZERO = '0';         //48
        public static final Character ELIMINATOR = '-';   //45
        public static final Character FIRST_LOWER = 'a';  //65
        public static final Character LAST_LOWER = 'z';   //90
        public static final Character STAR = '*';         //42
        public static final Character FIRST_UPPER = 'A';  //97
        public static final Character LAST_UPPER = 'Z';   //122
        public static final Character FIRST_NUMBER = '1'; //49
        public static final Character LAST_NUMBER = '9';  //57
    }



    public static String decryptPassword(String s) {
        // Write your code here
        LinkedList<Integer> numbers = new LinkedList<>(); // 1,5
        char[] chars = s.toCharArray();

        List<Character> result = IntStream.range(0, chars.length).map(i -> {
            if (chars[i] > 48 && chars[i] < 58) {
                numbers.addFirst((int)chars[i]);
                return 45;
            }
            else if (chars[i] == 48) return numbers.pop();
            else if (chars[i] == 42) return 45;
            else if ( (i < s.length()) && (chars[i] > 64 && chars[i] < 91) && (chars[i + 1] > 96 && chars[i + 1] < 123)) return chars[i + 1];
            else if ((chars[i] > 96 && chars[i] < 123) && (chars[i-1] > 64 && chars[i-1] < 91)) return chars[i - 1];
            else return chars[i];
        }).filter(j -> j != 45).mapToObj(j -> (char) j).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        result.forEach(i->sb.append((char)i));

        return sb.toString();
    }
}
