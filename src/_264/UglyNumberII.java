package _264;

/*
 * Created by Rebecca Dsouza on 7/5/20
 */
public class UglyNumberII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.nthUglyNumber(10));
    }
}
class Solution {
    public int nthUglyNumber(int n) {
        int i2 = 0, i3 = 0, i5 = 0;
        int[] ugly = new int[n];
        ugly[0] = 1;
        for(int i = 1;i<n;i++){
            ugly[i] = Math.min(Math.min(2*ugly[i2],3*ugly[i3]),5*ugly[i5]);
            if(ugly[i]==2*ugly[i2]) i2++;
            if(ugly[i]==3*ugly[i3]) i3++;
            if(ugly[i]==5*ugly[i5]) i5++;
        }
        return ugly[n-1];
    }
}
