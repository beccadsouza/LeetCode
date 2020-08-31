package _50;
/*
* Created by Rebecca Dsouza on 7/17/20
*/

public class Pow_x_n {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.myPow(2.0,10));
        System.out.println(sol.myPow(2.1,3));
        System.out.println(sol.myPow(2.0,-2));
    }
}
class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }
}