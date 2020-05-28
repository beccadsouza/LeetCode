package _1021;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 4/25/20
 */
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeOuterParentheses("(()())(())"));
        System.out.println(sol.removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(sol.removeOuterParentheses("()()"));
    }
}
class Solution {
    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int open = 0, close = 0;
        for(char x: S.toCharArray()){
            if(stack.size()==0) stack.push(x);
            else{
                if(x=='(') {
                    sb.append('(');
                    open++;
                }
                else{
                    if(open==close) stack.pop();
                    else{
                        sb.append(')');
                        close++;
                    }
                }
            }
        }
        return sb.toString();
    }
}