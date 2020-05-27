package _678;

/*
 * Created by Rebecca Dsouza on 4/16/20
 */
public class ValidParenthesisString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.checkValidString("()"));
    }
}
class Solution {
    public boolean function(StringBuilder stack, String s, int index){
        if(index==s.length()) return stack.length() == 0;
        else{
            if(s.charAt(index)=='(') {
                stack.append("(");
                return function(stack, s, index+1);
            }
            else if(s.charAt(index)==')'){
                if(stack.length()!=0 && stack.charAt(stack.length()-1)=='('){
                    stack.delete(stack.length()-1, stack.length());
                    return function(stack, s, index+1);
                }
                else return false;
            }
            else{
                StringBuilder temp1 = new StringBuilder(stack);
                temp1.append("(");
                StringBuilder temp2 = new StringBuilder(stack);
                if(temp2.length()!=0 && temp2.charAt(temp2.length()-1)=='('){
                    temp2.delete(temp2.length()-1, temp2.length());
                }
                return function(temp1, s, index+1) || function(temp2, s, index+1) || function(stack, s, index+1);
            }
        }
    }
    public boolean checkValidString(String s) {
        StringBuilder stack = new StringBuilder();
        return function(stack, s, 0);
    }
}
