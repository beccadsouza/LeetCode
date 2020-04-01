package _48;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 3/29/20
 */
public class RotateImage {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] matrix = new int[][]{{ 5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        sol.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        sol.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        int temp, dim = matrix.length;
        for(int i = 0;i<dim-1;i++)
            for(int col = dim-1,row = dim-1;col>i&&row>i;col--,row--){
                temp = matrix[i][col];
                matrix[i][col] = matrix[row][i];
                matrix[row][i] = temp;
            }
        for(int i = 0;i<dim;i++)
            for(int j = 0;j<(int)Math.floor(dim/2);j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][dim-j-1];
                matrix[i][dim-j-1] = temp;
            }
    }
}