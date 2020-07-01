package _322;

/*
 * Created by Rebecca Dsouza on 7/1/20
 */

public class CoinChange {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(sol.coinChange(new int[]{2}, 3));
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount+1];
        for(int amt = 1; amt<amount+1; amt++){
            int minCoins = Integer.MAX_VALUE-amount;
            for (int coin : coins)  if (amt - coin >= 0) minCoins = Math.min(minCoins, memo[amt - coin]);
            memo[amt] = minCoins+1;
        }
        return memo[amount]>amount?-1:memo[amount];
    }
}