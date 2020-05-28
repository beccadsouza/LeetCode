package _496;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 4/25/20
 */
public class NextGreaterElementI {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(sol.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
    }
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        HashMap<Integer, Integer> hm2 = new HashMap<>();
        for(int x:nums1) hm2.put(x, -1);
        for(int i=0;i<nums2.length;i++) if(hm2.containsKey(nums2[i])) hm2.put(nums2[i],i);
        for(int i=0;i<nums1.length;i++){
            int start = hm2.get(nums1[i]);
            ans[i]=-1;
            if(!(start==-1) && !(start==nums2.length-1)){
                start +=1;
                while(start<nums2.length){
                    if(nums2[start]>nums1[i]){
                        ans[i] = nums2[start];
                        break;
                    }
                    start++;
                }
            }
        }
        return ans;
    }
}