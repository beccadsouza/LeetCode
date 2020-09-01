package _342;
/*
* Created by Rebecca Dsouza on 8/4/20
*/

public class PowerOfFour {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfFour(16));
        System.out.println(sol.isPowerOfFour(5));
    }
}
class Solution {
    public boolean isPowerOfFour(int num) {
        double x = Math.log(num)/Math.log(4);
        return (x-(double)(int)x)==(0.0);
    }
}