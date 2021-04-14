package amit.problems.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        int minStart = jobs.stream().min(Comparator.comparingInt(o -> o.start)).get().start;
        int maxEnd = jobs.stream().max(Comparator.comparingInt(o -> o.end)).get().end;
        int[] rooms = new int[maxEnd - minStart + 1];

        for (Job job : jobs) {
            rooms[job.start - minStart] += job.cpuLoad;
            rooms[job.end - minStart] -= job.cpuLoad;
        }

        int count = 0;
        int max = 0;
        for (int room : rooms) {
            count += room;
            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5), new Job(5, 7, 10)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}