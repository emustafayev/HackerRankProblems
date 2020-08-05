package problem_solving.HackerRank;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PDFViewer {
    public static void main(String[] args) {
        int abc = designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, "abc");
        System.out.println(abc);
    }

    static int designerPdfViewer(int[] h, String word) {
        Map<Character, Integer> pairs = new HashMap<>();
        IntStream.range(0, 26).mapToObj(i -> (char) (i + 97))
                .forEach(ch-> pairs.put(ch,h[(int)ch-97]));
        int taller = word.chars().map(ch->pairs.get((char) ch)).max().orElseThrow(RuntimeException::new);
        return taller*word.length();
    }
}
