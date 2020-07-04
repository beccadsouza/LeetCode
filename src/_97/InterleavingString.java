package _97;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 7/2/20
 */
public class InterleavingString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
class Solution {
    Map<String, Boolean> memo = new HashMap<>();
    public boolean function(int i1, int i2, int i3, String s1, String s2, String s3){
        if(i1==s1.length() && i2==s2.length()) return i3 == s3.length();
        if(i3==s3.length()) return false;
        boolean ans = false;
        String key = i1+":"+i2+":"+i3;
        if(memo.containsKey(key)) return memo.get(key);
        if(i1<s1.length() && s1.charAt(i1)==s3.charAt(i3)) ans = function(i1 + 1,i2, i3 + 1,s1,s2,s3);
        if(i2<s2.length() && s2.charAt(i2)==s3.charAt(i3)) ans = ans || function(i1,i2+1,i3+1,s1,s2,s3);
        memo.put(key, ans);
        return ans;
    }
    public boolean isInterleave(String str1, String str2, String str3) {
        return function(0,0,0,str1,str2,str3);
    }
}