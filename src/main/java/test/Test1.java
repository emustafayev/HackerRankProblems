package test;

interface Pow {
    static void wow() {
        System.out.println("In Pow.wow");
    }
}

abstract class Wow {
    /*static void wow() {
        System.out.println("In Wow.wow");
    }*/
}

public class Test1 extends Wow implements Pow {
    public static void main(String[] args) {

        Test1 test1 = new Test1();
//        test1.wow();

    }
}
