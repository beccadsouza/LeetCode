package _136;
/*
 * Created by Rebecca Dsouza on 4/1/20
 */
public class SingleNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(new int[]{2,2,1}));
        System.out.println(sol.singleNumber(new int[]{4,1,2,1,2}));
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int x:nums) xor ^= x;
        return xor;
    }
}