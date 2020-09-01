package _153;
/*
* Created by Rebecca Dsouza on 7/26/20
*/

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMin(new int[]{3,4,5,1,2}));
        System.out.println(sol.findMin(new int[]{4,5,6,7,0,1,2}));
    }
}
class Solution {
    public int findMin(int[] nums) {
        int begin = 0, end = nums.length-1, mid;
        if(end==0) return nums[end];
        if(end==1) return Math.min(nums[begin], nums[end]);
        if(nums[begin]<nums[end]) return nums[begin];
        if(nums[begin]>nums[end] && nums[end-1]>nums[end]) return nums[end];
        while(begin<=end){
            mid = begin + (end-begin)/2;
            if(mid!=0 && nums[mid-1]>nums[mid]) return nums[mid];
            if(mid!=nums.length-1 && nums[mid+1]<nums[mid]) return nums[mid+1];
            if(nums[end]>nums[mid]) end = mid-1;
            else begin = mid+1;
        }
        return -1;
    }
}