package _125;
/*
* Created by Rebecca Dsouza on 8/4/20
*/

public class ValidPalindrome {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sol.isPalindrome("race a car"));
    }
}
class Solution {
    public boolean isAscii(char x){
        return (x>=97 && x<=122) || (x>=65 && x<=90) || (x>=48 && x<=57);
    }
    public char lower(char x){
        return Character.toLowerCase(x);
    }
    public boolean isPalindrome(String s) {
        int F = 0, R = s.length()-1;
        while(F<R){
            while(F<R && isAscii(s.charAt(F))) F++;
            while(R>F && isAscii(s.charAt(R))) R--;
            if(lower(s.charAt(F))!=lower(s.charAt(R))) return false;
            F++;
            R--;
        }
        return true;
    }
}