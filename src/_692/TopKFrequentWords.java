package _692;
/*
* Created by Rebecca Dsouza on 8/7/20
*/

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
        System.out.println(sol.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
    }
}
class Solution {
    PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                if(!a.getValue().equals(b.getValue())) return b.getValue() - a.getValue();
                else return a.getKey().compareTo(b.getKey());
            });
    Map<String, Integer> hm = new HashMap<>();
    List<String> al = new ArrayList<>();
    public List<String> topKFrequent(String[] words, int k) {
        for(String x:words) hm.put(x,hm.getOrDefault(x,0)+1);
        pq.addAll(hm.entrySet());
        while(!pq.isEmpty() && k--!=0) al.add(pq.poll().getKey());
        return al;
    }
}