package _1523;
/*
* Created by Rebecca Dsouza on 7/25/20
*/

public class CountOddNumbersInAnIntervalRange {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.countOdds(3,7));
        System.out.println(sol.countOdds(8,10));
    }
}
class Solution {
    public int countOdds(int low, int high) {
        if(low%2==0 && high%2==0){ // even
            return (high-low)/2;
        }
        else if(low%2==1 && high%2==1){ // odd
            return (high-low)/2 + 1;
        }
        else{
            return (high-low)/2 + 1;
        }
    }
}