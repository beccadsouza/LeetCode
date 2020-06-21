package _231;

/*
 * Created by Rebecca Dsouza on 6/8/20
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPowerOfTwo(1));
        System.out.println(sol.isPowerOfTwo(16));
        System.out.println(sol.isPowerOfTwo(218));
    }
}
class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while(n!=0){
            if((n&1)==1) count++;
            if(count>1) break;
            n = n>>1;
        }
        return (count==1)?true:false;
    }
}