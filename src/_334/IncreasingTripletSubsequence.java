package _334;

/*
 * Created by Rebecca Dsouza on 3/10/20
 */
public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(sol.increasingTriplet(new int[]{5,4,3,2,1}));
    }
}
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }

        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;

        for(int x=0;x<nums.length;x++){
            if(nums[x]<i)
                i = nums[x];
            else if(nums[x]>i)
                j = Math.min(j, nums[x]);
            if(nums[x]>j)
                return true;
        }
        return false;
    }
}