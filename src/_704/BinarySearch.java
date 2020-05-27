package _704;
/*
 * Created by Rebecca Dsouza on 4/14/20
 */
public class BinarySearch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{-1,0,3,5,9,12},9));
        System.out.println(sol.search(new int[]{-1,0,3,5,9,12},2));
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) end = mid-1;
            else if(nums[mid]<target) start = mid+1;
        }
        return -1;
    }
}