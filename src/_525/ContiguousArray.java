package _525;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/13/20
 */
public class ContiguousArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMaxLength(new int[]{0,1}));
        System.out.println(sol.findMaxLength(new int[]{0,1,0}));
    }
}
class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        int count = 0, ans = 0;
        for(int i=0;i<nums.length;i++){
            count += nums[i]==1?1:-1;
            if(!hm.containsKey(count)) hm.put(count,new ArrayList<Integer>());
            hm.get(count).add(i);
        }
        if(hm.containsKey(0)) ans = hm.get(0).get(hm.get(0).size()-1)+1;
        for(ArrayList<Integer> x:hm.values()) if(x.size()>1) ans = Math.max(ans, x.get(x.size()-1)-x.get(0));
        return ans;
    }
}

