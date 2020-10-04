package _1288;
import java.util.*;
/*
* Created by Rebecca Dsouza on 10/4/20
*/
public class RemoveCoveredIntervals {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.removeCoveredIntervals(new int[][]{{1,4},{3,6},{2,8}}));
        System.out.println(sol.removeCoveredIntervals(new int[][]{{1,4},{2,3}}));
        System.out.println(sol.removeCoveredIntervals(new int[][]{{0,10},{5,12}}));
        System.out.println(sol.removeCoveredIntervals(new int[][]{{3,10},{4,10},{5,11}}));
        System.out.println(sol.removeCoveredIntervals(new int[][]{{1,2},{1,4},{3,4}}));
        System.out.println(sol.removeCoveredIntervals(new int[][]{{1,4},{4,7},{3,6}}));
    }
}
class Interval {
    int start,end;
    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
    public String toString(){
        return "[" + this.start + "," + this.end + "]";
    }
}
class Solution {
    int ans = 0;
    PriorityQueue<Interval> pq = new PriorityQueue<>(
            (A, B) -> (A.start!=B.start)?(A.start-B.start):(B.end-A.end)
    );
    public int removeCoveredIntervals(int[][] intervals) {
        for(int[] interval:intervals) pq.add(new Interval(interval[0],interval[1]));
        while(pq.size()>1){
            Interval interval1 = pq.poll();
            Interval interval2 = pq.poll();
            if(!(interval1.start <= interval2.start && interval2.end<=interval1.end)){
                ans++;
                pq.add(interval2);
            }
            else pq.add(interval1);
        }
        return ans + 1;
    }
}