package _45;
/*
 * Created by Rebecca Dsouza on 4/25/20
 */
public class JumpGameII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.jump(new int[]{2,3,1,1,4}));
    }
}
class Solution {
    public int jump(int[] nums) {
        int[]memo = new int[nums.length];
        memo[nums.length-1] = 0;
        for(int i = nums.length-2;i>=0;i--){
            memo[i] = Integer.MAX_VALUE - 10;
            if(nums[i]+i >= nums.length-1) memo[i] = 1;
            else{
                for(int j = nums[i]; j>=0;j--){
                    memo[i] = Math.min(memo[i], 1 + memo[i+j]);
                }
            }
        }
        return memo[0];
    }
}