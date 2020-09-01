package _154;
/*
* Created by Rebecca Dsouza on 7/26/20
*/

public class FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMin(new int[]{1,3,5}));
        System.out.println(sol.findMin(new int[]{2,2,2,0,1}));
    }
}
class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i = 1;i<nums.length;i++) min = Math.min(min,nums[i]);
        return min;
    }
}