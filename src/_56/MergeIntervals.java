package _56;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/27/20
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
class Solution {

    public int[][] merge(int[][] intervals) {

        if(intervals.length<=1) return intervals;

        boolean[] include = new boolean[intervals.length];
        int ptr1=0,ptr2=1,ptr3=0,x1,y1,x2,y2,X,Y,count=0;

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        while(true){
            x1 = intervals[ptr1][0]; y1 = intervals[ptr1][1];
            x2 = intervals[ptr2][0]; y2 = intervals[ptr2][1];
            if(x1<=x2 && x2<=y1){
                X = Math.min(x1,x2); Y = Math.max(y1,y2);
                intervals[ptr2][0] = X;intervals[ptr2][1] = Y;

                if(!include[ptr2]) count++;
                include[ptr2] = true;
                if(include[ptr1]){
                    include[ptr1] = false;
                    count--;
                }
            }
            else{
                if(!include[ptr1]) count++;
                include[ptr1] = true;
            }
            ptr1++;
            ptr2++;
            if(ptr2==intervals.length){
                if(!include[ptr1] && x2>y1){
                    include[ptr1] = true;
                    count++;
                }
                break;
            }
        }

        // System.out.println(Arrays.toString(include) + " " + count);
        // System.out.println(Arrays.deepToString(intervals));
        int[][] ans = new int[count][2];
        for(int i =0;i<intervals.length;i++){
            if(include[i]){
                ans[ptr3][0] = intervals[i][0];
                ans[ptr3][1] = intervals[i][1];
                ptr3++;
            }
        }
        return ans;

    }

}