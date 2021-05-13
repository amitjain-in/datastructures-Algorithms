package amit.problems.slidingwindow;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container,
 * such that the container contains the most water.
 *
 * Notice that you may not slant the container
 *
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {

    //Works
    public int maxArea(int[] height) {
        if (height.length <= 0) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;

        while (start < end) {
            maxArea = Math.max(maxArea, Math.min(height[end], height[start]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        System.out.println(containerWithMostWater.maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));//17
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 7, 5, 8, 1}));//14
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));//49
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 1}));//1
        System.out.println(containerWithMostWater.maxArea(new int[]{4, 3, 2, 1, 4}));//16
        System.out.println(containerWithMostWater.maxArea(new int[]{0, 2}));//0
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 0, 0, 0, 0, 0, 0, 2, 2}));//8
    }
}
