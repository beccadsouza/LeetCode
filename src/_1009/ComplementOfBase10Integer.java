package _1009;

/*
 * Created by Rebecca Dsouza on 5/4/20
 */
public class ComplementOfBase10Integer {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.bitwiseComplement(5));
        System.out.println(sol.bitwiseComplement(7));
        System.out.println(sol.bitwiseComplement(10));
    }
}
class Solution {
    public int bitwiseComplement(int num) {
        String bin = Integer.toBinaryString(num);
        int ans = 0, b = bin.length(), pow=1;
        for(int i = b-1;i>=0;i--){
            if(bin.charAt(i)=='0') ans += pow;
            pow *= 2;
        }
        return ans;
    }
}