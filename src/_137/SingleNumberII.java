package _137;

/*
 * Created by Rebecca Dsouza on 4/4/20
 */
public class SingleNumberII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(new int[]{2,2,3,2}));
        System.out.println(sol.singleNumber(new int[]{0,1,0,1,0,1,99}));
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        String bitstring;
        boolean bitmet, negative = false;
        int start;
        double ans = 0;
        int[] bits = new int[32];
        for(int x:nums){
            bitstring = Integer.toBinaryString(x);
            start = bitstring.length()-1;
            for(char y:bitstring.toCharArray()){
                if(y=='1') bits[start] = (bits[start]+1)%3;
                start--;
            }
        }
        if(bits[31]==1){
            negative = true;
            bitmet = false;
            for(int i=0;i<32;i++)
                if(!bitmet){
                    if(bits[i]==1) bitmet = true;
                }
                else bits[i] = 1-bits[i];
        }
        for(int i=0;i<32;i++) ans += Math.pow(2,i)*bits[i];
        if(negative) ans *= -1;
        return (int)ans;
    }
}