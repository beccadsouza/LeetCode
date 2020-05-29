package _221;
/*
 * Created by Rebecca Dsouza on 4/28/20
 */
public class MaximalSquare {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                sol.maximalSquare(
                        new char[][]{
                                "10100".toCharArray(),
                                "10111".toCharArray(),
                                "11111".toCharArray(),
                                "10010".toCharArray(),
                        }
                )
        );
    }
}
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int ans = 0, temp;
        for(int i = 1;i<matrix.length;i++)
            for(int j = 1;j<matrix[0].length;j++)
                if(matrix[i][j]=='1'){
                    temp = Math.min(matrix[i-1][j-1]-'0',Math.min(matrix[i][j-1]-'0',matrix[i-1][j]-'0')) + 1;
                    ans = Math.max(ans, temp);
                    matrix[i][j] = (char)(temp +'0');
                }
        if(ans==0)
            for(int i = 0;i<matrix[0].length;i++)
                if(matrix[0][i]=='1'){
                    ans = 1;
                    break;
                }
        if(ans==0)
            for(int j = 0;j<matrix.length;j++)
                if(matrix[j][0]=='1'){
                    ans = 1;
                    break;
                }
        return ans*ans;
    }
}