package _152;
/*
* Created by Rebecca Dsouza on 9/12/20
*/

public class MaximumProductSubarray {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(new int[]{2,3,-2,4}));
        System.out.println(sol.maxProduct(new int[]{-2,0,-1}));
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int product = 1, maxProduct = Integer.MIN_VALUE;
        for (int num : nums) {
            product *= num;
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) product = 1;
        }
        product = 1;
        for (int i=nums.length-1; i>=0; i--) {
            product *= nums[i];
            maxProduct = Math.max(maxProduct, product);
            if (product == 0) product = 1;
        }
        return maxProduct;
    }
}