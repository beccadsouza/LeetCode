package _309;
/*
* Created by Rebecca Dsouza on 7/30/20
*/
import java.util.*;
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxProfit(new int[]{1,2,3,0,2}));
    }
}
class Solution {
    HashMap<String, Integer> hm = new HashMap<>();
    public int function(int[] prices, int index, int state, int stock){
        int profit = 0;
        if(index<prices.length) {
            String key = index + ":" + state + ":" + stock;
            if(hm.containsKey(key)) return hm.get(key);
            if(state==1){ // SELL
                for(int i = index;i<prices.length;i++) if(prices[i]>stock)
                    profit = Math.max(profit, prices[i]-stock + function(prices, i+2,0,0));
            }
            else{ // BUY
                profit = Math.max(profit, function(prices, index+1, 1, prices[index]));
                profit = Math.max(profit, function(prices, index+1, 0, 0));
            }
            hm.put(key,profit);
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        return function(prices,0,0,0);
    }
}