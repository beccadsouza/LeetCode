package _201;
/*
 * Created by Rebecca Dsouza on 4/24/20
 */
public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rangeBitwiseAnd(5,7));
        System.out.println(sol.rangeBitwiseAnd(0,1));
    }
}
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int noOfBits = 0;
        while(m!=n){
            m = m>>1;
            n = n>>1;
            noOfBits++;
        }
        m = m<<noOfBits;
        return m;
    }
}