package _35;


/*
 * Created by Rebecca Dsouza on 6/10/20
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.searchInsert(new int[]{1,3,5,6},5));
        System.out.println(sol.searchInsert(new int[]{1,3,5,6},2));
        System.out.println(sol.searchInsert(new int[]{1,3,5,6},7));
        System.out.println(sol.searchInsert(new int[]{1,3,5,6},0));
    }
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(nums[mid]==target) return mid;
            else{
                if(nums[mid]>target){
                    // element lesser than target to the left || mid is 0
                    if(mid==0 || nums[mid-1]<target) return mid;
                    else if(nums[mid-1]==target) return mid-1;
                    else end = mid-1;
                }
                else{
                    // element greater than target to the right || mid is length of nums - 1
                    if(mid==nums.length-1 || nums[mid+1]>=target) return mid+1;
                    else start = mid+1;
                }
            }
        }
        return -1;
    }
}