package amit.problems.others;

/**
 * Reference - Search hackerrank "Making candies".
 * Constraints
 * 1<= machines, workers, price, candies <= 10^12
 */
public class MakeCandies {

    // Complete the minimumPasses function below. The parameters are meant to be
    static long minimumPasses(long m, long w, long p, long n) {
        return minPassBruteForce(m, w, p, n);
    }

    //Not working. Java has a number problem. Either use Java's BigDecimal or use Python.
    //Java - > still won't pass with BigDecimal because even with long some test cases were timing out. I also used DP in maximise, still timing out.
    static long minPassBruteForce(long machines, long workers, long price, long candies) {
        long totalPasses = 1;
        long output = machines * workers;//This causes long overflow e.g. when m = 4_294_967_297L and w = 4_294_967_297L
        while (output < candies) {
            if (output >= price && (candies - output) > machines * workers) {
                long[] newData = maximise(machines, workers, price, output);
                machines = newData[0];
                workers = newData[1];
                output = newData[2];
            }
            output += (machines * workers);
            totalPasses++;
        }
        return totalPasses;
    }

    static long[] maximise(long currMachines, long currWorkers, long price, long candies) {
        long totalNewPurchases = candies / price;
        long maxProduct = currMachines * currWorkers;
        long newMachines = currMachines;
        long newWorkers = currWorkers;
        for (long machinePurchased = 0; machinePurchased <= totalNewPurchases; machinePurchased++) {
            long product = (currMachines + machinePurchased) * (currWorkers + totalNewPurchases - machinePurchased);
            if (product > maxProduct) {
                newMachines = currMachines + machinePurchased;
                newWorkers = currWorkers + (totalNewPurchases - machinePurchased);
                maxProduct = product;
            }
        }
        return new long[]{newMachines, newWorkers, candies - totalNewPurchases * price};
    }

    public static void main(String[] args) {

    }
}
