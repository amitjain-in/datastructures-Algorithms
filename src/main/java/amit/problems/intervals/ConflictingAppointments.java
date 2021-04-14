package amit.problems.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        Interval prev = null;
        for(Interval curr: intervals) {
            if(prev != null) {
                if(prev.end > curr.start) {
                    return false;
                }
            }
            prev = curr;
        }
        return true;
    }

    public static List<Interval> conflictAppointments(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        List<Interval> conflicts = new LinkedList<>();
        Interval prev = null;
        for(Interval curr: intervals) {
            if(prev != null) {
                if(prev.end > curr.start) {
                    conflicts.add(prev);
                    conflicts.add(curr);
                }
            }
            prev = curr;
        }
        return conflicts;
    }

    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)};
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result + " - Conflicts: " + conflictAppointments(intervals));

        Interval[] intervals1 = {new Interval(6, 7), new Interval(2, 4), new Interval(8, 12)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result + " - Conflicts: " + conflictAppointments(intervals1));

        Interval[] intervals2 = {new Interval(4, 5), new Interval(2, 3), new Interval(3, 6)};
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result + " - Conflicts: " + conflictAppointments(intervals2));
    }
}
