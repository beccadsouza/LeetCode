package _41;

/*
 * Created by Rebecca Dsouza on 3/18/20
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(sol.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(sol.firstMissingPositive(new int[]{7,8,9,11,12}));
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean oneExists = false;
        for(int x : nums)
            if (x == 1) {
                oneExists = true;
                break;
            }
        if(!oneExists) return 1;
        for(int i = 0;i<nums.length;i++) if(nums[i]<=0 || nums[i]>nums.length) nums[i] = 1;
        for(int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            if(index==nums.length) nums[0] = -1*Math.abs(nums[0]);
            else nums[index] = -1*Math.abs(nums[index]);
        }
        for(int i = 1;i<nums.length;i++) if(nums[i]>0) return i;
        if(nums[0]>0) return nums.length;
        return nums.length + 1;

    }
}