package problem_solving.HackerRank;

import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

public class CaesarCipher1 {

    public static void main(String[] args) {
        caesarCipher("abcdefghijklmnopqrstuvwxyz",3);
    }




    public static String caesarCipher(String s, int k) {
        // Write your code here

        AtomicReference<String> res = new AtomicReference<>("");

        IntStream.range(0, s.length())
                .boxed()
                .map(i -> checkAndEncrypt(s.charAt(i), k))
                .forEach(c -> res.updateAndGet(v -> v + c));

        return res.get();
    }


    private static Character checkAndEncrypt(char c, int k) {
        if (!Character.isAlphabetic(c)) return c;
        int base = Character.isLowerCase(c) ? 'a' : 'A';
        return (char) (((c + k - base) % 26) + base); // find next position, find where it is located(>26 ? prune)
        // plus base length for correct position
    }
}
