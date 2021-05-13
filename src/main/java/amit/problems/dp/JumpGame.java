package amit.problems.dp;

public class JumpGame {

    //Find if we can reach the last index of the array [Works]
    public boolean jump(int[] nums) {
        int maxJump = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (maxJump >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

   //Find the minimum moves to reach last index of array [Works]
    public int jump2(int[] nums) {

        int jumps = 0, distance = 0, maxDistance = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (i == distance) {
                jumps++;
                distance = maxDistance;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGame jg = new JumpGame();
        System.out.println(jg.jump2(new int[]{4, 1, 1, 3, 1, 1, 1}));//2
        System.out.println(jg.jump2(new int[]{2, 3, 1, 1, 4}));//2
        System.out.println(jg.jump2(new int[]{2, 3, 0, 1, 4}));//2
        System.out.println(jg.jump2(new int[]{1, 1, 1, 1}));//3
        System.out.println(jg.jump2(new int[]{3, 1, 1, 1}));//1
        System.out.println(jg.jump2(new int[]{2, 3, 1}));//1
        System.out.println(jg.jump2(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));//2
    }
}
