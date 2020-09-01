package _442;
/*
* Created by Rebecca Dsouza on 8/7/20
*/
import java.util.*;
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> al = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0) nums[index] = -1*nums[index];
        }
        for(int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            nums[index] = -1*nums[index];
        }
        for(int i = 0;i<nums.length;i++) if(nums[i]<0) al.add(i+1);
        return al;
    }
}