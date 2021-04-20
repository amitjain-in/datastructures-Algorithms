package amit.problems.greedy;


/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 *
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution, it is guaranteed to be unique
 *
 * https://leetcode.com/problems/gas-station/
 *
 */
public class GasTank {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, negatives = 0, currentTank = 0;

        for (int i = 0; i < gas.length; i++) {
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) { //if car fails at 'start', record the next station
                start = i + 1;
                negatives += currentTank;//Store all the negative tanks in negatives.
                currentTank = 0;
            }
            System.out.println("Tank = " + currentTank + " Total = " + negatives + " start = " + start + " gas[i] = " + gas[i] + " cost[i] = " + cost[i]);
        }

        return (negatives + currentTank < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        GasTank gt = new GasTank();
        System.out.println(gt.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})); //3
        System.out.println(gt.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3})); //-1
        System.out.println(gt.canCompleteCircuit(new int[]{5, 8, 2, 8}, new int[]{6, 5, 6, 6})); //3
    }
}
