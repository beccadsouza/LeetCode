package _1143;
/*
 * Created by Rebecca Dsouza on 4/26/20
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestCommonSubsequence("abcde", "ace"));
        System.out.println(sol.longestCommonSubsequence("abc", "abc"));
        System.out.println(sol.longestCommonSubsequence("abc", "def"));
    }
}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray(), s2 = text2.toCharArray();
        int l1 = s1.length, l2 = s2.length;
        int[][] DP = new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++)
            for(int j=1;j<=l2;j++)
                if(s1[i-1]==s2[j-1]) DP[i][j] = DP[i-1][j-1] + 1;
                else DP[i][j] = Math.max(DP[i][j-1], DP[i-1][j]);
        return DP[l1][l2];
    }
}