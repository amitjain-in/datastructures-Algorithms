package amit.problems.stacks;

/**
 * Write a program to sort a stack in ascending order. You should not make any assumptions about how the stack is implemented.
 * The following are the only functions that should be used to write this program: push | pop | peek | isEmpty.
 */
public class SortAStack {

    public static void main(String[] args) {
        SimpleStack<Integer> stack = new SimpleStack<>(Integer.class, "p1");
        stack.push(5).push(4).push(2).push(3).push(1);
        System.out.println(sort(stack));

    }

    public static SimpleStack<Integer> sort(SimpleStack<Integer> stack) {
        SimpleStack<Integer> resultStack = new SimpleStack<>(Integer.class, "intermediate");
        while (stack.isNotEmpty()) {
            int elem = stack.pop();
            if (resultStack.isNotEmpty() && resultStack.peek() > elem) {
                while (resultStack.peek() > elem) {
                    stack.push(resultStack.pop());
                }
            }
            resultStack.push(elem);
        }
        return resultStack;
    }
}
