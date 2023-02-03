package leet_code;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {


    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"apple","app"},"worldabcefghijkmnpqstuvxyz"));
    }

//    ["hello","leetcode"]
//    ["word","world","row"]
//    ["apple","app"]


    public static boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++)
            orderMap.put(order.charAt(i), i);


        for (int i = 1; i < words.length; i++) {

            String w1 = words[i - 1];
            String w2 = words[i];
            for (int j = 0; j < w1.length(); j++) {
                if (j >= w2.length()) return false; // app/ apple is sorted other case not sorted

                char a = w1.charAt(j);
                char b = w2.charAt(j);

                if (orderMap.get(a) > orderMap.get(b)) return false; // it is not sorted
                if (orderMap.get(a) < orderMap.get(b)) break; // pass to next words
            }

        }
        return true; // if all cases passed; means it is sorted
    }
}
