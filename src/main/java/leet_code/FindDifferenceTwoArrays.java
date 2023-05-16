package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceTwoArrays {

    public static void main(String[] args) {



    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        ArrayList<List<Integer>> res = new ArrayList<>();

        ArrayList<Integer> res1 = new ArrayList<>();
        ArrayList<Integer> res2 = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int n : nums1) set1.add(n);
        for (int n : nums2) set2.add(n);

        for (int el: set1)
            if (!set2.contains(el)) res1.add(el);
        for (int el: set2)
            if (!set1.contains(el)) res2.add(el);

        res.add(res1);
        res.add(res2);

        return res;
    }
}
