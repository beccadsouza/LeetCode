package _287;

/*
 * Created by Rebecca Dsouza on 3/28/20
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(sol.findDuplicate(new int[]{3,1,3,4,2}));
    }
}

class Solution {
    public int findDuplicate(int[] nums) {
        for(int x:nums)
            if(nums[Math.abs(x)-1]<0) return Math.abs(x);
            else nums[Math.abs(x)-1] *= -1;
        return -1;
    }
}
