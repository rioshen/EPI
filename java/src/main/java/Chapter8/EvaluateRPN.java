package Chapter8;

import java.util.Stack;

/**
 * Created by Carl Shen on 3/25/15.
 * Problem 8.2:
 * Take a expression in RPN and returns the number that the expression evaluates to
 *
 * Solution:
 * Maintain a stack to hold operands, once we encounter numbers, push onto the stack
 * and if we encounter operators pop the previous two from the stack and push the result
 * back to the stack.
 * Time Complexity is O(N), where N means the number of elements in the string.
 * Space Complexity is O(n), where n means the number of operands in the string.
 */
public class EvaluateRPN {
    public int evaluate(String exp) {
        if (exp == null || exp.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                if (stack.isEmpty() || stack.size() < 2) {
                    throw new IllegalArgumentException();
                }
                int a = stack.pop(), b = stack.pop();
                stack.push(calculate(a, b, c));
            }
        }
        return stack.pop();
    }

    public int calculate(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: return a / b;
        }
    }
}
