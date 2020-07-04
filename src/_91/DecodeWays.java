package _91;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 7/2/20
 */
public class DecodeWays {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("12"));
        System.out.println(sol.numDecodings("226"));
    }
}
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int function(String s, int index){
        if(index==s.length()) return 0;
        if(index==s.length()-1) return 1;
        int pair = Integer.parseInt(s.substring(index, index + 2));
        if(index==s.length()-2) {
            if(pair>26) return 1;
            if(pair%10==0) return 1;
            return 2;
        }
        if(memo.containsKey(index)) return memo.get(index);
        int ans = 0;
        if(pair <27)
            if(Integer.parseInt(s.substring(index+2,index+3))!=0) ans += function(s, index+2);
        if(Integer.parseInt(s.substring(index+1,index+2))!=0) ans += function(s, index+1);
        memo.put(index, ans);
        return ans;
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        for(int i = 1;i<s.length();i++)
            if(s.charAt(i)=='0' && s.charAt(i-1)!='1' && s.charAt(i-1)!='2') return 0;
        return function(s, 0);
    }
}