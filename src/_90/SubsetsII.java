package _90;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/6/20
 */
public class SubsetsII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subsetsWithDup(new int[]{1,2,2}));
    }
}
class Solution {
    public String hash(ArrayList<Integer> al){
        Collections.sort(al);
        StringBuilder sb = new StringBuilder();
        for(int x:al) sb.append(Integer.toString(x));
        return sb.toString();
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<String> hs = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<Math.pow(2, nums.length);i++){
            String temp = Integer.toBinaryString(i);
            ArrayList<Integer> al = new ArrayList<>();
            for(int j = nums.length-temp.length(),k=0;j<nums.length;j++,k++)
                if(temp.charAt(k)=='1') al.add(nums[j]);
            temp = hash(al);
            if(!hs.contains(temp)) {
                ans.add(al);
                hs.add(temp);
            }
        }
        return ans;
    }
}