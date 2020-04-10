package amit.problems.dp;

/**
 * The find the minimum number of experiments required to identify when the egg will break for given eggs and floors
 */
public class EggDrop {

    private static final int MAX_EGGS = 10000;
    private static final int MAX_FLOORS = 10000;

    public static void main(String[] args) {
        EggDrop eggDrop = new EggDrop();
        int [][] dp = new int[MAX_EGGS][MAX_FLOORS];
        System.out.println(eggDrop.getMinExperiments(2, 10, dp));
        System.out.println(eggDrop.getMinExperiments(5, 1000, dp));
    }

    /**
     *
     * @param eggs - The number of eggs available for experimentation
     * @param floors - The number of floors to test
     * @param dp - Dynamic Program
     * @return - The minimum numbers of experiments required to identify the floor where egg will break.
     */
    public int getMinExperiments(int eggs, int floors, int[][] dp) {
        if(floors == 1 || floors == 0 || eggs == 1) {
            return floors;
        }

        if(dp[eggs][floors] != 0) {
            return dp[eggs][floors];
        }

        int minDrops = Integer.MAX_VALUE;
        for (int floor = 1; floor <= floors; floor++) {
            //Minimise the worst case over drops.
            //First scenario is when the egg breaks at this floor hence recursive call over with egg - 1 and floor - 1 (Because your floors would reduce and you have one less egg.)
            //Second scenario is when the egg didn't break, in this case eggs remain same but the number of floors has been reduced by 'floor'.
            minDrops = Math.min(minDrops, Math.max(getMinExperiments(eggs - 1, floor - 1, dp), getMinExperiments(eggs, floors - floor, dp)));
        }
        minDrops++;
        dp[eggs][floors] = minDrops;
        return minDrops;
    }
}
