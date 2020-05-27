package _20;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/10/20
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid("()"));
        System.out.println(sol.isValid("()[]{}"));
        System.out.println(sol.isValid("(]"));
        System.out.println(sol.isValid("([)]"));
        System.out.println(sol.isValid("{[]}"));
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char x:s.toCharArray()){
            if(x=='(' || x=='{' || x=='[') stack.push(x);
            else{
                if(stack.size()==0) return false;
                if(x==')' && stack.peek()=='(') stack.pop();
                else if(x=='}' && stack.peek()=='{') stack.pop();
                else if(x==']' && stack.peek()=='[') stack.pop();
                else return false;
            }
        }
        if(stack.size()==0) return true;
        return false;
    }
}
