package leet_code;

import java.util.Stack;

public class EvalRPN {

    public static void main(String[] args) {


        System.out.println(evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }


    public static int evalRPN(String[] tokens) {

//      last-in-first-out (LIFO)
        Stack<Integer> stack = new Stack<>(); // costly data type: pop, push

        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    stack.push((int) (1D / stack.pop() * stack.pop()));
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        return stack.pop();
    }
}
