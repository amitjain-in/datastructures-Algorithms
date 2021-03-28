package amit.problems.greedy;

public class CarPooling {

    public static void main(String[] args) {
        CarPooling carPooling = new CarPooling();
        System.out.println(carPooling.carPoolingSimple(new int[][]{
                {3, 2, 8}, {4, 4, 6}, {10, 8, 9}

        }, 11));//true

        System.out.println(carPooling.carPoolingSimple(new int[][]{
                {7, 5, 6}, {6, 7, 8}, {10, 1, 6}

        }, 16));//false
    }

    //Original Solution - Works only if the trips is ordered based start times.
    public boolean carPooling(int[][] trips, int capacity) {
        int[] dropOffs = new int[1000];
        int load = 0;
        int prevStart = -1;

        for (int[] trip : trips) {
            load += trip[0];
            int dropOffIdx = trip[1];
            while (dropOffIdx > prevStart && prevStart != -1) {
                load -= dropOffs[dropOffIdx];
                dropOffs[dropOffIdx] = 0;
                dropOffIdx--;
            }

            dropOffs[trip[2]] += trip[0];
            if (load > capacity) {
                return false;
            }
            prevStart = trip[1];
        }

        return true;
    }

    //Works for all cases
    public boolean carPoolingSimple(int[][] trips, int capacity) {
        int[] dropOffs = new int[1000];

        for (int[] trip : trips) {
            dropOffs[trip[1]] += trip[0];//People getting in at this stop
            dropOffs[trip[2]] -= trip[0];//People getting out at this stop.
        }

        for(int dropOff: dropOffs) {
            capacity -= dropOff;
            if(capacity < 0) {//The number of people in the trip at this particular stop went beyond the capacity of the car.
                return false;
            }
        }

        return true;
    }
}
