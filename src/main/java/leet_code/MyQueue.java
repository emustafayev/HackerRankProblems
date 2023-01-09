package leet_code;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    Deque<Integer> in;
    Deque<Integer> out;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        in.offerFirst(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        move();
        return out.pollFirst();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        move();
        return out.peekFirst();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.size() == 0 && out.size() == 0;
    }

    /**
     * Move all the elements from stack_in to stack_out
     * ref: https://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks
     */
    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public static void main(String[] args) {

        Deque<Integer> dq = new LinkedList<>();

        dq.addFirst(2);
//        dq.offerFirst()
        dq.addLast(3);
        dq.addFirst(1);
        dq.addLast(4);

        while (!dq.isEmpty()) {
            System.out.println(dq.pop()); // first element if not exists => NoSuchElementException
            System.out.println(dq.poll()); // first element if not exists => null
        }


//
//        MyQueue obj = new MyQueue();
//        obj.push(2);
//        int param_2 = obj.pop();
//        int param_3 = obj.peek();
//        boolean param_4 = obj.empty();
    }
}
