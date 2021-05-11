package amit.problems.arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * https://leetcode.com/problems/remove-element
 */
public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement re = new RemoveElement();
        System.out.println(re.removeElement(new int[]{3, 2, 2, 3}, 3)); //[2,2]
        System.out.println(re.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));//[0, 1, 3, 0, 4]
    }

    //Status works
    public int removeElement(int[] nums, int val) {

        int currIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                currIdx--;
            } else {
                nums[currIdx] = nums[i];
            }
            currIdx++;
        }

        return currIdx;
    }
}
