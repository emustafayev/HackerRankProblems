package leet_code.till_april;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionTwoArrays {


    public int[] intersection2(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> res = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            map.merge(i, 1, Integer::sum);
        }


        for (int i = 0; i < nums2.length; i++) {
            if (map.get(nums2[i]) == 1){
                res.add(nums2[i]);

            }
        }

        //anyway - bored. Next

        return null;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> res = new HashSet<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] == nums2[p2]){
                res.add(nums1[p1]);
                p1++;
                p2++;
            }else if (nums1[p1] > nums2[p2]){
                p2++;
            }else {
                p1++;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

}
