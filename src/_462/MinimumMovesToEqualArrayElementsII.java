package _462;
/*
* Created by Rebecca Dsouza on 7/8/20
*/

import java.util.*;

public class MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.minMoves2(new int[]{1,2,3}));
    }
}
class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length/2, moves = 0;
        for(int x:nums) moves += Math.abs(x-nums[mid]);
        return moves;
    }
}