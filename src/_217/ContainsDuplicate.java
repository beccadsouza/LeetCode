package _217;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 3/28/20
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(sol.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(sol.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int x:nums)
            if(hs.contains(x)) return true;
            else hs.add(x);
        return false;
    }
}