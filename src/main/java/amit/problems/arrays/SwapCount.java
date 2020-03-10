package amit.problems.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class SwapCount {


    // Complete the countInversions function below. Works only when the elements are unique
    static long countInversions(int[] arr) {
        Map<Integer, Integer> ogIdxMap = getIndex(arr);
        int[] sortedArr = getSortedArray(arr);
        int totalSwaps = 0;
        for (int i = sortedArr.length - 1; i >= 0; i--) {
            int ogIdx = ogIdxMap.get(sortedArr[i]);
            int delta = i - ogIdx;
            System.out.println("E=" + sortedArr[i] + " idx=" + ogIdx + " delta=" + delta);
            if (delta > 0) {
                totalSwaps += delta;
                for (int j = ogIdx + 1; j <= i; j++) {
                    System.out.println("Re=" + arr[j] + " newIdx=" + (ogIdxMap.get(arr[j]) - 1));
                    ogIdxMap.put(arr[j], ogIdxMap.get(arr[j]) - 1);
                }
            }
        }
        return totalSwaps;
    }

    static int[] getSortedArray(int[] arr) {
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        return sortedArr;
    }

    static Map<Integer, Integer> getIndex(int[] arr) {
        Map<Integer, Integer> arrIdx = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //arrIdx.computeIfAbsent(arr[i], k -> new LinkedList<>()).add(i);
            arrIdx.put(arr[i], i);
        }
        return arrIdx;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] arr = new int[n];
            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
