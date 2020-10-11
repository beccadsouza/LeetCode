package _1615;

/*
* Created by Rebecca Dsouza on 10/11/20
*/

import java.util.*;

public class MaximalNetworkRank {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maximalNetworkRank(4,new int[][]{{0,1},{0,3},{1,2},{1,3}}));
        System.out.println(sol.maximalNetworkRank(5,new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}));
        System.out.println(sol.maximalNetworkRank(8,new int[][]{{0,1},{1,2},{2,3},{2,4},{5,6},{5,7}}));
    }
}
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer,Integer> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();
        int ans = 0;
        for(int[] road:roads){
            hm.put(road[0],hm.getOrDefault(road[0],0)+1);
            hm.put(road[1],hm.getOrDefault(road[1],0)+1);
            hs.add(Math.min(road[0],road[1]) + ":" + Math.max(road[0],road[1]));
        }
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(hs.contains(i+":"+j)) ans = Math.max(ans, hm.getOrDefault(i,0) + hm.getOrDefault(j,0) - 1);
                else ans = Math.max(ans, hm.getOrDefault(i,0) + hm.getOrDefault(j,0));
            }
        }
        return ans;
    }
}