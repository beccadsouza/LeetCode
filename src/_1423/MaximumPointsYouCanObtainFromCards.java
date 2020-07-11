package _1423;
/*
* Created by Rebecca Dsouza on 7/8/20
*/

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxScore(new int[]{1,2,3,4,5,6,1},3));
        System.out.println(sol.maxScore(new int[]{2,2,2},2));
        System.out.println(sol.maxScore(new int[]{9,7,7,9,7,7,9},7));
        System.out.println(sol.maxScore(new int[]{1,1000,1},1));
        System.out.println(sol.maxScore(new int[]{1,79,80,1,1,1,200,1},3));
    }
}
class Solution {
    public int maxScore(int[] c, int k) {
        for(int i = 1;i<c.length;i++) c[i] += c[i-1];
        if(k==c.length) return c[c.length-1];
        int n = c.length, sum = c[n-1], max = sum-c[n-1-k];
        for(int i = n-k;i<n;i++) max = Math.max(max,sum-c[i]+c[i-n+k]);
        return max;
    }
}