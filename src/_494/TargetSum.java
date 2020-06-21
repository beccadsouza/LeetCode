package _494;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/22/20
 */
public class TargetSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length==0) return 0;
        Map<Integer, Integer> hm = new HashMap<>(), temp;
        if(nums[nums.length-1]==0) hm.put(0,2);
        else{
            hm.put(nums[nums.length-1],1);
            hm.put(-nums[nums.length-1],1);
        }
        for(int i = nums.length-2;i>=0;i--){
            temp = new HashMap<>();
            for(Map.Entry<Integer, Integer> x:hm.entrySet()){
                int k = x.getKey();
                int v = x.getValue();
                temp.put(+nums[i]+k, temp.getOrDefault(+nums[i]+k,0)+v);
                temp.put(-nums[i]+k, temp.getOrDefault(-nums[i]+k,0)+v);
            }
            hm = temp;
        }
        return hm.getOrDefault(S,0);
    }
}