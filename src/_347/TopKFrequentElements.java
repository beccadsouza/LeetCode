package _347;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/8/20
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
class Tuple{
    int val,freq;
    public Tuple(int val, int freq){
        this.val = val;
        this.freq = freq;
    }
    public String toString(){
        return "(" + this.val + ":" + this.freq + ")";
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
        List<Integer> al = new ArrayList<>();
        for(int x:nums) hm.put(x,hm.getOrDefault(x,0)+1);
        for(Map.Entry<Integer,Integer> x:hm.entrySet()) pq.add(new Tuple(x.getKey(),x.getValue()));
        for(int i = 0;i<k;i++)al.add(pq.poll().val);
        return al.stream().mapToInt(Integer::valueOf).toArray();
    }
}