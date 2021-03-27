package amit.problems.queues;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {

    private final Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {
    }

    /**
     *
     * Constraint - new 't' will always be greater than 't' passed earlier.
     * @param t - epoch time in milliseconds
     * @return The number of t which has occurred in the last 3000 milliseconds
     */
    public int ping(int t) {
        q.add(t);
        while (!q.isEmpty() && q.peek() < (t - 3000)) {
            q.remove();
        }

        return q.size();
    }
}

