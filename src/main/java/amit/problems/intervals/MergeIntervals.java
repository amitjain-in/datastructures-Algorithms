package amit.problems.intervals;

import java.util.*;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
 */
public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<>();
        intervals.sort((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);
        Interval prev = null;
        Interval result = null;
        for (Interval curr : intervals) {
            if (prev == null) {
                result = curr;
            } else {
                if (result.end >= curr.start) {
                    result.end = Math.max(result.end, curr.end);
                } else {
                    mergedIntervals.add(result);
                    result = new Interval(curr.start, curr.end);
                }
            }
            prev = curr;
        }
        mergedIntervals.add(result);
        return mergedIntervals;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> returns = new LinkedList<>();

        int[] prev = null;
        int[] result = null;
        for (int[] curr : intervals) {
            if (prev == null) {
                result = new int[2];
                result[0] = curr[0];
                result[1] = curr[1];
            } else {
                if (result[1] >= curr[0]) {
                    result[1] = Math.max(result[1], curr[1]);
                } else {
                    returns.add(result);
                    result = new int[2];
                    result[0] = curr[0];
                    result[1] = curr[1];
                }
            }
            prev = curr;
        }
        if(result != null) {
            returns.add(result);
        }
        return returns.toArray(new int[returns.size()][2]);
    }


    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        })));
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{
                {1, 4}, {4, 5}
        })));
    }
}
