package _532;

import java.util.*;

/*
* Created by Rebecca Dsouza on 10/3/20
*/

public class KdiffPairsInAArray {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findPairs(new int[]{3,1,4,1,5},2));
        System.out.println(sol.findPairs(new int[]{1,2,3,4,5},1));
        System.out.println(sol.findPairs(new int[]{1,3,1,5,4},0));
        System.out.println(sol.findPairs(new int[]{1,2,4,4,3,3,0,9,2,3},3));
        System.out.println(sol.findPairs(new int[]{-1,-2,-3},1));
    }
}
class Solution {
    int ans = 0;
    public int findPairs(int[] nums, int k) {
        Map<Integer,Boolean> vis = new HashMap<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
            vis.put(num, false);
        }
        for (int num : nums)
            if (!vis.get(num))
                if ((k == 0 && hm.get(num) > 1) || (k != 0 && hm.getOrDefault(num - k, 0) > 0)) {
                    ans++;
                    vis.put(num, true);
                }
        return ans;
    }
}