package amit.problems.greedy;


/**
 *
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 *
 * https://leetcode.com/problems/can-place-flowers/
 */
public class PlaceFlowers {

    public static void main(String[] args) {
        PlaceFlowers placeFlowers = new PlaceFlowers();
        System.out.println(placeFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));//true
        System.out.println(placeFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));//false
        System.out.println(placeFlowers.canPlaceFlowers(new int[]{1, 1, 0, 0}, 1));//true
        System.out.println(placeFlowers.canPlaceFlowers(new int[]{0, 0, 1, 0}, 1));//true
        System.out.println(placeFlowers.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));//false
    }


    //Status: works
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int bed = 0;
        int lastFlower = -2;//In case the first is empty can second is also empty. Hence -2 and not -1

        while (n > 0 && bed < flowerbed.length) {
            if (flowerbed[bed] == 0) {
                //The last flower was at least 1 gap before now, and the next is either empty or the end of flower pot.
                if (lastFlower < bed - 1 && ((bed + 1 < flowerbed.length && flowerbed[bed + 1] == 0 || bed == flowerbed.length - 1))) {
                    n--;
                    //Since we are have put new flower here. Mark the variables
                    flowerbed[bed] = 1;
                    lastFlower = bed;
                }
            } else {
                lastFlower = bed;
            }
            bed++;
        }

        return n == 0;
    }
}
