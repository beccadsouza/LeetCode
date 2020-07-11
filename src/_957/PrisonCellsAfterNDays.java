package _957;

import java.util.Arrays;

/*
 * Created by Rebecca Dsouza on 7/3/20
 */
public class PrisonCellsAfterNDays {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.prisonAfterNDays(new int[]{0,1,0,1,1,0,0,1}, 7)));
        System.out.println(Arrays.toString(sol.prisonAfterNDays(new int[]{1,0,0,1,0,0,1,0}, 1000000000)));
    }
}
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int turns = (N%14==0)?14:N%14;
        for(int t=0;t<turns;t++){
            int[] next = new int[cells.length];
            for(int i = 1;i<cells.length-1;i++)
                next[i] = ((cells[i-1]^cells[i+1]) == 0)?1:0;
            cells = next;
        }
        return cells;
    }
}