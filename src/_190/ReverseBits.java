package _190;
/*
* Created by Rebecca Dsouza on 7/13/20
*/

public class ReverseBits {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.reverseBits(430483048));
    }
}
class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for(int i = 0;i<32;i++){
            ans <<=1;
            ans = ans | (n&1);
            n >>=1;
        }
        return ans;
    }
}