package _124;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/7/20
 */
public class CountingElements {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countElements(new int[]{1,2,3}));
        System.out.println(sol.countElements(new int[]{1,1,3,3,5,5,7,7}));
        System.out.println(sol.countElements(new int[]{1,3,2,3,5,0}));
        System.out.println(sol.countElements(new int[]{1,1,2,2}));
    }
}

class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for(int x: arr) hs.add(x);
        int ans = 0;
        for(int x:arr) if(hs.contains(x+1)) ans ++;
        return ans;
    }
}