package _973;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/31/20
 */
public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.deepToString(sol.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
        System.out.println(Arrays.deepToString(sol.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));
    }
}
class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }
}
class PairComparator implements Comparator<Pair>{
    public int compare(Pair p1, Pair p2){
        int val1 = p1.x*p1.x + p1.y*p1.y;
        int val2 = p2.x*p2.x + p2.y*p2.y;
        return val1 - val2;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        for(int[] p:points) pq.add(new Pair(p[0],p[1]));
        for(int i = 0;i<K;i++){
            Pair p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
        }
        return ans;
    }
}