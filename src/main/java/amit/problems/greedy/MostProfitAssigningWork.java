package amit.problems.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job.
 *
 * Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i].
 *
 * Every worker can be assigned at most one job, but one job can be completed multiple times.
 *
 * For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.
 *
 * What is the most profit we can make?
 *
 * https://leetcode.com/problems/most-profit-assigning-work/
 *
 * Status works
 */
public class MostProfitAssigningWork {

    public static void main(String[] args) {
        MostProfitAssigningWork mostProfitAssigningWork = new MostProfitAssigningWork();
        System.out.println(mostProfitAssigningWork.maxProfitAssignment(
                new int[]{2, 4, 6, 8, 10},
                new int[]{10, 20, 30, 40, 50},
                new int[]{4, 5, 6, 7})); //100
    }

    //Status works but you can use dp to improve this further to O(max(worker, difficulty) See this https://leetcode.com/problems/most-profit-assigning-work/discuss/175676/Java-Memorization-without-sortBeat-99.85
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Job[] jobs = new Job[difficulty.length];
        for (int i = 0; i < difficulty.length; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        Arrays.sort(jobs, Comparator.comparingInt(j -> j.profit));
        Arrays.sort(worker);
        int job = jobs.length - 1;
        int totalProfit = 0;
        for (int work = worker.length - 1; work >= 0; work--) {
            while (job >= 0 && jobs[job].difficulty > worker[work]) {
                job--;
            }
            if (job >= 0 && jobs[job].difficulty <= worker[work]) {
                totalProfit += jobs[job].profit;
            }
        }

        return totalProfit;
    }

    private static class Job {
        final int difficulty;
        final int profit;

        public Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
}
