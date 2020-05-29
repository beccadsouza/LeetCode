package _476;

/*
 * Created by Rebecca Dsouza on 5/4/20
 */
public class NumberComplement {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findComplement(5));
        System.out.println(sol.findComplement(1));
    }
}
class Solution {
    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        int ans = 0, b = bin.length(), pow=1;
        for(int i = b-1;i>=0;i--){
            if(bin.charAt(i)=='0') ans += pow;
            pow *= 2;
        }
        return ans;
    }
}