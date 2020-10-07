package _1606;
/*
* Created by Rebecca Dsouza on 10/7/20
*/
import java.util.*;
public class FindServersThatHandledMostNumberOfRequests {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.busiestServers(3,new int[]{1,2,3,4,5},new int[]{5,2,3,3,3}));
        System.out.println(sol.busiestServers(3,new int[]{1,2,3,4},new int[]{1,2,1,2}));
        System.out.println(sol.busiestServers(3,new int[]{1,2,3},new int[]{10,11,12}));
        System.out.println(sol.busiestServers(3,new int[]{1,2,3,4,8,9,10},new int[]{5,2,10,3,1,2,2}));
        System.out.println(sol.busiestServers(1,new int[]{1},new int[]{1}));
    }
}
class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    TreeSet<Integer> ts = new TreeSet<>();
    List<Integer> ans = new ArrayList<>();
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] busy = new int[k];
        int max = 0;
        for(int i = 0;i<k;i++) ts.add(i);
        for(int i = 0;i<arrival.length;i++){
            int start = arrival[i];
            int end = arrival[i] + load[i];
            while(!pq.isEmpty() && pq.peek()[0]<=start) ts.add(pq.poll()[1]);
            if(ts.size()==0) continue;
            Integer server = ts.ceiling(i%k);
            if(server==null) server = ts.first();
            busy[server]++;
            ts.remove(server);
            max = Math.max(busy[server],max);
            pq.add(new int[]{end,server});
        }
        for(int i=0;i<k;i++) if(busy[i]==max) ans.add(i);
        return ans;
    }
}