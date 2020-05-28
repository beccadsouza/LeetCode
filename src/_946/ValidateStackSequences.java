package _946;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/25/20
 */
public class ValidateStackSequences {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
        System.out.println(sol.validateStackSequences(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }
}
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int ptr1 = 0, ptr2=0;
        while(ptr1<pushed.length){
            stack.push(pushed[ptr1]);
            ptr1++;
            while(!stack.isEmpty() && stack.peek()==popped[ptr2]){
                stack.pop();
                ptr2++;
            }
        }
        return stack.isEmpty();
    }
}