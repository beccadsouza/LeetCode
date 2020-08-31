package _1344;
/*
* Created by Rebecca Dsouza on 7/14/20
*/

public class AngleBetweenHandsOfAClock {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.angleClock(12,30));
        System.out.println(sol.angleClock(3,30));
        System.out.println(sol.angleClock(3,15));
        System.out.println(sol.angleClock(4,50));
        System.out.println(sol.angleClock(12,0));
    }
}
class Solution {
    public double angleClock(int hour, int min) {
        double diff = Math.abs(6*(5*(hour%12) + (double)min/12 - min));
        return Math.min(diff, 360-diff);
    }
}