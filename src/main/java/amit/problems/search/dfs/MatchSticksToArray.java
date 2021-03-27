package amit.problems.search.dfs;

/**
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has,
 * please find out a way you can make one square by using up all those matchsticks. You should not break any stick,
 * but you can link them up, and each matchstick must be used exactly one time.
 * <p>
 * Your input will be several matchsticks the girl has, represented with their stick length.
 * Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * <p>
 * https://leetcode.com/problems/matchsticks-to-square/
 *
 * Status: Not working
 */
public class MatchSticksToArray {

    public static void main(String[] args) {
        MatchSticksToArray matchSticksToArray = new MatchSticksToArray();
      //  System.out.println(matchSticksToArray.makesquare(new int[]{1, 1, 2, 2, 2}));//true
      //  System.out.println(matchSticksToArray.makesquare(new int[]{3, 3, 3, 3, 4}));//false
      //  System.out.println(matchSticksToArray.makesquare(new int[]{10, 6, 5, 5, 5, 3, 3, 3, 2, 2, 2, 2}));//true
        System.out.println(matchSticksToArray.makesquare(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));//true

    }

    public boolean makesquare(int[] nums) {
        int squareSide = findSquareSide(nums);
        if (squareSide != -1) {
            return isSquare(nums, squareSide, new int[nums.length], 4, 0);
        }
        return false;
    }


    public boolean isSquare(int[] nums, int squareSide, int[] used, int counter, int sum) {
        return false;
    }

//    public boolean isSquare(int[] nums, int squareSide, int[] used, int counter, int sum) {
//        boolean foundSum = false;
//        for (int i = 0; i < nums.length; i++) {
//            if (used[i] <= 0 && used[i] != -1 * counter) {
//                if (sum + nums[i] == squareSide) {
//                    sum += nums[i];
//                    used[i] = counter;
//                    foundSum = true;
//                    break;
//                } else if (sum + nums[i] < squareSide) {
//                    sum += nums[i];
//                    used[i] = counter;
//                }
//            }
//        }
//        if (foundSum) {
//            if (counter == 1) {
//                return true;
//            } else {
//                if(isSquare(nums, squareSide, used, counter - 1, 0)) {
//                    return true;
//                } else {
//                    int backtrack = nums.length - 1;
//                    while (backtrack >= 0) {
//                        if (used[backtrack] == counter) {
//                            used[backtrack] = -counter;
//                            sum -= nums[backtrack];
//                            return isSquare(nums, squareSide, used, counter, sum);
//                        }
//                        backtrack--;
//                    }
//                }
//            }
//        } else {
//            int backtrack = nums.length - 1;
//            while (backtrack >= 0) {
//                if (used[backtrack] == counter) {
//                    used[backtrack] = -counter;
//                    sum -= nums[backtrack];
//                    return isSquare(nums, squareSide, used, counter, sum);
//                }
//                backtrack--;
//            }
//        }
//        return false;
//    }

    public int findSquareSide(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total % 4 == 0 ? total / 4 : -1;
    }
}
