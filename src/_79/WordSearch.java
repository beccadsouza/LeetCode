package _79;

/*
 * Created by Rebecca Dsouza on 5/11/20
 */
public class WordSearch {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(sol.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(sol.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
}
class Solution {
    int R,C;
    String w;
    char[][] b;
    boolean[][] v;
    public boolean function(int x, int y, int pos){
        if(w.charAt(pos)==b[x][y] && pos==w.length()-1) return true;
        else if(w.charAt(pos)==b[x][y]){
            boolean north,south,east,west;
            v[x][y] = true;
            if(x-1>=0 && !v[x-1][y]){
                north = function(x-1,y,pos+1);
                if(north) return true;
            }
            if(x+1<R && !v[x+1][y]){
                south = function(x+1,y,pos+1);
                if(south) return true;
            }
            if(y-1>=0 && !v[x][y-1]){
                west = function(x,y-1,pos+1);
                if(west) return true;
            }
            if(y+1<C && !v[x][y+1]){
                east = function(x,y+1,pos+1);
                if(east) return true;
            }
            v[x][y] = false;
            return false;
        }
        else return false;
    }
    public boolean exist(char[][] board, String word) {
        w = word;
        b = board;
        R = board.length;
        C = board[0].length;
        v = new boolean[R][C];
        for(int i = 0;i<R;i++){
            for(int j=0;j<C;j++){
                boolean ans = function(i, j, 0);
                if(ans) return true;
            }
        }
        return false;
    }
}