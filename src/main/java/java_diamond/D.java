package java_diamond;

public interface D {
    default void display(){
        System.out.println("D display called");
    }
}
