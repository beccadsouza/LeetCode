package _661;
/*
* Created by Rebecca Dsouza on 7/14/20
*/

import java.util.Arrays;

public class ImageSmoother {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(
            sol.imageSmoother(
                new int[][]{{1,1,1},{1,0,1},{1,1,1}})
            )
        );
    }
}
class Solution{
    public int[][] imageSmoother(int[][] M){
        int r = M.length, c = M[0].length;
        int[][] pos = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}}, grayM = new int[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                int num = 0, denom = 0;
                for(int[] p:pos){
                    int x = i+p[0], y = j+p[1];
                    if(x>=r || y>=c || x<0 || y<0) continue;
                    num += M[x][y];
                    denom++;
                }
                grayM[i][j] = (int)Math.floor(num/denom);
            }
        }
        return grayM;
    }
}