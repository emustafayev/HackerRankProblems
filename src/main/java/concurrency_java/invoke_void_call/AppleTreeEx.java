package concurrency_java.invoke_void_call;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class AppleTreeEx {


    static class AppleTree{


        public static AppleTree[] createTees(int size){
            AppleTree[] trees = new AppleTree[size];

            for (int i = 0; i < size; i++) {
                trees[i] = new AppleTree("Tree_" + i);
            }
            return trees;
        }

        private int numberOfApples;
        private String treeLabel;

        public AppleTree(String treeLabel){
            this.numberOfApples = 3;
            this.treeLabel = treeLabel;
        }

        public int pickApples(String name){
            try {
                System.out.println("Picking apples from " + treeLabel + " by " + name);
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Picked apples from " + treeLabel + " by " + name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return numberOfApples;
        }
    }


    public static void main(String[] args) {

        AppleTree[] trees = AppleTree.createTees(6);

        Callable<Void> picker1 =  createPicker(trees,0,2,"Bob");
        Callable<Void> picker2 =  createPicker(trees,2,4,"Jack");
        Callable<Void> picker3 =  createPicker(trees,4,6,"Robert");

        ForkJoinPool.commonPool().invokeAll(Arrays.asList(picker1,picker2,picker3));

    }

    private static Callable<Void> createPicker(AppleTree[] trees, int from, int to, String worker) {
        return () -> {
            for (int i = from; i < to; i++) {
                trees[i].pickApples(worker);
            }
            return null;
        };


    }


}
