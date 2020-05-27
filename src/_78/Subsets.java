package _78;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/27/20
 */
public class Subsets {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subsets(new int[]{1,2,3}));
    }
}
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<Math.pow(2, nums.length);i++){
            String temp = Integer.toBinaryString(i);
            ArrayList<Integer> al = new ArrayList<>();
            for(int j = nums.length-temp.length(),k=0;j<nums.length;j++,k++){
                if(temp.charAt(k)=='1'){
                    al.add(nums[j]);
                }
            }
            ans.add(al);
        }
        return ans;
    }
}