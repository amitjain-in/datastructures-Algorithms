package amit.problems.arrays;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 */
public class SortColours {

    public static void main(String[] args) {
        SortColours s = new SortColours();
        s.sort(new int[]{2,0,1});
//        s.sort(new int[]{2,0,2,1,1,0});
//        s.sort(new int[]{0, 0, 0});
//        s.sort(new int[]{0, 0, 1});
//        s.sort(new int[]{1, 2, 1});
//        s.sort(new int[]{1, 0, 1});
//        s.sort(new int[]{2, 1, 1});
//        s.sort(new int[]{2, 1, 0});
    }

    //Not working 2, 0, 1
    public void sort(int[] nums) {
        int zeroes = 0;
        int ones = 0;

        for(int num: nums) {
            switch(num) {
                case 0: zeroes++; break;
                case 1: ones++; break;
            }
        }

        int iZero = 0;
        int iOne = zeroes;
        int itwo = nums.length - 1;

        while(iZero < zeroes || iOne < zeroes + ones || itwo >= zeroes + ones) {
            while(iZero < zeroes && nums[iZero] == 0) {
                iZero++;
            }
            while(iOne < zeroes + ones && nums[iOne] == 1) {
                iOne++;
            }
            while(itwo >= zeroes + ones && nums[itwo] == 2) {
                itwo--;
            }

            if(iZero < zeroes && nums[iZero] == 1 && iOne < zeroes + ones && nums[iOne] == 0) {
                nums[iZero++] = 0;
                nums[iOne++] = 1;
            }

            if(iZero < zeroes && itwo >= zeroes + ones && nums[iZero] == 2 && nums[itwo] == 0) {
                nums[iZero++] = 0;
                nums[itwo--] = 2;
            }

            if(itwo >= zeroes + ones && iOne < zeroes + ones && nums[iOne] == 2 && nums[itwo] == 1) {
                nums[iOne++] = 1;
                nums[itwo--] = 2;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
