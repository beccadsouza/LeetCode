package _289;
/*
 * Created by Rebecca Dsouza on 4/28/20
 */
public class GameOfLife {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.gameOfLife(
            new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}

            }
        );
    }
}
class Solution {
    public void gameOfLife(int[][] board) {
        // live and became dead     3   0
        // live and remains live    1   1
        // dead and became live     2   1
        // dead and remains dead    0   0
        int[] x = new int[]{-1,-1,-1,0,0,+1,+1,+1};
        int[] y = new int[]{-1,0,+1,-1,+1,-1,0,+1};
        for(int i = 0;i<board.length;i++)
            for(int j = 0;j<board[0].length;j++){
                int live = 0;
                for(int k = 0;k<8;k++){
                    if(0<=(i+x[k]) && (i+x[k])<board.length){
                        if(0<=(j+y[k]) && (j+y[k])<board[0].length){
                            if(board[i+x[k]][j+y[k]]%2==0) ;
                            else live++;
                        }
                    }
                }
                if(board[i][j]==1 && live<2) board[i][j] = 3;
                else if(board[i][j]==1 && live>3) board[i][j] = 3;
                else if(board[i][j]==0 && live==3) board[i][j] = 2;
            }
        for(int i = 0;i<board.length;i++)
            for(int j = 0;j<board[0].length;j++)
                if(board[i][j]==3) board[i][j] = 0;
                else if(board[i][j]==2) board[i][j]=1;
    }
}