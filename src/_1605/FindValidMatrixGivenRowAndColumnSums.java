package _1605;

import java.util.Arrays;

/*
* Created by Rebecca Dsouza on 10/4/20
*/

public class FindValidMatrixGivenRowAndColumnSums {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.restoreMatrix(new int[]{3,8}, new int[]{4,7})));
        System.out.println(Arrays.deepToString(sol.restoreMatrix(new int[]{5,7,10}, new int[]{8,6,8})));
        System.out.println(Arrays.deepToString(sol.restoreMatrix(new int[]{14,9}, new int[]{6,9,8})));
        System.out.println(Arrays.deepToString(sol.restoreMatrix(new int[]{1,0}, new int[]{1})));
        System.out.println(Arrays.deepToString(sol.restoreMatrix(new int[]{0}, new int[]{0})));
    }
}
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];
        for(int row = 0;row<rowSum.length;row++){
            for(int col=0;col<colSum.length;col++){
                if(rowSum[row]<colSum[col]){
                    ans[row][col] = rowSum[row];
                    colSum[col] -= rowSum[row];
                    rowSum[row] = 0;
                }
                else{
                    ans[row][col] = colSum[col];
                    rowSum[row] -= colSum[col];
                    colSum[col] = 0;
                }
            }
        }
        return ans;
    }
}