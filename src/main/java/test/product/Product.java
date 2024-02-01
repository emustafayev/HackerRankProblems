package test.product;

public class Product {
    private String name;
    private int count;

    public Product(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void increaseCount(int count){
        this.count += count;
    }


    public void decreaseCount(int count){
        this.count -= count;
    }
}
