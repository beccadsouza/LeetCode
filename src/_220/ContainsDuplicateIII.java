package _220;
/*
* Created by Rebecca Dsouza on 9/2/20
*/
import java.util.*;
public class ContainsDuplicateIII {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{1,2,3,1},3,0));
        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{1,0,1,1},1,2));
        System.out.println(sol.containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9},2,3));
    }
}
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<0 || t<0) return false;
        Map<Integer,Integer> hm = new HashMap<>();
        int b = t+1, n = nums.length;
        for(int i = 0; i<n; i++){
            int v = (nums[i]<0)?(nums[i]+1)/b-1:nums[i]/b;
            if(hm.containsKey(v)) return true;
            else if(hm.containsKey(v-1) && Math.abs(hm.get(v-1)-nums[i])<b) return true;
            else if(hm.containsKey(v+1) && Math.abs(hm.get(v+1)-nums[i])<b) return true;
            hm.put(v,nums[i]);
            if(i>=k) hm.remove(nums[i-k]/b);
        }
        return false;
    }
}