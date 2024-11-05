package java_diamond;

public class C implements A,B{

//
//    @Override
//    public void display() {
//        A.super.display();
//        B.super.display();
//    }

    public static void main(String[] args) {
        C c  = new C();
        c.display();
    }
}
