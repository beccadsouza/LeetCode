package _459;
/*
* Created by Rebecca Dsouza on 9/3/20
*/
import java.util.*;
public class RepeatedSubstringPattern {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.repeatedSubstringPattern("abab"));
        System.out.println(sol.repeatedSubstringPattern("aba"));
        System.out.println(sol.repeatedSubstringPattern("abcabcabcabc"));
    }
}
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        Set<String> temp;
        int size = s.length();
        for(int i = size/2;i>0;i--){
            if(size%i==0){
                temp = new HashSet<>();
                for(int j = 0;j<size;j+=i) temp.add(s.substring(j,j+i));
                if(temp.size()==1) return true;
            }
        }
        return false;
    }
}