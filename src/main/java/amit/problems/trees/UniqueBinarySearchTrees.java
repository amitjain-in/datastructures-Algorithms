package amit.problems.trees;

/**
 *
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        for(int i = 1; i < 20; i++) {
            System.out.println(i + ": " + uniqueBinarySearchTrees.numTreesOptimised(i));
        }
    }

    //Works
    public int numTreesNaive(int n) {
        if(n <= 1) {
            return 1;
        }
        int total = 0;
        for(int i = 1; i <= n; i++) {
            total += numTreesNaive(i - 1) * numTreesNaive(n - i);
        }

        return total;
    }

    //Works
    public int numTreesOptimised(int n) {
       int[] memo = new int[n + 1];
        memo[0] = 1;
        if(n > 1) {
            memo[1] = 1;
        }
        return numTrees(n, memo);
    }

    private int numTrees(int n, int[] memo) {
        if(memo[n] != 0) {
            return memo[n];
        }

        int total = 0;
        for(int i = 1; i <= n; i++) {
            total += numTrees(i - 1, memo) * numTrees(n - i, memo);
        }
        memo[n] = total;
        return total;
    }
}
