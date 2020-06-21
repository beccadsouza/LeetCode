package _518;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/7/20
 */
public class CoinChange2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.change(5,new int[]{1,2,5}));
        System.out.println(sol.change(3,new int[]{2}));
        System.out.println(sol.change(10,new int[]{10}));
    }
}
class Solution {

    public int change(int amount, int[] coins){
        if(amount==0) return 1;
        Arrays.sort(coins);
        if(coins.length==0 || coins[0]>amount) return 0;
        else{
            int[][] dp = new int[amount][coins.length];
            for(int i = 0;i<coins.length;i++) dp[coins[0]-1][i] = 1;
            for(int j = 0;j<amount;j++) if((j+1)%coins[0]==0) dp[j][0] = 1;
            for(int amt = coins[0]+1;amt<amount+1;amt++){
                for(int c=1; c<coins.length;c++){
                    int i = amt-1;
                    int j = c;
                    dp[i][j] += dp[i][j-1];
                    if(amt==coins[c]) dp[i][j]++;
                    else if(amt>coins[c]){
                        int diff = amt-coins[c];
                        dp[i][j] += dp[diff-1][j];
                    }
                }
            }
            return dp[amount-1][coins.length-1];
        }
    }

    // TOP DOWN RECURSIVE SOLUTION
    // Map<String, Integer> hm = new HashMap<>();
    // public int function(int amount, int[] coins, int index){
    //     String k = amount+","+index, key;
    //     int ans = 0, temp=0;
    //     for(int i = index;i<coins.length;i++){
    //         if(coins[i]==amount) ans++;
    //         else if(coins[i]<amount){
    //             temp = amount-coins[i];
    //             key = temp+","+i;
    //             if(hm.containsKey(key)) ans += hm.get(key);
    //             else ans += function(temp, coins, i);
    //         }
    //         else break;
    //     }
    //     hm.put(k, ans);
    //     return ans;
    // }
    // public int change(int amount, int[] denom) {
    //     if(amount==0) return 1;
    //     Arrays.sort(denom);
    //     return function(amount, denom, 0);
    // }
}