package _441;
/*
 * Created by Rebecca Dsouza on 7/1/20
 */
public class ArrangingCoins {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.arrangeCoins(5));
        System.out.println(sol.arrangeCoins(8));
    }
}
class Solution {
    public int arrangeCoins(int n) {
        long start = 0, end = n, k, value;
        while(start<=end){
            k = start + (end-start)/2;
            value = k*(k+1)/2;
            if(value==n) return (int)k;
            if(n<value) end = k-1;
            else start = k+1;
        }
        return (int)end;
    }
}