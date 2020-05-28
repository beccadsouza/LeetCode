package _394;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/25/20
 */
public class DecodeString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.decodeString("3[a]2[bc]"));
        System.out.println(sol.decodeString("3[a2[c]]"));
        System.out.println(sol.decodeString("2[abc]3[cd]ef"));
    }
}
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String temp = "";
        StringBuilder ans = new StringBuilder();
        int end = s.lastIndexOf(']');
        if(end!=s.length()-1){
            temp = s.substring(end+1);
            s = s.substring(0, end+1);
        }
        for(int i = 0;i<s.length();i++){
            StringBuilder k = new StringBuilder();
            StringBuilder encd = new StringBuilder();
            StringBuilder tempp = new StringBuilder();
            if(s.charAt(i)==']'){
                while(!stack.peek().equals("[")) encd.insert(0, stack.pop());
                stack.pop();
                while(stack.size()!=0 && (int)stack.peek().charAt(0)<65) k.insert(0, stack.pop());
                int K = Integer.parseInt(k.toString());
                tempp.append(encd.toString().repeat(Math.max(0, K)));
                stack.push(tempp.toString());
            }
            else stack.push(String.valueOf(s.charAt(i)));
        }
        for(String x: stack) ans.append(x);
        return ans + temp;
    }
}