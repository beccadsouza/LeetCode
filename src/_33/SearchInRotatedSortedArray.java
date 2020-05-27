package _33;
/*
 * Created by Rebecca Dsouza on 4/19/20
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(sol.search(new int[]{4,5,6,7,0,1,2},3));
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1, mid;
        while(start<=end){
            mid = start + (end-start)/2;
            if(target==nums[mid]) return mid;
            if(nums[start]<=nums[mid]){ // left array is sorted
                if(nums[start]<= target && target<nums[mid]) end = mid-1;
                else start = mid+1;
            }
            if(nums[mid]<=nums[end]){ // right array is sorted
                if(nums[mid]<target && target<=nums[end]) start = mid+1;
                else end = mid-1;
            }
        }
        return -1;
    }
}