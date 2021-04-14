package amit.problems.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    /**
     *
     * @param arr1 - Sorted by time interval list 1
     * @param arr2 - Sorted by time interval list 2
     * @return Intersection of these two interval arrays
     */
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<>();

        int first = 0;
        int second = 0;

        while(first < arr1.length && second < arr2.length) {
            if(arr1[first].start > arr2[second].end) {
                second++;
            } else if(arr2[second].start > arr1[first].end) {
                first++;
            } else {
                intervalsIntersection.add(new Interval(Math.max(arr1[first].start, arr2[second].start), Math.min(arr1[first].end, arr2[second].end)));
                if(arr1[first].end <= arr2[second].end) {
                    first++;
                } else if(arr1[first].end >= arr2[second].end) {
                    second++;
                }
            }
        }

        return intervalsIntersection.toArray(new Interval[0]);
    }

    /*
             Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
             Output: [2, 3], [5, 6], [7, 7]

             Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
             Output: [5, 7], [9, 10]
            */
    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
