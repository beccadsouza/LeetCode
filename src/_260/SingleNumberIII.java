package _260;
import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/4/20
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.singleNumber(new int[]{1,2,1,3,2,5})));
    }
}
class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length==2) return nums;
        int xor = 0, xor1 = 0, xor2 = 0, pos =0, temp = 0;
        for(int x:nums) xor ^= x;
        String XOR = Integer.toBinaryString(xor);
        pos = XOR.length() - XOR.lastIndexOf("1") - 1;
        for(int x:nums){
            temp = x >> pos;
            if((temp&1)==1) xor1 ^= x;
            else xor2 ^= x;
        }
        return new int[]{xor1,xor2};
    }
}