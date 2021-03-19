package amit.problems.arrays;

import java.util.HashMap;

/**
 * Reference: https://www.hackerrank.com/challenges/climbing-the-leaderboard
 * Status: Cleared all test cases
 */
public class ClimbingLeaderBoard {

    /**
     *
     * @param scores - The leaderBoard scores in descending orders. Can contain duplicates, which implies multiple people are tied with that score. scores[i] > 0;
     * @param alice - Alice's incrementing personal scores for m games. alice[i] > 0;
     * @return - The rank of alice after each of the m games.
     */
    static int[] climbingLeaderBoard(int[] scores, int[] alice) {
        HashMap<Integer, Integer> ranks = new HashMap<>();
        int prevScore = Integer.MIN_VALUE;
        int rank = 1;
        for (int score : scores) {
            if (prevScore != score) {
                ranks.put(score, rank++);
                prevScore = score;
            }
        }

        int aliceIdx = 0;
        int scoresIdx = scores.length - 1;
        int[] aliceRanks = new int[alice.length];

        while (scoresIdx >= 0 && aliceIdx < alice.length) {
            while (scoresIdx > 0 && alice[aliceIdx] > scores[scoresIdx]) {
                scoresIdx--;
            }
            int aliceRank = ranks.get(scores[scoresIdx]);
            aliceRanks[aliceIdx] = scores[scoresIdx] > alice[aliceIdx] ? aliceRank + 1 : aliceRank; //if the first condition is met then it was the last rank
            aliceIdx++;
        }
        return aliceRanks;
    }
}
