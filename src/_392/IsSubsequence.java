package _392;

/*
 * Created by Rebecca Dsouza on 6/10/20
 */
public class IsSubsequence {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isSubsequence("abc","ahbgdc"));
        System.out.println(sol.isSubsequence("axc","ahbgdc"));
    }
}
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        int sPtr = 0, tPtr = 0, sLen = s.length(), tLen = t.length();
        while(sPtr<sLen && tPtr<tLen){
            if(s.charAt(sPtr)==t.charAt(tPtr)) sPtr++;
            if(sPtr==sLen) return true;
            tPtr++;
        }
        return false;
    }
}