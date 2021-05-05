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
 * <p>
 */
public class MatchSticksToArray {

    public static void main(String[] args) {
        MatchSticksToArray matchSticksToArray = new MatchSticksToArray();
        System.out.println(matchSticksToArray.makesquare(new int[]{1, 1, 2, 2, 2}));//true
        System.out.println(matchSticksToArray.makesquare(new int[]{3, 3, 3, 3, 4}));//false
        System.out.println(matchSticksToArray.makesquare(new int[]{10, 6, 5, 5, 5, 3, 3, 3, 2, 2, 2, 2}));//true
        System.out.println(matchSticksToArray.makesquare(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}));//true
        System.out.println(matchSticksToArray.makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3}));//true
        System.out.println(matchSticksToArray.makesquare(new int[]{7, 1, 13, 6, 19, 18, 12, 3, 15, 4, 20, 11, 2, 15, 14}));//true
    }

    //solutions works but times out. Also adding memoization doesn't help. Simple do as dfs instead over sorted array
    public boolean makesquare(int[] nums) {
        int squareSide = findSquareSide(nums);
        if (squareSide != -1) {
            return countSubsets(nums, squareSide, 4, 0, 0);
        }
        return false;
    }

    private static final int USED = -1;

    boolean countSubsets(int[] arr, int subsetSum, int count, int currentSum, int indicesUsed) {
        if (count == 0) {
            return indicesUsed == arr.length;
        }

        for (int idx = 0; idx < arr.length; idx++) {
            if (arr[idx] != USED) {
                if (arr[idx] > subsetSum) {
                    return false;
                } else {
                    int element = arr[idx];
                    arr[idx] = USED;
                    boolean found;
                    if (currentSum + element == subsetSum) {
                        found = countSubsets(arr, subsetSum, count - 1, 0, indicesUsed + 1);
                    } else {
                        found = countSubsets(arr, subsetSum, count, currentSum + element, indicesUsed + 1);
                    }
                    if (found) {
                        return true;
                    } else {
                        arr[idx] = element;//backtrack
                    }
                }
            }
        }

        return false;
    }

    public int findSquareSide(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total % 4 == 0 ? total / 4 : -1;
    }
}
