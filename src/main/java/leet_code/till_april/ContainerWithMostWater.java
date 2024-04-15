package leet_code.till_april;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }


    public static int maxArea(int[] height) {
        int leftP = 0;
        int rightP = height.length - 1;

        int maxArea = 0;

        while (leftP < rightP){

            maxArea = Math.max(maxArea,(rightP-leftP) * Math.min(height[rightP],height[leftP]));

            if (height[leftP] > height[rightP]){ // if left height is greater than right, then there should be chance of
                rightP--;                        // bigger right height in order to get bigger area
            }else {         // and vice-versa
                leftP++;
            }
        }
        return maxArea;
    }
}
