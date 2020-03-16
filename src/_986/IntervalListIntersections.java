package _986;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 3/16/20
 */
public class IntervalListIntersections {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.intervalIntersection(
                        new int[][]{{0,2},{5,10},{13,23},{24,25}},
                        new int[][]{{1,5},{8,12},{15,24},{25,26}})
        ));
    }
}

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> al = new ArrayList<>();
        int[] tempA, tempB;
        int a=0,b=0;
        while(a!=A.length && b!=B.length){
            tempA = A[a];
            tempB = B[b];
            boolean cond1 = (tempA[0]<=tempB[0])&&(tempB[0]<=tempA[1]);
            boolean cond2 = (tempB[0]<=tempA[0])&&(tempA[0]<=tempB[1]);
            if(cond1 || cond2){
                int lowerRange = Math.max(tempA[0],tempB[0]);
                int higherRange = Math.min(tempA[1],tempB[1]);
                al.add(new int[]{lowerRange, higherRange});
            }
            if(tempA[1]<tempB[1]) a+=1;
            else b+=1;
        }
        return al.toArray(new int[al.size()][]);
    }
}