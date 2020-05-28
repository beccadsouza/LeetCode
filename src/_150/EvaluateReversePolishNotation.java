package _150;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/25/20
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(sol.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(sol.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String x: tokens){
            if(x.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            }
            else if(x.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }
            else if(x.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push((int)Math.floor(b/a));
            }
            else if(x.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            }
            else stack.push(Integer.parseInt(x));
        }
        return stack.pop();
    }
}