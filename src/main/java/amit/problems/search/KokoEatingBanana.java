package amit.problems.search;

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
        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));//4
        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));//30
        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));//23*/
        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{312884470}, 312884469));//2
        System.out.println(kokoEatingBanana.minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589,
                290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818)); //14

    }

    //Works
    public int minEatingSpeed(int[] piles, int h) {

        int k = Arrays.stream(piles).max().getAsInt();

        int low = 1, high = k, mid = low + (high - low) / 2;

        while (low <= high) {
            int hoursRemain = h;
            for (int pile : piles) {
                hoursRemain -= pile / mid + (pile % mid == 0 ? 0 : 1);
                if (hoursRemain < 0) {
                    break;
                }
            }
            if (hoursRemain >= 0) {
                //We could eat all the bananas with this 'mid' but we will improve our results.
                k = Math.min(mid, k);
                high = mid - 1;

            } else {
                low = mid + 1;
            }
            mid = low + (high - low) / 2;
        }

        return k;
    }
}
