package _1510;

import java.util.*;

/*
* Created by Rebecca Dsouza on 7/11/20
*/

public class StoneGameIV {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.winnerSquareGame(1));
        System.out.println(sol.winnerSquareGame(2));
        System.out.println(sol.winnerSquareGame(4));
        System.out.println(sol.winnerSquareGame(7));
        System.out.println(sol.winnerSquareGame(17));
    }
}
class Solution {
    public boolean winnerSquareGame(int n) {
        List<Integer> al = new ArrayList<>();
        boolean[] memo = new boolean[n + 1];
        boolean ans, temp;
        for (int i = 1; (i * i) <= n; i++) al.add(i * i);
        for (int x : al) memo[x] = true;
        for (int i = 1; i < n + 1; i++) {
            ans = false;
            if (!al.contains(i)) {
                for (int elem : al) {
                    if (elem < i) {
                        temp = !(memo[i - elem]);
                        ans = ans || temp;
                    }
                }
                memo[i] = ans;
            }
        }
        return memo[n];
    }
}