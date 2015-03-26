package Chapter8;

import java.util.Stack;

/**
 * Created by Carl Shen on 3/25/15.
 * Problem 8.6:
 * Processes buildings as they are presented t oit and tracks the buildings number that have
 * a view of sunset.
 *
 * Solution:
 * We use a stack to record buildings that have a view. Each time a building b is processed, and it
 * is taller than the building that on the top of the stack, we pop the stack until the top element
 * is taller than building b.
 */
public class ViewsOfSunset {
    private Stack<Integer> buildings = new Stack<Integer>();
    
    public int examineBuildingsWithSunset(int[] heights) {
        for (int height : heights) {
            while (!buildings.isEmpty() && buildings.peek() <= height) {
                buildings.pop();
            }
            buildings.push(height);
        }
        return buildings.size();
    }
}
