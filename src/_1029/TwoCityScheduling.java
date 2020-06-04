package _1029;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/4/20
 */
public class TwoCityScheduling {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
    }
}
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (x, y)-> Math.abs(y[0]-y[1]) - Math.abs(x[0]-x[1]));
        // System.out.println(Arrays.deepToString(costs));
        int countA = 0, countB = 0, N = costs.length/2, ans = 0;
        for (int[] cost : costs) {
            if (cost[0] < cost[1] && countA < N || countB == N) {
                ans += cost[0];
                countA++;
            } else {
                ans += cost[1];
                countB++;
            }
        }
        return ans;
    }
}