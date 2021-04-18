package amit.problems.recursion;

import java.util.HashMap;

/**
 * Given a number ‘n’, write a function to return the count of structurally unique Binary Search Trees (BST) that can store values 1 to ‘n’.
 */
public class CountUniqueTrees {

    public int countTrees(int n, HashMap<Integer, Integer> memory) {
        if (memory.containsKey(n))
            return memory.get(n);
        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int leftCount = countTrees(i - 1, memory);
            int rightCount = countTrees(n - i, memory);
            count += (leftCount * rightCount);//Because each combination of left can go with each combination of right hence it is left * right
        }
        memory.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        CountUniqueTrees cut = new CountUniqueTrees();
        for(int i = 1; i <= 10; i++) {
            System.out.println("n = " + i + ", combinations# = " + cut.countTrees(i, new HashMap<>()));
        }
    }
}
