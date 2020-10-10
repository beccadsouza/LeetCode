package _452;
/*
* Created by Rebecca Dsouza on 10/10/20
*/
import java.util.*;
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
        System.out.println(sol.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(sol.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));
        System.out.println(sol.findMinArrowShots(new int[][]{{1,2}}));
        System.out.println(sol.findMinArrowShots(new int[][]{{2,3},{2,3}}));
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
//        Arrays.sort(points,(a, b)->Integer.compare(a[1],b[1]));
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int pos=points[0][1], count=1;
        for(int i=1;i<points.length;i++){
            if(pos>=points[i][0]) continue;
            pos = points[i][1];
            count++;
        }
        return count;
    }
}