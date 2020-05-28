package _1047;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/25/20
 */
public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates("abbaca"));
    }
}
class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char x: S.toCharArray()){
            if(stack.size()==0) stack.push(x);
            else{
                if(x==stack.peek()) stack.pop();
                else stack.push(x);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char x: stack) sb.append(x);
        return sb.toString();
    }
}