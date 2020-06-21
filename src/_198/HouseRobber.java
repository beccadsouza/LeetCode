package _198;

/*
 * Created by Rebecca Dsouza on 6/13/20
 */
public class HouseRobber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rob(new int[]{1,2,3,1}));
        System.out.println(sol.rob(new int[]{2,7,9,3,1}));
    }
}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int p2 = nums[n-1], p1 = nums[n-2], c;
        for(int i = n-3;i>=0;i--){
            c = Math.max(p2 + nums[i], p1);
            p2 = Math.max(p2, p1);
            p1 = c;
        }
        return Math.max(p2, p1);
    }
}