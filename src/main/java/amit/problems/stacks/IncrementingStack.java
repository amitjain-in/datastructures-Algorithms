package amit.problems.stacks;


/**
 * Implement a stack which has a maxSize, if you are try to push any element when the stack size has reached maxsize, the elements pushed will be ignored.
 * The pop method when called when stack size is 0 returns -1;
 * This stack will also have an additional increment method which takes in two parameters k and val, this method will increment the bottom k elements by val value
 *
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 *
 * Status: working
 */
public class IncrementingStack {

    private final int[] stack;
    private int size = -1;

    public IncrementingStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (size < stack.length - 1) {
            stack[++size] = x;
        }
    }

    public int pop() {
        if (size >= 0) {
            return stack[size--];
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i <= size; i++) {
            stack[i] += val;
        }
    }
}