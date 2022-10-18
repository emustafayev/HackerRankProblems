package leet_code;


import java.util.Arrays;

public class ShiftingLettersII {

    public static void main(String[] args) {
        System.out.println(shiftingLetters("dztz", new int[][]{{0, 0, 0}, {1, 1, 1}}));
    }

    private static String shiftingLetters(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        int[] count = new int[s.length()+1];

        for(int[] shift : shifts){
            int value = shift[2] == 1 ? 1 : -1;
            count[shift[0]] += value;
            count[shift[1] + 1] -= value;
        }

        int sum = 0;
        for(int i = 0; i < count.length - 1; i++){
            sum += count[i];
            int newChar = ((ch[i] - 'a') + sum) % 26;
            if(newChar < 0) newChar+= 26;
            ch[i] =  (char)('a' + newChar);
        }

        return String.valueOf(ch);
    }


    public static String shiftingLetters2(String s, int[][] shifts) {


        for (int i = 0; i < shifts[0].length; i++) {
            System.out.println(s);
            System.out.println(shifts[i][0] + " " + (shifts[i][1] + 1));
            var shiftMe = s.substring(shifts[i][0], shifts[i][1] + 1);

            s = s.replace(shiftMe, move(shiftMe, shifts[i][2] == 1));
        }

        return s;
    }

    //97, 122 => 123
    //96 => 122
    private static String move(String shiftMe, boolean forward) {


        StringBuilder sb = new StringBuilder();

        shiftMe.chars()
                .forEach(c -> {
                    if (forward) {
                        c = (c + 1) > 122 ? (c + 1) % 122 + 96 : c + 1;
                    } else {
                        c = (c - 1) < 97 ? (c - 1) + 26 : (c - 1);
                    }
                    sb.append((char) c);
                });

        return sb.toString();
    }
}
