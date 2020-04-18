package amit.problems.recursion;

/**
 * https://leetcode.com/problems/reaching-points
 *
 */
public class ReachingPoints {

    //Backtracking - doesn't scale for when s is very small compared to t.
    public boolean reachingPointsNaive(int sx, int sy, int tx, int ty) {
        if (sy > ty || sx > tx) {
            return false;
        }
        if (sx == tx && sy == ty) {
            return true;
        }

        return reachingPointsNaive(sx, sx + sy, tx, ty) || reachingPointsNaive(sx + sy, sy, tx, ty);
    }
}
