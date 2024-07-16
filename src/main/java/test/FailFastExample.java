package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastExample {

    public static void main(String[] args) {

//        List<Integer> al = new ArrayList<>();
//        al.add(3);
//        al.add(4);
//        al.add(5);
//        al.add(6);
//        al.add(7);
//
//        Iterator<Integer> itr = al.iterator();
//
//        while (itr.hasNext()) {
//            if (itr.next() == 4) {
//                itr.remove();
//            }
//        }
//
//        System.out.println(al);
//
//        itr = al.iterator();
//
//        while (itr.hasNext()) {
//            if (itr.next() == 5) {
//                al.remove(3);
//            }
//        }
//
//        System.out.println(al);

        test();

    }

    private static void test(){
        CopyOnWriteArrayList<Integer> list
                = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 });

        list.add(1);

        System.out.println(list);


        ConcurrentHashMap<String, Integer> map
                = new ConcurrentHashMap<String, Integer>();

        map.put("key", 10);
    }
}
