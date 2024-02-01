package test.service;

import test.product.Product;

import java.util.HashMap;
import java.util.Map;

public class StoreServiceImpl implements StoreService{

    private Map<String, Product> productMap;

    public StoreServiceImpl() {
        this.productMap = new HashMap<>();
    }

    @Override
    public void buyProduct(String name, int count) {
        if (!productMap.containsKey(name)){
            productMap.put(name,new Product(name, count));
        }else {
            Product product = productMap.get(name);
            product.increaseCount(count);
        }
    }

    @Override
    public void sellProduct(String name, int count) {
        if (!productMap.containsKey(name)){
            System.out.println("There is no product to sell");
        }else {
            Product product = productMap.get(name);
            //add some validations
            //product count less than 1
            product.decreaseCount(count);
        }
    }
}
