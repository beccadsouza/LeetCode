package _540;

/*
 * Created by Rebecca Dsouza on 4/14/20
 */
public class SingleElementInASortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(sol.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
    }
}
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0, end = nums.length-1,mid;
        while(true){
            mid = start+(end-start)/2;
            System.out.println("start: "+start+" mid: "+mid+" end: "+end);
            if((mid-1)>=start && nums[mid-1]==nums[mid]){
                if((end-mid)%2==0) end = mid-2;
                else start = mid+1;
            }
            else if((mid+1)<=end && nums[mid+1]==nums[mid]){
                if((mid-start)%2==0) start = mid+2;
                else end = mid-1;
            }
            else return nums[mid];
        }
    }
}