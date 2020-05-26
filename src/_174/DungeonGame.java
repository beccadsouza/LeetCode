package _174;

/*
 * Created by Rebecca Dsouza on 5/7/20
 */
public class DungeonGame {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.calculateMinimumHP(new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}}));
    }
}
class Solution {
    public int function(int curr, int future){
        if(curr>=0 && future>=0) return 0;
        else if (curr<0 && future<0) return curr+future;
        else if(curr<0 && future>=0) return curr;
        else if(curr> Math.abs(future)) return 0;
        else return curr + future;
    }
    public int calculateMinimumHP(int[][] d) {
        int r=d.length, c=d[0].length;
        for(int i = r-2;i>=0;i--) d[i][c-1] = function(d[i][c-1],d[i+1][c-1]);
        for(int j=c-2;j>=0;j--)   d[r-1][j] = function(d[r-1][j],d[r-1][j+1]);
        for(int i=r-2;i>=0;i--) for(int j=c-2;j>=0;j--) d[i][j] = Math.max(function(d[i][j],d[i+1][j]),function(d[i][j],d[i][j+1]));
        return (d[0][0]>0)?1:Math.abs(d[0][0])+1;
    }
}