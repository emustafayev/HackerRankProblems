//package test;
//
//public class HackerRankQ1 {
//    public static void main(String[] args) {
//        int[] initialArray = {2, 1, 3, 5, 4};
//        int[] targetArray = {2, 4, 1, 5, 3};
//
//        int[] initialArray2 = {1,5,2,3,4};
//        int[] targetArray2 = {1,2,3,4,5};
//        int arraySize = 5;
//
//        System.out.println(minStep(initialArray2, targetArray2, arraySize));
//    }
//
//    public static int minStep(int[] arr1, int[] arr2, int size) {
//        int steps = 0;
//
//        for (int i = 0; i < size; i++) {
//            if (arr1[i] != arr2[i]) {
//                // Take the last element from arr1
//                int lastElement = arr1[arr1.length - 1];
//
//                // Check if the current element of arr2 is equal to the last element of arr1
//                if (arr2[i] == lastElement) {
//                    // If they are equal, swap the last element of arr1 with the current element of arr2
//                    int temp = arr1[i];
//                    arr1[i] = lastElement;
//                    arr2[i] = temp;
//                }
//
//                // Increase the step count
//                steps++;
//
//                // Update the last element to mimic the behavior of removing it
//                arr1[arr1.length - 1] = arr1[i];
//            }
//        }
//
//        return steps;
//    }
//
//
//
//
//    public static int minStep2(int[] arr1, int[] arr2, int size) {
//
//        boolean same = false;
//
//
//
//        while (same == false){
//
//
//            int lastEl = arr1[arr1.length-1];
//
//
//
//
//
//
//        }
//
//
//
//    }
//
//
//
//}
