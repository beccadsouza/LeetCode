package _1277;

/*
 * Created by Rebecca Dsouza on 7/2/20
 */
public class CountSquareSubmatricesWithAllOnes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countSquares(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}));
    }
}
class Solution {
    public int countSquares(int[][] mat) {
        int count = 0, m = mat.length, n = mat[0].length;
        for(int i = 0; i<m; i++)
            for(int j = 0; j<n; j++){
                if(i!=0 && j!=0 && mat[i][j]>0)
                    mat[i][j] = Math.min(Math.min(mat[i-1][j], mat[i][j-1]),mat[i-1][j-1])+1;
                count += mat[i][j];
            }
        return count;
    }
}