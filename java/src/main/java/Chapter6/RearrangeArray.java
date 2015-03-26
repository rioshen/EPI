package Chapter6;

/**
 * Created by Carl Shen on 3/25/15.
 * Problem 6.1: Rearranges the elements in the array so that all elements less than A[i]
 * appear first, followed by elements equal to A[i], followed by elements greater than A[i]
 * Solution: We split the array into three ranges, less than the pivot, equals to the pivot
 * and greater than it and maintain three pointers at each starting point. Iterate over the
 * array and keep swapping elements.
 */
public class RearrangeArray {
    public void rearrange(int[] A, int i) {
        if (A == null || A.length == 0) return;
        int less = 0, equal = 0, greater = A.length - 1;
        while (equal <= greater) {
            if (A[equal] < A[i]) {
                swap(A, less, equal);
                less++;
                equal++;
            } else if (A[equal] > A[greater]) {
                swap(A, equal, greater);
                greater--;
            } else {
                equal++;
            }
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
