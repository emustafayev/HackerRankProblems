package problem_solving.HackerRank;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public class AlternatingCharacters {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        System.out.println(alternatingCharacters02("AAABABAB"));
        System.out.println(length("AAABBBXCCC"));
    }

    static class Pair<A, B>{
        A a;
        B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "[ " + a + "," + b +" ]";
        }
    }

    private static int alternatingCharacters02(String s) {
        return fold(
                sToList(s),
                new Pair<>(0,'_'),
                (p,c) -> p.b != c ? new Pair<>(p.a,c) : new Pair<>(p.a+1,c)
        ).a;
    }

    private static int length(String s) {
        BiFunction<Integer, Character, Integer> f = (i, c) -> i+1;
        return fold(
                sToList(s),
                0,
                f
        );

    }

    private static <A,T> A fold(@NotNull Iterable<T> it, A initial, BiFunction<A,T,A> f){
        Iterator<T> data = it.iterator();
        A acc = initial;
        while (data.hasNext()){
            System.out.println(acc);
            acc = f.apply(acc,data.next());
        }
        return acc;
    }

    private static List<Character> sToList(@NotNull String s){
        return s.chars()
                .mapToObj(ch->(char)ch)
                .collect(Collectors.toList());
    }
}
