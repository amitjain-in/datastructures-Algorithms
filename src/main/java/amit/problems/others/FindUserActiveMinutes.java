package amit.problems.others;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei]
 * indicates that the user with IDi performed an action at the minute timei.
 * <p>
 * Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.
 * <p>
 * The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode.
 * A minute can only be counted once, even if multiple actions occur during it.
 * <p>
 * You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.
 * <p>
 * Return the array answer as described above.
 * <p>
 * https://leetcode.com/problems/finding-the-users-active-minutes/
 */
public class FindUserActiveMinutes {

    //Status works
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] answer = new int[k];

        Map<Integer, HashSet<Integer>> userActivity = new HashMap<>();
        for (int[] log : logs) {
            userActivity.computeIfAbsent(log[0], l -> new HashSet<>()).add(log[1]);
        }

        for (Map.Entry<Integer, HashSet<Integer>> userActive : userActivity.entrySet()) {
            answer[userActive.getValue().size() - 1]++;
        }

        return answer;
    }
}
