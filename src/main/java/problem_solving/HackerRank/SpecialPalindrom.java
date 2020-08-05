package problem_solving.HackerRank;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SpecialPalindrom {
    /*
    * aaabbbccaaa
    * acc=>(char)=>new acc;
    *
    *
    * */


    static class Pair<A,B>{
        A a;
        B b;

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }
        @Override
        public String toString() {
            return String.format("P[%s:%s]", a, b);
        }
    }

    private static <T,A> A fold(Iterable<T> it, A initial, BiFunction<A,T,A> f){
        A acc = initial;
        Iterator<T> data = it.iterator();
        while (data.hasNext()){
            acc = f.apply(acc,data.next());
        }
        return acc;
    }

    static class Item extends Pair<Character, Long>{

        public Item(Character character, Long aLong) {
            super(character, aLong);
        }
    }

    static class Acc extends Pair<List<Item>, Optional<Item>>{

        public Acc(List<Item> items, Optional<Item> item) {
            super(items, item);
        }
    }

    static private List<Character> sToList(String s){
        return s.chars().mapToObj(ch->(char)ch).collect(Collectors.toList());
    }

    private  static List<Item> toTuple(String origin){
        Acc initial = new Acc(new ArrayList<>(),Optional.empty());

        BiFunction<Acc,Character,Acc> f = (acc, ch) -> {
            List<Item> result = acc.a;
            Optional<Item> buff = acc.b;
            //if buffer is empty
            if (buff.isEmpty()) return new Acc(result, Optional.of(new Item(ch, 1L)));
            //if char is same with acc char
            if (buff.get().a.equals(ch)) return new Acc(result, Optional.of(new Item(ch, buff.get().b + 1)));
            // if is not same we need to add buff to list and create new buffer
            buff.ifPresent(b -> acc.a.add(b));
            return new Acc(result, Optional.of(new Item(ch, 1L)));
        };

        Acc folded = fold(
                sToList(origin),
                initial,
                f
        );

        folded.b.ifPresent(lastBuff->folded.a.add(lastBuff));
        return folded.a;
    }

    public static void main(String[] args) {
        System.out.println(toTuple("aaaa"));
    }
}
