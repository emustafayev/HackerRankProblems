package concurrency_java.invoke_join_call;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AppleTreeEx {

    static class PickFruitTask extends RecursiveTask<Integer> {
        private final AppleTree[] trees;
        private final int startInc;
        private final int endInc;

        private final int threadHold = 4;

        PickFruitTask(AppleTree[] trees, int startInc, int endInc) {
            this.trees = trees;
            this.startInc = startInc;
            this.endInc = endInc;
        }


        protected Integer doCompute(){
            return IntStream.rangeClosed(startInc, endInc)
                    .map(i -> trees[i].pickApples("Thread_" + Thread.currentThread().getName()))
                    .sum();
        }

        @Override
        protected Integer compute() {

            System.out.println(startInc + " " + endInc);

            if (endInc - startInc <= threadHold) {
                return doCompute();
            }

            int midIndex = startInc + (endInc - startInc) / 2;
            PickFruitTask leftTask = new PickFruitTask(trees, startInc, midIndex);
            PickFruitTask rightTask = new PickFruitTask(trees, midIndex + 1, endInc);

            rightTask.fork();
            return leftTask.compute() + rightTask.join();
        }
    }


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

        PickFruitTask task = new PickFruitTask(AppleTree.createTees(12), 0, 11);
        Integer result = ForkJoinPool.commonPool().invoke(task);
        System.out.println("Res: " + result);

    }


}
