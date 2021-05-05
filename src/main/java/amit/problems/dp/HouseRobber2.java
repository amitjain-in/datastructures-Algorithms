package amit.problems.dp;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber2 {

    //Status: works
    public int rob(int[] houses) {
        final int firstRobbed = 0;
        final int firstNotRobbed = 1;
        if (houses == null || houses.length == 0) {
            return 0;
        }

        int[][] dp = new int[houses.length][2];

        dp[0][firstRobbed] = houses[0]; //The 0th index column will be for calculations when we have considered first house as robbed
        dp[0][firstNotRobbed] = 0;       //The 1th index column will be for calculations when we haven't considered first house as robbed.

        if (houses.length > 1) {
            dp[1][firstRobbed] = Math.max(houses[0], houses[1]);
            dp[1][firstNotRobbed] = houses[1];
        }

        for (int house = 2; house < houses.length; house++) {
            if (house == houses.length - 1) {
                //Because he could have robbed the first house hence cannot rob last one due circular houses arrangement.
                dp[house][firstRobbed] = dp[house - 1][firstRobbed];
            } else {
                dp[house][firstRobbed] = Math.max(dp[house - 1][firstRobbed], dp[house - 2][firstRobbed] + houses[house]);
            }
            dp[house][firstNotRobbed] = Math.max(dp[house - 1][firstNotRobbed], dp[house - 2][firstNotRobbed] + houses[house]);
        }

        return Math.max(dp[houses.length - 1][firstRobbed], dp[houses.length - 1][firstNotRobbed]);
    }
}
