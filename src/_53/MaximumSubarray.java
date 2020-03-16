package _53;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 3/16/20
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int ptr = 0, ans = 0, temp = 0;

        while(ptr<nums.length){
            temp += nums[ptr];
            if(temp<=0) temp = 0;
            else ans = Math.max(ans, temp);
            ptr++;
        }

        if(ans==0) return Arrays.stream(nums).max().getAsInt();
        else return ans;
    }
}