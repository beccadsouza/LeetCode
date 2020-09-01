package _130;
/*
* Created by Rebecca Dsouza on 7/21/20
*/

public class SurroundedRegions {
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.solve(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}});
    }
}
class Solution {
    boolean[][] visited;
    char[][] board;
    public void function(int i, int j){
        if(i==-1 || j==-1 || i==board.length || j==board[0].length) return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        if(board[i][j]=='O'){
            board[i][j] = 'P';
            function(i+1,j);
            function(i,j+1);
            function(i-1,j);
            function(i,j-1);
        }
    }
    public void solve(char[][] board) {
        if(board.length==0) return;
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        for(int i = 0,j=0;j<board[0].length;j++) if(board[i][j]=='O') function(i, j);
        for(int i=board.length-1,j=0;j<board[0].length;j++) if(board[i][j]=='O') function(i, j);
        for(int i=0,j=0;i<board.length;i++) if(board[i][j]=='O') function(i, j);
        for(int i=0,j=board[0].length-1;i<board.length;i++) if(board[i][j]=='O') function(i, j);
        for(int i = 0;i<board.length;i++)
            for(int j = 0;j<board[0].length;j++) board[i][j] = (board[i][j]=='P')?'O':'X';
    }
}