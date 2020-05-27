package _330;
/*
 * Created by Rebecca Dsouza on 4/16/20
 */
public class PatchingArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minPatches(new int[]{1,3},6));
        System.out.println(sol.minPatches(new int[]{1,5,10},20));
        System.out.println(sol.minPatches(new int[]{1,2,2},5));
    }
}
class Solution {
    public int minPatches(int[] nums, int n) {
        long curr = 1, sum = 0;
        int ptr = 0, patches=0;
        while(curr<=n){
            if(ptr==nums.length || nums[ptr]>curr){
                sum += curr;
                patches++;
            }
            else{
                sum += nums[ptr];
                ptr++;
            }
            curr = sum+1;
        }
        return patches;
    }
}