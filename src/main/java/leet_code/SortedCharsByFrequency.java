package leet_code;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SortedCharsByFrequency {




    public String frequencySort(String s) {

        if(s==null||s.length()==0){
            return "";
        }

        if(s.length() == 1){
            return s;
        }

        StringBuilder sb = new StringBuilder("");

        // 1. turn String into char[]
        char[] c = s.toCharArray();

        // 2. sort the char[]
        Arrays.sort(c);

        // 3. turn sorted char[] back to String
        String newS = new String(c);

        // 4. do "word" count with HashMap <String, Integer>
        Map <String, Integer> mp = new HashMap<>();
        int slow = 0;
        int fast = 1;
        for(; fast < s.length(); fast++){
            if(c[fast] != c[slow]){
                int diff = fast - slow;
                sb.append(newS.substring(slow,fast));
                slow = fast;
                mp.put(sb.toString(), diff);
                sb = new StringBuilder("");
            }
        }

        int diff = fast - slow;
        sb = new StringBuilder("");
        while(slow < fast){
            sb.append(c[slow]);
            slow++;
        }
        mp.put(sb.toString(), diff);

        // 5. sort the HashMap by value descendingly
        mp = sortByVal(mp);

        // 6. concat keys
        sb = new StringBuilder("");
        for(String cs : mp.keySet()){
            sb.append(cs);
        }

        return sb.toString();
    }

    // 5. sort the HashMap by value descendingly
    private Map<String, Integer> sortByVal (Map<String,Integer> mp){

        List<Map.Entry<String,Integer>> list = new LinkedList<>(mp.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        // lambda is slower than the anonymous class
        // Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        Map<String,Integer> newMp = new LinkedHashMap<>();
        for(Map.Entry<String,Integer> entry:list){
            newMp.put(entry.getKey(), entry.getValue());
        }

        return newMp;

    }

}
