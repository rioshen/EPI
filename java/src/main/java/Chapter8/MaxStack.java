package Chapter8;

import java.util.Stack;

/**
 * Created by Carl Shen on 3/25/15.
 * Problem 8.1:
 * Design a stack that supports a max operation, which returns the max
 * element stored in the stack.
 *
 * Solution:
 * Maintain two stacks, one for normal usage and one for maximum value.
 * When new element is pushed onto the stack, compare it with the top element in the
 * max stack, if it's greater than the top, push it on to the stack.
 */
public class MaxStack<T extends Comparable<T>> {
    private Stack<T> stack = new Stack<T>();
    private Stack<T> maxStack = new Stack<T>();

    public void push(T data) {
        stack.push(data);
        if (maxStack.isEmpty() || maxStack.peek().compareTo(data) < 0) maxStack.push(data);
    }

    public T pop() {
        T data = stack.pop();
        if (data.equals(maxStack.peek())) maxStack.pop();
        return data;
    }

    public T peek() { return stack.peek(); }

    public T max() { return maxStack.peek(); }

    public boolean isEmtpy() { return stack.isEmpty(); }
}
