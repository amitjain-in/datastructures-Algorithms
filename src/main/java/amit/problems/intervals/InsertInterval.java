package amit.problems.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of non-overlapping intervals sorted by their start time,
 * insert a given interval at the correct position and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 */
public class InsertInterval {


    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();

        Interval result = null;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start || interval.start > newInterval.end) {
                mergedIntervals.add(interval);
            } else if (interval.start < newInterval.start) {
                result = new Interval(interval.start, Math.max(interval.end, newInterval.end));
                mergedIntervals.add(result);
            } else if (result != null) {
                if (result.end > interval.start && interval.end > result.end) {
                    result.end = interval.end;
                }
            } else if (interval.start > newInterval.start) {
                result = new Interval(newInterval.start, Math.max(newInterval.end, interval.end));
                mergedIntervals.add(result);
            }
        }
        return mergedIntervals;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedIntervals = new ArrayList<>();

        int[] result = null;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0] || interval[0] > newInterval[1]) {
                mergedIntervals.add(interval);
            } else if (interval[0] < newInterval[0]) {
                result = new int[2];
                result[0] = interval[0];
                result[1] = Math.max(interval[1], newInterval[1]);
                mergedIntervals.add(result);
            } else if (result != null) {
                if (result[1] >= interval[0] && interval[1] > result[1]) {
                    result[1] = interval[1];
                }
            } else if (interval[0] > newInterval[0]) {
                result = new int[2];
                result[0] = newInterval[0];
                result[1] = Math.max(interval[1], newInterval[1]);
                mergedIntervals.add(result);
            }
        }
        return mergedIntervals.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}

