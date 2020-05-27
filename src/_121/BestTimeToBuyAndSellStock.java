package _121;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/1/20
 */
public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int ans = 0;
        int[] min = new int[prices.length];
        int[] max = new int[prices.length];
        min[0] = prices[0];
        for(int i = 1;i<prices.length;i++) min[i] = Math.min(min[i-1], prices[i]);
        max[prices.length-1] = prices[prices.length-1];
        for(int i = prices.length-2;i>=0;i--) max[i] = Math.max(max[i+1], prices[i]);
        for(int i = 0;i<prices.length;i++) ans = Math.max(ans, max[i] - min[i]);
        System.out.println(Arrays.toString(min) + Arrays.toString(max));
        return ans;
    }
}