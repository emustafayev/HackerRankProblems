package leet_code;

public class SignProductArray {

    public static void main(String[] args) {

        System.out.println(arraySign(new int[]{41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82, 70, 15, -41}));

    }

    public static int arraySign(int[] nums) { // fast, but more memory
        int result = 1;
        for (int i : nums) {
            if (i == 0) return 0;
            else if (i < 0) {
                result = -result; // minus or plus determine the result no need multiplication
            }
        }
        return result;
    }

    public int arraySign2(int[] nums) { // Less memory, but slow
        int result = 1;
        for (int num : nums)
            if (num == 0) return 0;
            else if (num < 0)
                result = -result;

        System.gc();
        return result;
    }
}
