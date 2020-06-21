package _456;

/*
 * Created by Rebecca Dsouza on 6/12/20
 */
public class Pattern132 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(sol.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(sol.find132pattern(new int[]{-1, 3, 2, 0}));
    }
}
class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3) return false;
        int prev = nums[0], curr = Integer.MIN_VALUE, prevCopy = Integer.MAX_VALUE, currCopy = curr;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]<prev){
                prevCopy = Math.min(prev, prevCopy);
                currCopy = Math.max(curr, currCopy);
                prev = Math.min(prev, nums[i]);
                curr = Integer.MIN_VALUE;
            }
            if((nums[i]<curr && nums[i]>prev) || (nums[i]<currCopy && nums[i]>prevCopy)){
                return true;
            }
            if(nums[i]>prev){
                curr = Math.max(curr, nums[i]);
            }
        }
        return false;
    }
}
