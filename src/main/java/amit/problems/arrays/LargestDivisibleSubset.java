package amit.problems.arrays;

import java.util.*;


public class LargestDivisibleSubset {

    public static void main(String[] args) {
        LargestDivisibleSubset l = new LargestDivisibleSubset();
        System.out.println(l.largestDivisibleSubset(new int[]{1, 2, 3}));//1,2
        System.out.println(l.largestDivisibleSubset(new int[]{1, 2, 4, 8}));//1,2,4,8
        System.out.println(l.largestDivisibleSubset(new int[]{1}));//1
        System.out.println(l.largestDivisibleSubset(new int[]{5, 9, 18, 54, 108, 540, 90, 180, 360, 720}));//9,18,90,180,360,720
    }

    //Not working
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % num == 0) {
                    curr.add(nums[j]);
                    num = nums[j];
                }
            }
            if (curr.size() > result.size()) {
                result = new LinkedList<>(curr);
            }
        }

        return result;
    }
}

