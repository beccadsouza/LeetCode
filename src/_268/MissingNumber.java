package _268;

/*
 * Created by Rebecca Dsouza on 3/17/20
 */
public class MissingNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.missingNumber(new int[]{3,0,1}));
        System.out.println(sol.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
class Solution {
    public int missingNumber(int[] nums) {
        int max = nums.length;
        int xor = 0;
        for(int i = 0;i<max+1;i++) xor ^= i;
        for(int x:nums) xor ^=x;
        return xor;
    }
}