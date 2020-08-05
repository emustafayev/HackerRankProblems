package problem_solving.HackerRank;


import java.util.Scanner;

public class Anagram {
//    static class Bools {
//        boolean state;
//        public Bools(boolean s){
//            this.state=s;
//        }
//    }
    static boolean isAnagram(String a, String b) {
//        if (!a.equals(b))return false;
//        Map<Integer, List<Integer>> mapA = a.toUpperCase().chars()
//                .boxed()
//                .collect(Collectors.groupingBy(el->el));
//        Map<Integer, List<Integer>> mapB = b.toUpperCase().chars()
//                .boxed()
//                .collect(Collectors.groupingBy(el -> el));
//
//        for (int i = 0; i < mapA.size(); i++) {
//            if(mapA.)
//        }
//

//        List<Bools> collect = mapA.entrySet().stream().flatMap(entryA -> mapB.entrySet().stream().map(new Function<Map.Entry<Integer, List<Integer>>, Bools>() {
//            @Override
//            public Bools apply(Map.Entry<Integer, List<Integer>> entryB) {
//                Bools bl;
//                if ((int) entryA.getKey() == entryB.getKey() && entryA.getValue().size() != entryB.getValue().size()) {
//                    bl = new Bools(false);
//                    System.out.println((char) (int) entryA.getKey());
//                } else bl = new Bools(true);
//                return bl;
//            }
//        })).collect(Collectors.toList());
//        System.out.println(collect.toString());


//        mapA.entrySet().stream().flatMap(keyA->mapB.entrySet().stream().map(keyB->))
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] arr = new int[26];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i)%26]++;
            arr[b.charAt(i)%26]--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0)return false;
        }
        return true;
        // Complete the function
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
