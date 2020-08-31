package _1222;
/*
* Created by Rebecca Dsouza on 7/14/20
*/

import java.util.*;

public class QueensThatCanAttackTheKing {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(
            sol.queensAttacktheKing(
                new int[][]{{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}},
                new int[]{0,0}
            )
        );
    }
}
class Solution{
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king){
        List<List<Integer>> al = new ArrayList<>();
        int x = king[0], y = king[1];
        int[][] board = new int[8][8];
        for(int[] q:queens) board[q[0]][q[1]] = 1;

        for(int i=x-1,j=y;i>=0;i--)        //north
            if(board[i][j]==1){
                al.add(Arrays.asList(new Integer[]{i,j}));
                break;
            }

        for(int i=x+1,j=y;i<8;i++)        //south
            if(board[i][j]==1){
                al.add(Arrays.asList(new Integer[]{i,j}));
                break;
            }

        for(int i=x,j=y+1;j<8;j++)        //east
            if(board[i][j]==1){
                al.add(Arrays.asList(i,j));
                break;
            }

        for(int i=x,j=y-1;j>=0;j--)        //west
            if(board[i][j]==1){
                al.add(Arrays.asList(i,j));
                break;
            }

        for(int i=x-1,j=y+1;i>=0&&j<8;i--,j++)        //norteast
            if(board[i][j]==1){
                al.add(Arrays.asList(i,j));
                break;
            }

        for(int i=x+1,j=y+1;i<8&&j<8;i++,j++)        //southeast
            if(board[i][j]==1){
                al.add(Arrays.asList(i,j));
                break;
            }

        for(int i=x+1,j=y-1;i<8&&j>=0;i++,j--)        //southwest
            if(board[i][j]==1){
                al.add(Arrays.asList(i,j));
                break;
            }

        for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--)        //northwest
            if(board[i][j]==1){
                al.add(Arrays.asList(i,j));
                break;
            }

        return al;
    }
}