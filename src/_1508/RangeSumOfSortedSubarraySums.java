package _1508;
/*
* Created by Rebecca Dsouza on 7/11/20
*/

import java.util.*;

public class RangeSumOfSortedSubarraySums {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.rangeSum(new int[]{1,2,3,4}, 4,1,5));
        System.out.println(sol.rangeSum(new int[]{1,2,3,4}, 4,3,4));
        System.out.println(sol.rangeSum(new int[]{1,2,3,4}, 4,1,10));
    }
}
class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int rangeSum(int[] nums, int n, int left, int right) {
        int index = 1, elem, sum = 0, mod = 1000000007;
        for(int i = 0;i<nums.length;i++){
            int temp = 0;
            for(int j = i;j<nums.length;j++){
                temp += nums[j];
                pq.add(temp);
            }
        }
        while(pq.size()!=0){
            elem = pq.poll();
            if(index>=left && index<=right){
                sum = sum%mod + elem%mod;
            }
            index++;
            if(index>right) break;
        }
        return sum;
    }
}