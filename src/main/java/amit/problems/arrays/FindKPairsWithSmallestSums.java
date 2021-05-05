package amit.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * <p>
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums
 */
public class FindKPairsWithSmallestSums {

    //https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        for (int i = 0; i < nums1.length && i < k; i++) heap.offer(new int[]{nums1[i], nums2[0], 0});

        while (k-- > 0 && !heap.isEmpty()) {
            int[] cur = heap.poll();
            result.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] == nums2.length - 1) continue;
            heap.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }

        return result;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums findKPairsWithSmallestSums = new FindKPairsWithSmallestSums();
        System.out.println(findKPairsWithSmallestSums.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 10));//[[1,1],[1,1],[2,1],[1,2],[1,2],[2,2],[1,3],[1,3],[2,3]]

    }
}
