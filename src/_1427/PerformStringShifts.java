package _1427;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/14/20
 */
public class PerformStringShifts {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.stringShift("abc",new int[][]{{0,1},{1,2}}));
        System.out.println(sol.stringShift("abcdefg",new int[][]{{1,1},{1,1},{0,2},{1,3}}));
    }
}

class Solution {
    public String stringShift(String s, int[][] shift) {
        int amtFinal = 0, dirFinal;
        for (int[] ints : shift) {
            int dir = ints[0];
            int amt = ints[1];
            if (dir == 1) amtFinal -= amt;
            else amtFinal += amt;
        }
        dirFinal = (amtFinal>=0)?0:1;
        amtFinal = Math.abs(amtFinal)%s.length();
        if(dirFinal==0) return s.substring(amtFinal) + s.substring(0, amtFinal);
        else return s.substring(s.length()-amtFinal) + s.substring(0, s.length()-amtFinal);
    }
}