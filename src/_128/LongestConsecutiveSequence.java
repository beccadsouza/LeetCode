package _128;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/7/20
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashMap<Integer,Integer> freq = new HashMap<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        boolean change = true;
        int count = 0;
        for(int x:nums){
            if(hm.containsKey(x-1)) hm.put(x,hm.get(x-1));
            else if(hm.containsKey(x+1)) hm.put(x,hm.get(x+1));
            else{
                count++;
                hm.put(x,count);
            }
        }
        while(change){
            change = false;
            for(int x:nums)
                if(hm.containsKey(x-1) && !hm.get(x - 1).equals(hm.get(x))){
                    hm.put(x,hm.get(x-1));
                    change = true;
                }
        }
        for(int x:hm.values()) freq.put(x,freq.getOrDefault(x,0)+1);
        return Collections.max(freq.values());
    }
}
/*

parents     1       2   3       4   2   2
nums        100     4   200     1   3   2

parents     1       2   3       2   2   2
nums        100     4   200     1   3   2
*/