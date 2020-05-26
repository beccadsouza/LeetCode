package _1035;
/*
 * Created by Rebecca Dsouza on 5/26/20
 */
public class UncrossedLines {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(sol.maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(sol.maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }
}
class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i = 1;i<A.length+1;i++) for(int j = 1;j<B.length+1;j++)
            dp[i][j] = (A[i-1]==B[j-1])?dp[i-1][j-1]+1:Math.max(dp[i-1][j], dp[i][j-1]);
        return dp[A.length][B.length];
    }
}