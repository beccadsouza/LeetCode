package _1422;
/*
 * Created by Rebecca Dsouza on 4/26/20
 */
public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxScore("011101"));
        System.out.println(sol.maxScore("00111"));
        System.out.println(sol.maxScore("1111"));
    }
}
class Solution {
    public int maxScore(String s) {
        int[] zeros = new int[s.length()];
        int[] ones = new int[s.length()];
        int zero = 0, one=0, ans = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='0') zero++;
            zeros[i] = zero;
        }
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1') one++;
            ones[i] = one;
        }
        zero = 0; one = 1;
        while(one!=s.length()){
            ans = Math.max(ans, zeros[zero] + ones[one]);
            zero++;
            one++;
        }
        return ans;
    }
}