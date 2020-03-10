package amit.problems.stacks;

import java.util.Arrays;

public class PoisonousPlants {

    public static void main(String[] args) {

    }

    // Complete the poisonousPlants function below. *** Not working ***
    static int poisonousPlants(int[] plants) {
        System.out.println("P=" + Arrays.toString(plants));
        int maxDays = 0;
        int currDays = 0;
        int currMin = plants[0];
        int prevPlant = plants[0];
        for (int plant : plants) {
            if (plant < currMin) {
                currMin = plant;
            }
            if (plant > currMin) {
                currDays++;
                if (prevPlant < plant && currDays > 1) {
                    currDays--;
                }
                System.out.println(plant + " - " + currDays);
            } else {
                currDays = 0;
            }
            if (currDays > maxDays) {
                maxDays = currDays;
            }
            prevPlant = plant;
        }
        return maxDays;
    }
}
