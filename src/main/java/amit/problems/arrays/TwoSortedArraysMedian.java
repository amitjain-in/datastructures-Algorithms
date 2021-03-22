package amit.problems.arrays;

/**
 * Two sorted array and you have find their median
 * <p>
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Status : Working but there is a better solution of O(log(min(m, n)))
 */
public class TwoSortedArraysMedian {

    public static void main(String[] args) {
        TwoSortedArraysMedian twoSortedArraysMedian = new TwoSortedArraysMedian();
        System.out.println(twoSortedArraysMedian.findMedianSortedArrays(new int[]{1, 3}, new int[]{2})); //2.0
        System.out.println(twoSortedArraysMedian.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); //2.5
        System.out.println(twoSortedArraysMedian.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0})); //0.0
        System.out.println(twoSortedArraysMedian.findMedianSortedArrays(new int[]{}, new int[]{1})); //1.0
        System.out.println(twoSortedArraysMedian.findMedianSortedArrays(new int[]{2}, new int[]{})); //2.0
        System.out.println(twoSortedArraysMedian.findMedianSortedArrays(new int[]{2, 2, 4, 4}, new int[]{2, 2, 4, 4})); //3.0
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        boolean isOdd = (nums1.length + nums2.length) % 2 == 1;
        int medianIdx = (nums1.length + nums2.length) / 2 + (!isOdd ? -1 : 0);

        int curr = 0;
        int ptr1 = 0;
        int ptr2 = 0;

        while (curr < medianIdx) {
            if (ptr1 < nums1.length && ptr2 < nums2.length) {
                if (nums1[ptr1] == nums2[ptr2]) {
                    if (ptr1 + 1 < nums1.length && ptr2 + 2 < nums2.length) {
                        if (nums1[ptr1] < nums2[ptr2]) {
                            ptr1++;
                        } else {
                            ptr2++;
                        }
                    } else if (ptr1 + 1 < nums1.length) {
                        ptr1++;
                    } else {
                        ptr2++;
                    }
                } else if (nums1[ptr1] < nums2[ptr2]) {
                    ptr1++;
                } else {
                    ptr2++;
                }
            } else if (ptr1 < nums1.length) {
                ptr1++;
            } else {
                ptr2++;
            }
            curr++;
        }

        double median = 0.0;

        if (isOdd) {
            if (ptr1 < nums1.length && ptr2 < nums2.length) {
                median = Math.min(nums1[ptr1], nums2[ptr2]);
            } else if (ptr1 < nums1.length) {
                median = nums1[ptr1];
            } else {
                median = nums2[ptr2];
            }
        } else {
            if (ptr1 < nums1.length && ptr2 < nums2.length) {
                if (nums1[ptr1] < nums2[ptr2]) {
                    median = (nums1[ptr1] + (ptr1 + 1 < nums1.length ? Math.min(nums1[ptr1 + 1], nums2[ptr2]) : nums2[ptr2])) / 2.0;
                } else {
                    median = (nums2[ptr2] + (ptr2 + 1 < nums2.length ? Math.min(nums2[ptr2 + 1], nums1[ptr1]) : nums1[ptr1])) / 2.0;
                }
            } else if (ptr1 < nums1.length) {
                median = (nums1[ptr1] + nums1[ptr1 + 1]) / 2.0;
            } else {
                median = (nums2[ptr2] + nums2[ptr2 + 1]) / 2.0;
            }
        }

        return median;
    }
}
