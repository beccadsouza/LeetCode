package _55;
/*
 * Created by Rebecca Dsouza on 4/25/20
 */
public class JumpGame {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canJump(new int[]{2,3,1,1,4}));
        System.out.println(sol.canJump(new int[]{3,2,1,0,4}));
    }
}
class Solution {
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length-1;
        for(int i = nums.length-2;i>=0;i--) if((i+nums[i])>=lastIndex) lastIndex = i;
        return lastIndex==0;
    }
}