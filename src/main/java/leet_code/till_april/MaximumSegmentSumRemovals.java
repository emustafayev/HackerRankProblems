package leet_code.till_april;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class MaximumSegmentSumRemovals {

    public static void main(String[] args) {


        int[] nums = new int[]{500, 822, 202, 707, 298, 484, 311, 680, 901, 319, 343, 340};
        int n = nums.length;
        long[] prefixSum = new long[n+1]; // array to store prefixSum of nums

        // calculating prefixSum
        for(int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        // TreeMap to store ranges to its sum mapping
        TreeMap<int[], Long> ranges = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // initially it will have whole array range
        ranges.put(new int[]{0, n - 1}, prefixSum[n]);
//        ranges.forEach((key, value) -> System.out.println(Arrays.toString(key) + " " + value));

        int node = 4; // index to be removed or set to zero.

        // finding range which will split when node index is removed or set 0.
        int[] rangeToBeRemoved = ranges.floorKey(new int[]{node});

        System.out.println("rangeToBeRemoved " + Arrays.toString(rangeToBeRemoved));

        Long sum = ranges.get(rangeToBeRemoved); // finding its sum

        System.out.println(sum);





//        System.out.println(Arrays.toString(
//                maximumSegmentSum4(
//                        new int[]{500, 822, 202, 707, 298, 484, 311, 680, 901, 319, 343, 340},
//                        new int[]{6, 4, 0, 5, 2, 3, 10, 8, 7, 9, 1, 11}))
//        );

//        System.out.println(Arrays.toString(
//                maximumSegmentSum(
//                        new int[]{3, 2, 11, 1},
//                        new int[]{3, 2, 1, 0}))
//        );

//        System.out.println(
//                sum(new int[]{500, 822, 202, 707, 0, 484, 0, 680, 901, 319, 343, 340})
//        );
    }


    public static long[] maximumSegmentSum4(int[] nums, int[] removeQueries) {
        int n = nums.length;
        long[] result = new long[n]; // array to store answer
        long[] prefixSum = new long[n+1]; // array to store prefixSum of nums

        // calculating prefixSum
        for(int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + nums[i];
        }

        // TreeMap to store ranges to its sum mapping
        TreeMap<int[], Long> ranges = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // initially it will have whole array range
        ranges.put(new int[]{0, n - 1}, prefixSum[n]);

        ranges.forEach((key, value) -> System.out.println(Arrays.toString(key) + " " + value));


        // TreeMap to store all the possible sums of range we encounter while solving queries, we are storing frequencies because
        // multiple range can have same sum.
        TreeMap<Long, Integer> sums = new TreeMap<>();
        // initialise it with sum of all array.
        sums.put(prefixSum[n], 1);

        // Iterating on queries
        for(int i = 0; i < n; i++){
            int node = removeQueries[i]; // index to be removed or set to zero.

            // finding range which will split when node index is removed or set 0.
            int[] rangeToBeRemoved = ranges.floorKey(new int[]{node});
            Long sum = ranges.get(rangeToBeRemoved); // finding its sum

            // removing/ reducing sum from sums Map because we are splitting that range, so it is no more valid
            int f = sums.get(sum);
            if(f == 1) sums.remove(sum);
            else sums.put(sum, f - 1);

            // removing that range
            ranges.remove(rangeToBeRemoved);

            int l = rangeToBeRemoved[0];
            int r = rangeToBeRemoved[1];
            long newSum = 0;

            // Splitting range and store back new ranges form along with its sum.
            if (l == node && r != node) {
                newSum = prefixSum[r + 1] - prefixSum[l + 1];
                ranges.put(new int[]{l+1, r}, newSum);
                sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);
            } else if (r == node && l != node) {
                newSum = prefixSum[r] - prefixSum[l];
                ranges.put(new int[]{l, r - 1}, newSum);
                sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);

            } else if(node > l && node < r){
                newSum = prefixSum[node] - prefixSum[l];
                ranges.put(new int[]{l, node - 1}, newSum);
                sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);

                newSum = prefixSum[r+1] - prefixSum[node + 1];
                ranges.put(new int[]{node + 1, r}, newSum);
                sums.put(newSum, sums.getOrDefault(newSum, 0) + 1);
            }


            if(sums.size() != 0)
                result[i] = sums.lastKey();
            else
                result[i] = 0;

        }

        return result;
    }

    //Pass 46/52 test casess
    public static long[] maximumSegmentSum(int[] nums, int[] removeQueries) {

        long[] res = new long[removeQueries.length];

        for (int i = 0; i < removeQueries.length; i++) {
            nums[removeQueries[i]] = 0;
            res[i] = Math.max(
                    sum(
                            Arrays.copyOfRange(nums, 0, removeQueries[i])
                    ),
                    sum(
                            Arrays.copyOfRange(nums, removeQueries[i] + 1, nums.length)
                    )
            );
        }
        return res;
    }

    private static long sum(int[] array) {

        long max = 0;
        long sub = 0;

        for (int j : array) {
            sub += j;

            if (j == 0) {
                if (max < sub) {
                    max = sub;
                }
                sub = 0;
            }
        }
        return Math.max(max, sub);
    }

    public static long[] maximumSegmentSum2(int[] nums, int[] q) {
        long[] ans = new long[q.length];
        TreeMap<Long, long[]> map = new TreeMap<>(); // rangeStart,[rangeEnd,rangeSum]
        long[] pref = new long[nums.length];
        pref[0] = (long) nums[0];

        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1];
            pref[i] += (long) nums[i];
        }


        TreeMap<Long, Integer> sums = new TreeMap<>();
        sums.put(pref[nums.length - 1], 1);

        map.put(0L, new long[] { nums.length - 1, pref[nums.length - 1] });

        for (int i = 0; i < q.length; i++) {
            Long x = map.floorKey((long) q[i]);
            if (x == null) {
                if (!sums.isEmpty()) ans[i] = sums.lastKey();
                continue;
            }
            long range[] = { x, map.get(x)[0] };
            sums.put(map.get(x)[1], sums.get(map.get(x)[1]) - 1);
            if (sums.get(map.get(x)[1]) == 0) sums.remove(map.get(x)[1]);
            map.remove(x);

            long leftSum = -1, rightSum = -1;
            long[] leftRange = { range[0], q[i] - 1 };
            long[] rightRange = { q[i] + 1, range[1] };

            check(map, pref, sums, leftRange);
            check(map, pref, sums, rightRange);
            if (!sums.isEmpty()) ans[i] = sums.lastKey();
        }
        return ans;
    }

    private static void check(TreeMap<Long, long[]> map, long[] pref, TreeMap<Long, Integer> sums, long[] leftRange) {
        long leftSum;
        if (leftRange[0] >= 0 && leftRange[1] >= 0 && (leftRange[1] - leftRange[0] + 1) >= 1) {
            leftSum = pref[(int) leftRange[1]] - (leftRange[0] - 1 >= 0 ? pref[(int) (leftRange[0] - 1)] : 0);
            sums.put(leftSum, sums.getOrDefault(leftSum, 0) + 1);
            map.put(leftRange[0], new long[] { leftRange[1], leftSum });
        }
    }


    public long[] maximumSegmentSum3(int[] nums, int[] quer) {
        int n=nums.length;
        PriorityQueue<long []> pq=new PriorityQueue<>((long a[], long b[])->(a[2]<=b[2])?1:-1);
        TreeSet<Integer> set=new TreeSet<>();
        long[] arr =new long[n],ans =new long[n];
        set.add(-1);
        set.add(n);
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            if(i!=0) arr[i]+=arr[i-1];
        }
        pq.add(new long[]{0,n-1,arr[n-1]});
        for(int i=0;i<n;i++){
            int num=quer[i];
            set.add(quer[i]);
            int a=set.lower(num), b=set.higher(num);
            if((a+1)<num){
                pq.add(new long[]{(long)a+1,(long)num-1,arr[num-1]-(long)((a==-1)?0:arr[a])});
            }
            if((num+1)<b){
                pq.add(new long[]{(long)num+1,(long)b-1,arr[b-1]-arr[num]});
            }
            while(!pq.isEmpty()){
                long ab[]=pq.peek();
                int s=(int) ab[0],e=(int) ab[1];

                if(set.higher(s-1)>e){
                    ans[i]=pq.peek()[2];
                    break;
                }
                else pq.remove();
            }
        }
        return ans;
    }




}
