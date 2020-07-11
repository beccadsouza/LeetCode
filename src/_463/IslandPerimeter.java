package _463;
/*
* Created by Rebecca Dsouza on 7/7/20
*/

public class IslandPerimeter {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.islandPerimeter(
                new int[][]{
                    {0,1,0,0},
                    {1,1,1,0},
                    {0,1,0,0},
                    {1,1,0,0}
                }
        ));
    }
}
class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0, r = grid.length-1, c = grid[0].length-1;
        for(int i = 0; i<=r; i++){
            for(int j = 0; j<=c; j++){
                if(grid[i][j]==1){
                    count += 4;
                    if(i!=0 && grid[i-1][j]==1) count--;
                    if(i!=r && grid[i+1][j]==1) count--;
                    if(j!=0 && grid[i][j-1]==1) count--;
                    if(j!=c && grid[i][j+1]==1) count--;
                }
            }
        }
        return count;
    }
}