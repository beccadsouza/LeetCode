package _213;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/13/20
 */
public class HouseRobberII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rob(new int[]{2,3,2}));
        System.out.println(sol.rob(new int[]{1,2,3,1}));
    }
}
class Solution {
    public int robHelper(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int p2 = nums[n-1], p1 = nums[n-2], c;
        for(int i = n-3;i>=0;i--){
            c = Math.max(p2 + nums[i], p1);
            p2 = Math.max(p2, p1);
            p1 = c;
        }
        return Math.max(p2, p1);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        return Math.max(robHelper(Arrays.copyOfRange(nums, 0, n-1)),
                robHelper(Arrays.copyOfRange(nums, 1, n)));
    }
}