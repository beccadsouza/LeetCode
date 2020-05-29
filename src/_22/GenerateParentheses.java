package _22;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/28/20
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generateParenthesis(3));
    }
}
class Solution {
    List<String> ans = new ArrayList<>();
    public void function(String x, int open, int close){
        if(open==0 && close==0) ans.add(x);
        else{
            if(open!=0) function(x+"(", open-1, close);
            if(open<close || open==0) function(x+")", open, close-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        function("", n, n);
        return ans;
    }
}