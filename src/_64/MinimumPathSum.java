package _64;

/*
 * Created by Rebecca Dsouza on 4/18/20
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}
class Solution {

    public int minPathSum(int[][] grid) {

        if(grid.length==0) return 0;

        for(int i = grid.length-1;i>=0;i--){

            for(int j=grid[0].length-1;j>=0;j--){

                int temp1=Integer.MAX_VALUE, temp2=Integer.MAX_VALUE;

                if(j!=grid[0].length-1) temp1 = grid[i][j+1];

                if(i!=grid.length-1) temp2 = grid[i+1][j];

                if(i!=grid.length-1 || j!=grid[0].length-1) grid[i][j] += Math.min(temp1, temp2);

            }
        }

        return grid[0][0];

    }

}
