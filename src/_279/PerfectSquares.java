package _279;
/*
* Created by Rebecca Dsouza on 8/8/20
*/
import java.util.*;
public class PerfectSquares {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numSquares(12));
        System.out.println(sol.numSquares(13));
    }
}
class Solution {
    public int numSquares(int n) {
        List<Integer> al = new ArrayList<>();
        for(int i = 1; i*i<=n;i++) al.add(i*i);
        if(al.contains(n)) return 1;
        int[] ways = new int[n+1];
        int ptr = 0;
        for(int i = 1;i<n+1;i++){
            if(ptr<al.size() && al.get(ptr)==i){
                ways[i] = 1;
                ptr++;
            }
            else{
                int ans = Integer.MAX_VALUE;
                for(int j = 0;j<ptr;j++) ans = Math.min(ans, ways[i-al.get(j)]+1);
                ways[i] = ans;
            }
        }
        return ways[n];
    }
}