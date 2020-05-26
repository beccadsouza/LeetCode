package _367;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/9/20
 */
public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPerfectSquare(16));
        System.out.println(sol.isPerfectSquare(14));
    }
}
class Solution {
    public boolean isPerfectSquare(int x) {
        if(x==1) return true;
        long start = 2, end = x/2, mid, temp;
        while(start<=end){
            mid = start + (end-start)/2;
            temp = mid*mid;
            if(temp==x) return true;
            else if(temp<x) start = mid+1;
            else end = mid-1;
        }
        return false;
    }
}