package _72;

/*
 * Created by Rebecca Dsouza on 5/6/20
 */
public class EditDistance {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minDistance("properties", "prosperity"));
    }
}
class Solution {
    public int minDistance(String s1, String s2) {
        int r = s1.length()+1, c = s2.length()+1;
        int[][] dp = new int[r][c];
        for(int i = 0;i<r;i++) dp[i][0] = i;
        for(int j = 0;j<c;j++) dp[0][j] = j;
        for(int i = 1;i<r;i++){
            for(int j = 1;j<c;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
            }
        }
        return dp[r-1][c-1];
    }
}