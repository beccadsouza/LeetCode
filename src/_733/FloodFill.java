package _733;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/11/20
 */
public class FloodFill {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}},1,1,2)));
    }
}
class Solution {
    int k, c, n, m;
    int[][] img;
    boolean[][] visited;
    public void function(int i, int j){
        if(img[i][j]!=k) return;
        img[i][j] = c;
        visited[i][j] = true;
        if(i+1<n  && !visited[i+1][j]) function(i+1,j);
        if(i-1>=0 && !visited[i-1][j]) function(i-1,j);
        if(j+1<m  && !visited[i][j+1]) function(i,j+1);
        if(j-1>=0 && !visited[i][j-1]) function(i,j-1);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        img = image;
        c = newColor;
        k = image[sr][sc];
        n = image.length;
        m = image[0].length;
        visited = new boolean[n][m];
        function(sr,sc);
        return img;
    }

}