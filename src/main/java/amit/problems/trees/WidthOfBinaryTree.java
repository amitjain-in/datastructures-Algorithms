package amit.problems.trees;

import amit.problems.trees.inttree.TreeNode;

import java.util.HashMap;
import java.util.Map;

//Status not working, the side calculation is wrong.
public class WidthOfBinaryTree {

    //[1,1,1,1,null,null,1,1,null,null,1]
    public int widthOfBinaryTree(TreeNode root) {
        Map<Integer, MinMax> widthMap = new HashMap<>();
        widthOfBinaryTree(root, widthMap, 0, 0);
        int max = 1;
        for (MinMax minMax : widthMap.values()) {
            if (minMax.min != Integer.MAX_VALUE && minMax.max != Integer.MIN_VALUE) {
                max = Math.max(minMax.max - minMax.min, max);
            }
        }
        return max;
    }

    void widthOfBinaryTree(TreeNode root, Map<Integer, MinMax> widthMap, int level, int side) {
        if (root != null) {
            MinMax minMax = widthMap.computeIfAbsent(level, l -> new MinMax());
            minMax.min = Math.min(minMax.min, side);
            minMax.max = Math.max(minMax.max, side);
            widthOfBinaryTree(root.left, widthMap, level + 1, side - 1);
            widthOfBinaryTree(root.right, widthMap, level + 1, side + 1);
        }
    }

    static class MinMax {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
}
