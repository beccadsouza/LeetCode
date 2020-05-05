package _63;
/*
 * Created by Rebecca Dsouza on 5/5/20
 */
public class UniquePathsII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }
}
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        if(grid[0].length==0) return 1;

        int n = grid.length, m = grid[0].length;
        grid[n-1][m-1] = 1-grid[n-1][m-1];

        for(int i=m-2;i>=0;i--) grid[n-1][i] = (grid[n-1][i]==1)?0:grid[n-1][i+1];
        for(int i=n-2;i>=0;i--) grid[i][m-1] = (grid[i][m-1]==1)?0:grid[i+1][m-1];
        for(int i=n-2;i>=0;i--) for(int j=m-2;j>=0;j--) grid[i][j] = (grid[i][j]==1)?0:grid[i+1][j]+grid[i][j+1];

        return grid[0][0];
    }
}