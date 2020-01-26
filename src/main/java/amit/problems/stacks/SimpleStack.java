package amit.problems.stacks;

import java.lang.reflect.Array;

/**
 * Stack implementation. Obviously not thread-safe
 *
 * @param <T> - the type of stack.
 */
public class SimpleStack<T> {

    private static final int DEFAULT_SIZE = 10;
    private T[] array;
    private Class<T> tClass;
    private int elemSize = 0;
    private final String name;

    @SuppressWarnings("unchecked")
    public SimpleStack(Class<T> tClass, String name, int initialSize) {
        array = (T[]) Array.newInstance(tClass, initialSize);
        this.tClass = tClass;
        this.name = name;
    }

    public SimpleStack(Class<T> tClass, String name) {
        this(tClass, name, DEFAULT_SIZE);
    }

    public T pop() {
        if (elemSize > 0) {
            elemSize--;
            return array[elemSize];
        }
        return null;
    }

    public T peek() {
        return elemSize > 0 ? array[elemSize - 1] : null;
    }

    public int size() {
        return elemSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(name + ":[");
        for (int i = 0; i < elemSize; i++) {
            T elem = array[i];
            if (elem != null) {
                str.append(elem).append(",");
            }
        }
        int lastComma = str.lastIndexOf(",");
        str.delete(lastComma, str.length());
        str.append("]");
        return str.toString();
    }

    @SuppressWarnings("unchecked")
    public SimpleStack<T> push(T elem) {
        if (elemSize == array.length) {
            //Time to resize array
            T[] temp = array;
            array = (T[]) Array.newInstance(tClass, array.length * 2);
            System.arraycopy(temp, 0, array, 0, temp.length);
        }
        array[elemSize] = elem;
        elemSize++;
        return this;
    }

    public static void main(String[] args) {
        SimpleStack<Integer> simpleStack = new SimpleStack<>(Integer.class, "p1");
        simpleStack.push(1).push(2).push(3);
        System.out.println(simpleStack.pop());
        simpleStack.push(4);
        System.out.println(simpleStack.pop());
        System.out.println(simpleStack.pop());
        System.out.println(simpleStack.pop());
        System.out.println(simpleStack.pop());
    }
}
