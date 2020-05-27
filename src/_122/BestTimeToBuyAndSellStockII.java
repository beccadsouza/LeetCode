package _122;
/*
 * Created by Rebecca Dsouza on 4/6/20
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(sol.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(sol.maxProfit(new int[]{7,6,4,3,1}));
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i=1; i<prices.length; i++) if (prices[i]>prices[i-1]) ans += prices[i]-prices[i-1];
        return ans;
    }
}
