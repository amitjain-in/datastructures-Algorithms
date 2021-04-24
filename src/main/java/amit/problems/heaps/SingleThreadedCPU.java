package amit.problems.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] means that the
 * ith task will be available to process at enqueueTimei and will take processingTimei to finish processing.
 *
 * You have a single-threaded CPU that can process at most one task at a time and will act in the following way:
 *
 *     If the CPU is idle and there are no available tasks to process, the CPU remains idle.
 *     If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time.
 *     If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
 *     Once a task is started, the CPU will process the entire task without stopping.
 *     The CPU can finish a task then start a new one instantly.
 *
 * Return the order in which the CPU will process the tasks.
 *
 * https://leetcode.com/problems/single-threaded-cpu/
 *
 * Status works
 */
public class SingleThreadedCPU {

    public static void main(String[] args) {
        SingleThreadedCPU cpu = new SingleThreadedCPU();
        System.out.println(Arrays.toString(cpu.getOrder(new int[][]{
                {1, 2}, {2, 4}, {3, 2}, {4, 1}
        }))); //[0, 2, 3, 1]

        System.out.println(Arrays.toString(cpu.getOrder(new int[][]{
                {19, 13}, {16, 9}, {21, 10}, {32, 25}, {37, 4}, {49, 24}, {2, 15}, {38, 41}, {37, 34}, {33, 6}, {45, 4}, {18, 18}, {46, 39}, {12, 24}
        }))); //[6, 1, 2, 9, 4, 10, 0, 11, 5, 13, 3, 8, 12, 7]

        System.out.println(Arrays.toString(cpu.getOrder(new int[][]{
                {7, 1}, {6, 3}, {1, 3}
        }))); //[2, 1, 0]
    }

    public int[] getOrder(int[][] tasks) {

        PriorityQueue<Task> minHeap = new PriorityQueue<>((ta, tb) -> ta.processTime == tb.processTime ? ta.index - tb.index : ta.processTime - tb.processTime);

        Task[] tasksArr = new Task[tasks.length];
        for (int t = 0; t < tasks.length; t++) {
            tasksArr[t] = new Task(tasks[t][0], tasks[t][1], t);
        }

        //The input is not sorted based on start time. It is more efficient to sort this rather than finding min start time on each iteration.
        Arrays.sort(tasksArr, Comparator.comparingInt(o -> o.startTime));

        int[] order = new int[tasks.length];
        int time = 0;
        int o = 0;
        for (int t = 0; t < tasksArr.length || !minHeap.isEmpty(); ) {

            while (t < tasksArr.length && tasksArr[t].startTime <= time) {//This task can now be executed by CPU.
                minHeap.add(tasksArr[t]);
                t++;
            }
            if (minHeap.isEmpty()) {
                time = tasksArr[t].startTime;//Just skip to the earliest start time of available tasks to be executed
            }
            if (minHeap.peek() != null) {
                Task task = minHeap.remove();
                order[o++] = task.index;
                time += task.processTime;
            }
        }

        return order;
    }

    static class Task {
        final int startTime;
        final int processTime;
        final int index;

        public Task(int startTime, int processTime, int index) {
            this.startTime = startTime;
            this.processTime = processTime;
            this.index = index;
        }
    }
}