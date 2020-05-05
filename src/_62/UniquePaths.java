package _62;

/*
 * Created by Rebecca Dsouza on 5/5/20
 */
public class UniquePaths {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3,2));
        System.out.println(sol.uniquePaths(7,3));
    }
}
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[2][m];
        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(i==n-1) memo[i%2][j] = 1;
                else{
                    if(j==m-1) memo[i%2][j] = 1;
                    else memo[i%2][j] = memo[i%2][j+1] + memo[1-i%2][j];
                }
            }
        }
        return memo[0][0];
    }
}