package _547;
/*
* Created by Rebecca Dsouza on 10/7/20
*/
import java.util.*;
public class FriendCircles {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
        System.out.println(sol.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(sol.findCircleNum(new int[][]{{1,1,0},{1,1,1},{0,1,1}}));
    }
}
class Solution {
    public int findCircleNum(int[][] M) {
        Integer[] parent = new Integer[M.length];
        for(int i = 0;i<parent.length;i++) parent[i] = i;
        for(int i = 0;i<M.length;i++)
            for(int j=0;j<i;j++)
                if(M[i][j]==1){
                    int high = Math.max(parent[i],parent[j]);
                    int low = Math.min(parent[i],parent[j]);
                    for(int k=0;k<parent.length;k++) if(parent[k]==high) parent[k] = low;
                }
        HashSet<Integer> hs = new HashSet<>(Arrays.asList(parent));
        return hs.size();
    }
}