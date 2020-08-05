package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RansomNote {
    public static void main(String[] args) {
        checkMagazine(new String[]{"ive", "got", "a", "lovely", "bunch", "of", "coconuts"},new String[]{"ive", "got", "some", "coconuts"});
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, List<String>> magazineDict = Arrays.stream(magazine).collect(Collectors.groupingBy(s -> s));
        Map<String, List<String>> noteDict = Arrays.stream(note).collect(Collectors.groupingBy(l -> l));
        int commonWords = (int) noteDict.keySet().stream().map(k -> Optional.ofNullable(magazineDict.get(k))).takeWhile(Optional::isPresent).count();

        System.out.println(commonWords == note.length ? "Yes" : "No");
    }
}
