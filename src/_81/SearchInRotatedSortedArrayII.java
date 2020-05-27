package _81;
/*
 * Created by Rebecca Dsouza on 4/20/20
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{2,5,6,0,0,1,2},0));
        System.out.println(sol.search(new int[]{2,5,6,0,0,1,2},3));
    }
}
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0) return false;
        int start = 0, end = nums.length-1, mid;
        while(nums[start]==nums[end]){
            if(nums[start]==target) return true;
            else{
                start++;
                end--;
            }
            if(end<0) return false;
        }
        while(start<=end){
            mid = start + (end-start)/2;
            if(target==nums[mid]) return true;
            if(nums[start]<=nums[mid]){ // left array is sorted
                if(nums[start]<= target && target<nums[mid]) end = mid-1;
                else start = mid+1;
            }
            if(nums[mid]<=nums[end]){ // right array is sorted
                if(nums[mid]<target && target<=nums[end]) start = mid+1;
                else end = mid-1;
            }
        }
        return false;
    }
}