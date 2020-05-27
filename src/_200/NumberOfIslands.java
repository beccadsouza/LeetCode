package _200;
/*
 * Created by Rebecca Dsouza on 4/18/20
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                sol.numIslands(
                        new char[][]{
                                "11110".toCharArray(),
                                "11010".toCharArray(),
                                "11000".toCharArray(),
                                "00000".toCharArray()
                        }
                )
        );
        System.out.println(
                sol.numIslands(
                        new char[][]{
                                "11000".toCharArray(),
                                "11000".toCharArray(),
                                "00100".toCharArray(),
                                "00011".toCharArray()
                        }
                )
        );
    }
}
class Solution {

    int counter = 1;

    public void function(char[][] grid, int i, int j){
        grid[i][j] = '*';
        if(i!=0 && grid[i-1][j]=='1') function(grid, i-1, j);
        if(j!=0 && grid[i][j-1]=='1') function(grid, i, j-1);
        if(i!=grid.length-1 && grid[i+1][j]=='1') function(grid, i+1, j);
        if(j!=grid[0].length-1 && grid[i][j+1]=='1') function(grid, i, j+1);
    }

    public int numIslands(char[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    counter++;
                    function(grid, i, j);
                }
            }
        }
        return counter-1;
    }

}