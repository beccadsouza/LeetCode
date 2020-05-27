package _1046;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/13/20
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones) heap.add(i);
        while(heap.size()>1){
            int y = heap.poll();
            int x = heap.poll();
            if(x!=y) heap.add(y-x);
        }
        return heap.size()==0?0:heap.poll();
    }
}