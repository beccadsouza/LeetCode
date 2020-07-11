package _303;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 7/4/20
 */
public class RangeSumQuery {
    public static void main(String[] args) {
        NumArray obj = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(0, 5));
        System.out.println(obj.sumRange(2, 5));
    }
}
class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++) sum[i+1] = sum[i] + nums[i];
    }

    public int sumRange(int i, int j) {
        return sum[j+1]-sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */