package _304;

/*
 * Created by Rebecca Dsouza on 7/3/20
 */
public class RangeSumQuery2DImmutable {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        System.out.println(obj.sumRegion(1, 1, 2, 2));
        System.out.println(obj.sumRegion(1, 2, 2, 4));
    }
}
class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        if(r!=0){
            int c = matrix[0].length;
            sum = new int[r+1][c+1];
            for(int i = 1; i<r+1;i++)
                for(int j = 1; j<c+1;j++)
                    sum[i][j] = sum[i][j-1] + matrix[i-1][j-1];
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i = row1+1; i<=row2+1;i++) ans += sum[i][col2+1] - sum[i][col1];
        return ans;
    }
}

