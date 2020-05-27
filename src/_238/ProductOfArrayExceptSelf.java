package _238;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/16/20
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeros = 0;
        for(int x:nums) if(x==0) zeros++;
        if(zeros==0){
            int product=1, temp=0, elem=0, ans=0;
            for(int x:nums) product *= x;
            System.out.println(product);
            for(int i = 0;i<nums.length;i++){
                elem = Math.abs(nums[i]);
                temp = Math.abs(product);
                if(elem!=1) ans = (int)Math.round(Math.exp(Math.log(temp)-Math.log(elem)));
                else ans = temp;
                if(nums[i]<0 && product>0 || nums[i]>0 && product<0) ans *= -1;
                nums[i] = ans;
            }
            return nums;
        }
        else if(zeros==1){
            int product=1, index=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0) index = i;
                else{
                    product *= nums[i];
                    nums[i] = 0;
                }
            }
            nums[index] = product;
            return nums;
        }
        else{
            Arrays.fill(nums, 0);
            return nums;
        }
    }
}