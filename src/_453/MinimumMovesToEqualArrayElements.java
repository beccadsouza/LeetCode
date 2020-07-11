package _453;
/*
* Created by Rebecca Dsouza on 7/6/20
*/

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.minMoves(new int[]{1,2,3}));
    }
}
class Solution {
    public int minMoves(int[] nums) {
        int sum=0, min=Integer.MAX_VALUE;
        for(int x:nums){
            sum += x;
            min = Math.min(min,x);
        }
        return sum - min*nums.length;
    }
}