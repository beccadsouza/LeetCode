package _451;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/22/20
 */
public class SortCharactersByFrequency {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.frequencySort("tree"));
        System.out.println(sol.frequencySort("cccaaa"));
        System.out.println(sol.frequencySort("Aabb"));
    }
}
class Solution {
    Map<Character, Integer> hm = new HashMap<>();
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
    public String frequencySort(String s) {
        StringBuilder str = new StringBuilder();
        for(char x:s.toCharArray()) hm.put(x, hm.getOrDefault(x, 0)+1);
        pq.addAll(hm.entrySet());
        while(pq.size()!=0){
            Map.Entry<Character, Integer> x = pq.poll();
            str.append(String.valueOf(x.getKey()).repeat(Math.max(0, x.getValue())));
        }
        return str.toString();
    }
}