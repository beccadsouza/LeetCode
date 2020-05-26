package _746;
/*
 * Created by Rebecca Dsouza on 5/8/20
 */
public class MinCostClimbingStairs {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(sol.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
class Solution {
    public int minCostClimbingStairs(int[] c) {
        for(int i = c.length-3;i>=0;i--) c[i] = c[i] + Math.min(c[i+1],c[i+2]);
        return Math.min(c[0],c[1]);
    }
}