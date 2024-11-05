package test;

public class FidanLearnsExceptions {


    public static void main(String[] args) throws DevideByZeroException {


        try {
devide();

        } catch (ArithmeticException e) {

            System.out.println("Error: " + e.getMessage());
            throw new DevideByZeroException();
        } finally {
            System.out.println("Finally");
        }



    }


    private static void devide(){
        int a = 10;
        int b = 0;
        int c = a / b;
        System.out.println(c);

    }
}
