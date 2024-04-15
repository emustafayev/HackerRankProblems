package leet_code.till_april;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid2("(]"));
    }

    private static boolean isValid2(String s) {

        Stack<Character> st = new Stack<>();

        for (char c :
                s.toCharArray()) {

            if (c == '{' || c == '(' || c == '[') {
                st.push(c);
            } else if (!st.isEmpty()) {
                if (c == ']' && st.peek() == '[') {
                    st.pop();
                } else if (c == '}' && st.peek() == '{') {
                    st.pop();
                } else if (c == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            } else return false;
        }
        return st.isEmpty();
    }


    public static boolean isValid3(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) // {}()[] ===>>>  })] ===>>> } == }
                return false;
        }
        return stack.isEmpty();
    }


    // Not working
    public static boolean isValid1(String s) {

        AtomicInteger tracker = new AtomicInteger();

        s.chars().forEach(p -> {
            System.out.println(p);
            switch (p) {
                case 40:
                case 123:
                    tracker.getAndIncrement();
                    break;
                case 41:
                case 125:
                    tracker.getAndDecrement();
                    break;
            }
        });

        System.out.println(tracker.get());

        throw new IllegalArgumentException("Not finished yet");
    }
}
