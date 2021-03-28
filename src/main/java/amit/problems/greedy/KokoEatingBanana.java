package amit.problems.greedy;

import java.util.Arrays;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 * <p>
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile.
 * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * <p>
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * <p>
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 * <p>
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBanana {

    public static void main(String[] args) {
        KokoEatingBanana kokoEatingBanana = new KokoEatingBanana();
//        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));//4
//        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));//30
//        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));//23
        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{312884470}, 312884469));
    }

    //This works technically but can be slow for single large numbers.
    public int minEatingSpeed(int[] piles, int h) {
        //3,6,7,11 -27 hours 8  27 / 8= 3  1,2,3,

        long totalBananas = Arrays.stream(piles).sum();
        int k = (int) (totalBananas / h);

        while (true) {
            int remaining = h;
            for (int pile : piles) {
                int rem = pile % k;
                remaining -= (rem == 0 ? 0 : 1) + pile / k;
                if (remaining < 0) {
                    break;
                }
            }
            if (remaining == 0) {
                break;
            }
            k++;
        }

        return k;
    }
}
