package _1413;
/*
 * Created by Rebecca Dsouza on 4/18/20
 */
public class MinimumValueToGetPositiveStepByStepBySum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minStartValue(new int[]{-3,2,-3,4,2}));
        System.out.println(sol.minStartValue(new int[]{1,2}));
        System.out.println(sol.minStartValue(new int[]{1,-2,-3}));
    }
}
class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            min = Math.min(min, temp);
        }
        if(min>0) return 1;
        else return Math.abs(min)+1;
    }
}