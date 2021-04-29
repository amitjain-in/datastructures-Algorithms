package amit.problems.dp;

import java.util.HashMap;
import java.util.Map;

public class FurthestBuilding {

    public static void main(String[] args) {
        FurthestBuilding fb = new FurthestBuilding();
        System.out.println(fb.furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1)); //4
        System.out.println(fb.furthestBuilding(new int[]{4, 2, 7, 6, 9, 8, 12}, 5, 1)); //4
        System.out.println(fb.furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2)); //4
    }


    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        Map<String, Integer> memo = new HashMap<>();
        return furthestBuilding(heights, bricks, ladders, 1, memo);
    }


    //Slow approach even after memoization as this will bricks is very big.
    public int furthestBuilding(int[] heights, int bricks, int ladders, int index, Map<String, Integer> memo) {
        if (memo.get(index + "_" + bricks + "_" + ladders) != null) {
            return memo.get(index + "_" + bricks + "_" + ladders);
        }
        if (index == heights.length) {
            return 0;
        }

        if(heights[index - 1] < heights[index]) {
            if(bricks < (heights[index] - heights[index - 1]) && ladders <= 0) {
                return 0;
            }
        }

        int max = 0;
        if (heights[index - 1] >= heights[index]) {
            max = 1 + furthestBuilding(heights, bricks, ladders, index + 1, memo);
        } else {
            int remainBricks = bricks - (heights[index] - heights[index - 1]);
            int removeBricks =  remainBricks >= 0 ?
                    furthestBuilding(heights, remainBricks, ladders, index + 1, memo) : 0;
            int removeLadder = ladders - 1 >= 0 ? furthestBuilding(heights, bricks, ladders - 1, index + 1, memo) : 0;
            max = 1 + Math.max(removeBricks, removeLadder);
            //System.out.println(index + "_" + bricks + "_" + ladders + " - " +  max + " - " + remainBricks + " - " + removeLadder);
        }
        memo.put(index + "_" + bricks + "_" + ladders, max);
        return max;
    }
}