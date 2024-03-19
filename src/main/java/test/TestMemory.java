package test;

public class TestMemory {

    public static void main(String[] args) {


        int a = 4;

        testMethod(a);
        System.out.println(a);
    }

    private static void testMethod(int a) {
        a = 5;
        System.out.println(a);
    }
}
