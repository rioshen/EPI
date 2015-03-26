package Chapter8;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Carl Shen on 3/25/15.
 */
public class MaxStackTest {
    private MaxStack<Integer> stack = new MaxStack<Integer>();

    @Test
    public void testEmpty() {
        assertTrue(stack.isEmtpy());
    }

    @Test
    public void testPushOne() {
        stack.push(10);
        assertTrue(stack.peek() == 10);
        assertTrue(stack.max() == 10);
    }

    @Test
    public void testPushMany() {
        stack.push(10);
        assertTrue(stack.max() == 10);
        stack.push(11);
        assertTrue(stack.max() == 11);
        stack.pop();
        assertTrue(stack.max() == 10);
    }
}
