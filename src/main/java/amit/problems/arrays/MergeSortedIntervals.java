package amit.problems.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * You have two sorted arrays, where each element is an interval. Now, merge the two array, overlapping intervals can be merged as a single one.
 * Input :
 * List 1 [1,2] , [3,9]
 * List 2 [4,5], [8, 10], [11,12]
 * Output: [1,2], [3,10], [11,12]
 */
public class MergeSortedIntervals {

    public static void main(String[] args) {
        int[][] i1 = new int[][]{{1, 2}, {3, 9}};
        int[][] i2 = new int[][]{{4, 5}, {8, 10}, {11, 12}};
        print(i1, i2, mergeIntervals(i1, i2));
    }

    static List<Interval> mergeIntervals(int[][] l1, int[][] l2) {
        List<Interval> result = new LinkedList<>();

        Interval[] sortedIntervals = mergeIntervalSort(l1, l2);//You can also solve this without sorting the arrays into single array but the number of condition becomes quite complex.

        Interval prev = sortedIntervals[0];
        for (int res = 1; res < sortedIntervals.length; res++) {
            Interval cur = sortedIntervals[res];
            if (prev.end < cur.start) {//Isn't overlapping interval
                result.add(prev);
                prev = cur;
            } else {
                if (cur.end > prev.end) {//Is overlapping, so forget the prev.end and use cur.end
                    prev.end = cur.end;
                }
            }
        }
        result.add(prev);
        return result;
    }

    /**
     * Sorts intervals based on first element of the interval and if they are equals then considers second elements of the intervals
     *
     * @param first - array of first intervals
     * @param second - array of second intervals
     * @return - Sort array of intervals
     */
    static Interval[] mergeIntervalSort(int[][] first, int[][] second) {
        Interval[] intervals = new Interval[first.length + second.length];
        int fCtr = 0;
        int sCtr = 0;
        int sortedIdx = 0;
        while (fCtr < first.length || sCtr < second.length) {
            //Either second array is fully processed or if first interval comes earlier in sorted order.
            if (sCtr == second.length || (fCtr < first.length && (first[fCtr][0] < second[sCtr][0] || (first[fCtr][0] == second[sCtr][0] && first[fCtr][1] <= second[sCtr][1])))) {
                intervals[sortedIdx] = new Interval(first[fCtr][0], first[fCtr][1]);
                fCtr++;
            } else {
                intervals[sortedIdx] = new Interval(second[sCtr][0], second[sCtr][1]);
                sCtr++;
            }
            sortedIdx++;
        }
        return intervals;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[ " + start + ", " + end + " ]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Interval interval = (Interval) o;
            return start == interval.start &&
                    end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    static void print(int[][] i1, int[][] i2, List<Interval> o) {
        System.out.println("Input:");
        System.out.println("L1: " + Arrays.deepToString(i1));
        System.out.println("L2: " + Arrays.deepToString(i2));
        System.out.println("Output:");
        System.out.println("TotalTime of intervals: " + o.stream().map(i -> i.end - i.start).reduce(Integer::sum).orElse(0));
        System.out.println("" + o + "\n");
    }
}
