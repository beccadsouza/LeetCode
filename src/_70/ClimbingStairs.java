package _70;
/*
 * Created by Rebecca Dsouza on 5/8/20
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(2));
        System.out.println(sol.climbStairs(3));
    }
}
class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int one = 1, two = 2, three;
        for(int i = 3;i<=n;i++){
            three = one + two;
            one = two;
            two = three;
        }
        return two;
    }
}